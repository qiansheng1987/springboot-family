package com.qs.libs.qstoolcore.logging.aspect;

import com.qs.libs.qstoolcore.logging.annotation.OperationLogAnnotation;
import com.qs.libs.qstoolcore.logging.enums.OperationTypeEnum;
import com.qs.libs.qstoolcore.logging.model.OperationLog;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * 操作日志切面
 *
 * @author qiansheng
 * @date 2021/9/6 下午3:18
 */
@Slf4j
@Aspect
@Component
public class OperationLogAop {

    /**
     * 定义切点,控制层所有方法
     */
    @Pointcut("@annotation(com.qs.libs.qstoolcore.logging.annotation.OperationLogAnnotation)")
    public void requestPointcut() {
    }

    @Around("requestPointcut()")
    public Object doAround(ProceedingJoinPoint point) throws Throwable {
        // 获取方法
        MethodSignature signature = (MethodSignature) point.getSignature();
        Method method = signature.getMethod();

        // 获取类
        Class<?> clazz = point.getTarget().getClass();

        String methodName = method.getName();
        String clazzName = clazz.getSimpleName();

        // 看有没有日志注解
        OperationLogAnnotation logAnnotation = method.getAnnotation(OperationLogAnnotation.class);
        if (logAnnotation == null) {
            return point.proceed();
        }

        // 看是不是需要记录日志
        if (!logAnnotation.need()) {
            return point.proceed();
        }
        OperationTypeEnum logType = logAnnotation.type();
        // 方法参数，需要记录的信息
        int argsIndex = logAnnotation.argsIndex();
        String[] prefixs = logAnnotation.prefix();
        String[] fields = logAnnotation.field();

        // 方法参数
        Object[] args = point.getArgs();
        if (args == null || args.length - 1 < argsIndex) {
            log.error("记录系统日志时，实际的方法参数和LogAnnotation中定义的方法参数索引不一致，类: {}, 方法: {}",
                    clazzName, methodName);
            return point.proceed();
        }

        // 日志的内容，下面进行拼接
        StringBuilder logContents = new StringBuilder();

        // 需要记录日志的参数对象，如果参数是个集合，则遍历每一个元素进行记录
        Object arg = args[argsIndex];
        if (arg instanceof Collection) {
            Collection as = (Collection) arg;
            for (Object a : as) {
                if (logContents.length() > 0) {
                    logContents.append(";");
                }
                logContents.append(spliceLogContents(a, fields, prefixs));
            }
        } else {
            logContents.append(spliceLogContents(arg, fields, prefixs));
        }

        // 响应头中存放对象
        OperationLog baseLog = new OperationLog();
        baseLog.setLogType(logType);
        baseLog.setTime(new Date());
        baseLog.setContents(logContents.toString());
        baseLog.setSuccess(1);

        Exception ex = null;
        Object proceed = null;
        try {
            proceed = point.proceed();
            baseLog.setSuccess(0);
        } catch (Exception e) {
            baseLog.setSuccess(0);
            baseLog.setErrorReason(e.getMessage());
            ex = e;
        }

        log.error("记录日志: {}", baseLog);
        // 处理保存日志
        // saveLog(baseLog);
        if (ex != null) {
            throw ex;
        }
        // 继续执行
        return proceed;
    }

    /**
     * 利用反射，从对象中，获取属性字段的值，拼接前缀。
     *
     * @param obj     对象
     * @param fields  字段名称集合
     * @param prefixs 前缀集合
     * @return 拼接内容
     * @throws IllegalAccessException 字段访问异常
     */
    private String spliceLogContents(Object obj, String[] fields, String[] prefixs) throws IllegalAccessException {
        // 如果没有定义属性，则直接将对象toString后记录，如果定义了前缀，则拼接上前缀后记录
        if (fields == null || fields.length == 0) {
            if (prefixs != null && prefixs.length > 0) {
                return prefixs[0] + ":" + obj.toString();
            }
            return obj.toString();
        }

        StringBuilder sb = new StringBuilder();

        boolean hasPre = prefixs.length > 0;
        int prefixMaxIndex = prefixs.length - 1;
        int prefixIndex = 0;

        Class<?> aClass = obj.getClass();

        // 如果该对象中找不到属性，则向上父类查找
        Map<String, Field> fieldMap = new HashMap<>();
        for (; aClass != Object.class; aClass = aClass.getSuperclass()) {
            for (Field f : aClass.getDeclaredFields()) {
                fieldMap.putIfAbsent(f.getName(), f);
            }
        }

        Field field;
        Object fieldValue;
        for (int i = 0, len = fields.length; i < len; i++) {
            field = fieldMap.get(fields[i]);
            if (field == null) {
                continue;
            }
            field.setAccessible(true);
            fieldValue = field.get(obj);

            if (sb.length() > 0) {
                sb.append(",");
            }
            if (hasPre) {
                prefixIndex = Math.min(i, prefixMaxIndex);
                sb.append(prefixs[prefixIndex]);
                if (!prefixs[prefixIndex].endsWith(":")) {
                    sb.append(":");
                }
            }
            sb.append(fieldValue == null ? "" : fieldValue);

        }
        return sb.toString();
    }
}

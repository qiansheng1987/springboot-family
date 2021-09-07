package com.qs.libs.pattern.pipeline;


/**
 * IHandler
 *
 * @author qiansheng
 * @date 2021/9/3 上午11:35
 */
public interface IHandler<I, O> {
    O process(I input);
}

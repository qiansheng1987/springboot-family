package com.qs.libs.pattern.pipeline;


/**
 * Pipeline
 *
 * @author qiansheng
 * @date 2021/9/3 上午11:33
 */
public class Pipeline<I, O> {

    private IHandler<I, O> currentHandler;

    public Pipeline(IHandler<I, O> currentHandler) {
        this.currentHandler = currentHandler;
    }

    /**
     * 管道处理
     */
    public O execute(I input) {
        return currentHandler.process(input);
    }

    /**
     * 管道中添加执行器
     */
    <K> Pipeline<I,K> addHandler(IHandler<O, K> newHandler) {
        return new Pipeline<>(input -> newHandler.process(currentHandler.process(input)));
    }

    public IHandler<I, O> getCurrentHandler() {
        return currentHandler;
    }

    public void setCurrentHandler(IHandler<I, O> currentHandler) {
        this.currentHandler = currentHandler;
    }
}

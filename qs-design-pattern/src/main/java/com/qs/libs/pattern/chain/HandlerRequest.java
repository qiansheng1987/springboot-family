package com.qs.libs.pattern.chain;

/**
 * HandlerRequest
 *
 * @author qiansheng
 * @date 2021/9/6 下午1:34
 */
public abstract class HandlerRequest {

    private final HandlerRequest next;

    public HandlerRequest(HandlerRequest handler) {
        this.next = handler;
    }

    public void process() {
        if (null != next) {
            next.process();
        }

    }
}

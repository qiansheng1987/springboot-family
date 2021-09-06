package com.qs.libs.pattern.chain;

/**
 * BlankHandlerRequest
 *
 * @author qiansheng
 * @date 2021/9/6 下午1:42
 */
public class BlankHandlerRequest extends HandlerRequest{

    public BlankHandlerRequest(HandlerRequest handler) {
        super(handler);
    }

    @Override
    public void process() {
        System.out.println("blankHandlerRequest.........");
        super.process();
    }
}

package com.qs.libs.pattern.chain;

/**
 * AlphabetHandlerRequest
 *
 * @author qiansheng
 * @date 2021/9/6 下午1:46
 */
public class AlphabetHandlerRequest extends HandlerRequest{

    public AlphabetHandlerRequest(HandlerRequest handler) {
        super(handler);
    }

    @Override
    public void process() {
        System.out.println("AlphabetHandlerRequest......");
        super.process();
    }
}

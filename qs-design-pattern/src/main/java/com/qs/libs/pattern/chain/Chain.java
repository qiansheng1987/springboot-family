package com.qs.libs.pattern.chain;

/**
 * chain
 *
 * @author qiansheng
 * @date 2021/9/6 下午1:48
 */
public class Chain {

    private HandlerRequest handlerRequest;

    public Chain() {
        buildChain();
    }

    public void makeRequest() {
        handlerRequest.process();
    }

    private void buildChain() {
        handlerRequest = new BlankHandlerRequest(new AlphabetHandlerRequest(null));
    }
}

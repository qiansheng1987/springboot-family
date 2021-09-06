package com.qs.libs.pattern.pipeline;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * TODO
 *
 * @author qiansheng@yunji.ai
 * @date 2021/9/3 下午3:06
 */
public class App {

    public static void main(String[] args) {
        Msg msg = new Msg("test");
        FilterChain filterChain = FilterFactory.getChain();
        filterChain.add(new AlphaFilter()).add(new BlankFilter());
        filterChain.list().forEach(t -> t.doFilter(msg.getMsg()));
    }

    static class Msg {

        public Msg(String msg) {
            this.msg = msg;
        }

        private String msg;

        public String getMsg() {
            return msg;
        }

        public void setMsg(String msg) {
            this.msg = msg;
        }
    }

    static class AlphaFilter implements Filter {


        @Override
        public void doFilter(String msg) {
            System.out.println("alphaFilter...");
        }
    }

    static class BlankFilter implements Filter {
        @Override
        public void doFilter(String msg) {
            System.out.println("blank filter");
        }
    }

    interface Filter {
        void doFilter(String msg);
    }

    static class FilterChain {

        private final List<Filter> filters = new ArrayList<>();

        FilterChain add(Filter filter) {
            filters.add(filter);
            return this;
        }
        List<Filter> list () {
            return Collections.unmodifiableList(filters);
        }
    }

    static class FilterFactory {

        private static FilterChain filterChain;

        private FilterFactory() {
        }

        public static FilterChain getChain() {
            if (null == filterChain) {
                filterChain = new FilterChain();
                return filterChain;
            }
            return filterChain;
        }
    }


}

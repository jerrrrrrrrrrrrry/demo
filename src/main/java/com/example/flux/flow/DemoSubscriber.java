package com.example.flux.flow;

import java.util.concurrent.Flow;

/**
 * @program: demo
 * @description:
 * @author: Gu
 * @create: 2021-10-15 15:21
 **/
public class DemoSubscriber implements Flow.Subscriber{
    private Flow.Subscription subscription;
    @Override
    public void onSubscribe(Flow.Subscription subscription) {
        System.out.println("sub-建立订阅关系第一次调用");
        this.subscription = subscription;
        this.subscription.request(2);
    }

    @Override
    public void onNext(Object item) {
        System.out.println("sub-接受数据:" + item);
//        this.subscription.request(2);

    }

    @Override
    public void onError(Throwable throwable) {
        System.out.println(throwable);
        this.subscription.cancel();
    }

    @Override
    public void onComplete() {
        System.out.println("sub-数据接收完成");
    }
}

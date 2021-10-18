package com.example.flux.flow;

import java.util.concurrent.Flow;
import java.util.concurrent.SubmissionPublisher;

/**
 * @program: demo
 * @description:
 * @author: Gu
 * @create: 2021-10-15 15:32
 **/
public class DemoProcessor extends SubmissionPublisher<String> implements Flow.Processor<String, String> {
    private Flow.Subscription subscription;

    @Override
    public void onSubscribe(Flow.Subscription subscription) {
        System.out.println("process-第一次建立订阅关系");
        this.subscription = subscription;
        this.subscription.request(1);
    }

    @Override
    public void onNext(String item) {
        System.out.println("process-接受到数据" + item);
        item += "-process 处理后的消息";
        this.submit(item);
        this.subscription.request(1);

    }

    @Override
    public void onError(Throwable throwable) {
        System.out.println(throwable);
        this.subscription.cancel();
    }

    @Override
    public void onComplete() {
        System.out.println("process-数据处理完成");
    }

}

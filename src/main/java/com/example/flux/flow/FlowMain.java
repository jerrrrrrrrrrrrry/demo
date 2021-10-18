package com.example.flux.flow;

import java.util.concurrent.Flow;
import java.util.concurrent.SubmissionPublisher;

/**
 * @program: demo
 * @description:
 * @author: Gu
 * @create: 2021-10-15 15:23
 **/
public class FlowMain {
    public static void main(String[] args) throws InterruptedException {
        FlowMain flowMain = new FlowMain();
        flowMain.test1();

    }

    public void test1() throws InterruptedException {
        // 发布者
        SubmissionPublisher<String> publisher = new SubmissionPublisher<>();
        // 订阅者
        Flow.Subscriber subscriber = new DemoSubscriber();

        publisher.subscribe(subscriber);

        for (int i = 0; i < 10; i++) {
            publisher.submit("" + i);
        }
        System.out.println("所有消息发送完成");

        publisher.close();

        System.out.println("p 关闭发送");
        Thread.currentThread().join();

    }
}

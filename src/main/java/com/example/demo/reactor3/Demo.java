package com.example.demo.reactor3;

import reactor.core.publisher.Flux;

import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.CountDownLatch;

/**
 * @program: demo
 * @description:
 * @author: Gu
 * @create: 2021-02-07 15:46
 **/
public class Demo {

    public void fluxGenerateTest() {
        Flux.generate(i -> {
            i.next("AAAAA");
            //i.next("BBBBB");//注意generate中next只能调用1次
            i.complete();
        }).subscribe(System.out::println);

        final Random rnd = new Random();
        Flux.generate(ArrayList::new, (list, item) -> {
            Integer value = rnd.nextInt(100);
            list.add(value);
            item.next(value);
            if (list.size() >= 20) {
                item.complete();
            }
            return list;
        }).subscribe(System.out::println);
    }

    public void fluxCreateTest() {
        Flux.create(i -> {
            i.next("A");
            i.next("B");
            i.complete();
        }).subscribe(System.out::println);

        final Random rnd = new Random();
        Flux.create(item -> {
            for (int i = 0; i < 10; i++) {
                item.next(i);
            }
        }).subscribe(System.out::println);
    }

    public void fluxBufferTest() throws InterruptedException {
//        Flux.range(0, 10).buffer(3).subscribe(System.out::println);

        System.out.println("--------------");

        Flux.interval(Duration.of(1, ChronoUnit.SECONDS))
                .bufferTimeout(2, Duration.of(2, ChronoUnit.SECONDS))
                .subscribe(System.out::println);

        //防止程序过早退出，放一个CountDownLatch拦住
//        CountDownLatch latch = new CountDownLatch(1);
//        latch.await();
    }

    public static void main(String[] args) throws InterruptedException {
        Demo demo = new Demo();
//        demo.fluxGenerateTest();
//        demo.fluxCreateTest();
        demo.fluxBufferTest();
    }

}

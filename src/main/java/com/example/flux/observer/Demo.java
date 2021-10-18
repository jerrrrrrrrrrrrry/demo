package com.example.flux.observer;

import java.util.Observable;
import java.util.Observer;

/**
 * @program: demo
 * @description:
 * @author: Gu
 * @create: 2021-10-15 10:40
 **/
public class Demo {
    public static void main(String[] args) {
        MyObserver myObserver = new MyObserver();
        myObserver.test();
    }
}

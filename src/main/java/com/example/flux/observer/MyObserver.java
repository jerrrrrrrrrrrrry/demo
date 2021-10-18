package com.example.flux.observer;


import java.util.Observable;


/**
 * @program: demo
 * @description:
 * @author: Gu
 * @create: 2021-10-15 10:41
 **/
public class MyObserver extends Observable {
    public void test(){
        MyObserver myObserver = new MyObserver();
        myObserver.addObserver((a, b) -> {
            System.out.println(123);
        });
        myObserver.addObserver((a, b) -> System.out.println(456));
        myObserver.setChanged();
        myObserver.notifyObservers();
    }
}

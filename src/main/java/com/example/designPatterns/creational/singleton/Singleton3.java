package com.example.designPatterns.creational.singleton;

import java.util.Date;

/**
 * @program: demo
 * @description:
 * @author: Gu
 * @create: 2021-10-14 11:22
 **/
public class Singleton3 {

    private Singleton3() {
    }

    // 主要是使用了 嵌套类可以访问外部类的静态属性和静态方法 的特性
    private static class Holder {
        private static Singleton3 instance = new Singleton3();
    }

    public static Singleton3 getInstance() {
        return Holder.instance;
    }

    public static void getDate() {
        System.out.println(new Date());
    }
}
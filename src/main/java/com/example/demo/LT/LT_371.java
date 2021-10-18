package com.example.demo.LT;

/**
 * @program: demo
 * @description:
 * @author: Gu
 * @create: 2021-04-25 14:15
 **/
public class LT_371 {
    public static int getSum(int a, int b) {
        int c = a&b;
        c=c<<1;
        int d = a^b;
        while (c!=0){
            int tmp = d^c;
            c=d&c;
            c=c<<1;
            d=tmp;
        }
        return d;
    }

    public static void main(String[] args) {
        getSum(20,30);
    }

}

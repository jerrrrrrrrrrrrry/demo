package com.example.demo.LT;

/**
 * @program: demo
 * @description:
 * @author: Gu
 * @create: 2021-04-25 14:15
 **/
public class LT_483 {

    public static String smallestGoodBase(String n) {
        long left = 2;
        long right = Long.valueOf(n);
        boolean status = true;
        while (status){
            long now = left+(right-left)/2;
            long res = smallestGoodBaseHelper(Long.valueOf(n),now,0);
            if (res==-1){
                left = now+1;
            }else if (res==0){
                return String.valueOf(now);
            }else {
                right = now-1;
            }
        }
        return "";
    }

    public static long smallestGoodBaseHelper(long n,long a,long s) {
        if (n==0){
            if (s==0) {
                return 0;
            }else {
                return -1;
            }
        }
        long tmp =n%a;
        if (tmp!=1){
            s=-1;
        }
        if (tmp>10){
            return -2;
        } else {
            return smallestGoodBaseHelper(n/a,a,s);
        }
    }

    public static void main(String[] args) {
        smallestGoodBase("4681");
    }

}

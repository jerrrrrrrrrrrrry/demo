package com.example.demo.LT;

/**
 * @program: demo
 * @description:
 * @author: Gu
 * @create: 2021-04-25 14:15
 **/
public class LT_50 {
    public static double myPow(double x, int n) {
        if (n==0){
            return 1;
        }
        if (n==1){
            return x;
        }
        if (n==-1){
            return 1/x;
        }
        return n<0?myPowHelper(1/x,n,1):myPowHelper(x,n,1);
    }

    public static double myPowHelper(double x, int n,int i) {
        if (n==2||n==-2){
            return x*x;
        }
        if (n==3||n==-3){
            return x*x*x;
        }
        if (n%2!=0){
            return myPowHelper(x*x,n>>2,i+1)*x;
        }else {
            return myPowHelper(x*x,n>>2,i+1);
        }
    }

    public static void main(String[] args) {
        double res = myPow(-1.00000,-2147483648);
        System.out.println(res);
    }

}

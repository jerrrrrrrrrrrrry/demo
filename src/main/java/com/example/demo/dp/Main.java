package com.example.demo.dp;

import java.io.BufferedInputStream;
import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @program: demo
 * @description:
 * @author: Gu
 * @create: 2021-03-22 13:29
 **/
public class Main {

    public static int[] prime = new int[1001];

    public static int find(int index){
        int res = index;
        for (int i=index+1;i<prime.length;i++){
            if (prime[i]>0){
                res=i;
                break;
            }
        }
        return res;
    }

    public static void generatePrime(){
        prime[2]=2;
        prime[3]=3;
        a:for (int i=4;i<prime.length;i++){
            for (int j=2;j<=Math.sqrt(i);j++){
                if (i%j==0){
                    continue a;
                }
            }
            prime[i]=i;
        }
    }

    public static int method(int rest,int index,int max){
        int m1=0;
        int m2=0;
        if (prime[index]==0){
            return -1;
        }
        if (index>1000||index>max){
            return -1;
        }
        if (rest==0){
            return 1;
        }
        if (rest<0){
            return -1;
        }

//        if (index==array.length){
//            return -1;
//        }
//        if (rest<array[index]){
//            return -1;
//        }

        int v1 = method(rest - index, index,max);//买这一件
        if (v1>-1){
            m1+=v1;
        }

        int v2 = method(rest,find(index),max);//不买这一件
        if (v2>-1){
            m2+=v2;
        }
        return m1+m2;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedInputStream(System.in));
        int n = sc.nextInt();
//        int n = 7;
        int[] array = {2,3,5};
        generatePrime();
//        System.out.println(method(n,mem));
        System.out.println(method(n,2,n));
    }

}

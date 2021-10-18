package com.example.demo.dp;

import java.io.BufferedInputStream;
import java.util.Scanner;

/**
 * @program: demo
 * @description:
 * @author: Gu
 * @create: 2021-03-23 15:47
 **/
public class Dp_demo {

    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedInputStream(System.in));
        int l=sc.nextInt();//桥长度
        int t = sc.nextInt();//几种幅度
        int[] array =new int[t];

        for (int i = 0;i<t;i++){
            array[i] = sc.nextInt();
        }
        int[] dp=new int[1000];

        for (int i=0;i<t;i++){
            for (int j=0;j<=l;j++) {
                if (j >= array[i]) {
                    if (dp[j]==0){
                        dp[j] = Math.min(10000, dp[j - array[i]] + 1);
                    }else {
                        dp[j] = Math.min(dp[j], dp[j - array[i]] + 1);
                    }
                }
            }
        }
        System.out.println(dp[l]);
    }
}

package com.example.demo.dp;

import java.io.BufferedInputStream;
import java.util.Scanner;

/**
 * @program: demo
 * @description:
 * @author: Gu
 * @create: 2021-03-23 16:07
 **/
public class Dp_1052 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedInputStream(System.in));
        int l = sc.nextInt();//桥长度
        int s = sc.nextInt();//几种幅度
        int t = sc.nextInt();//几种幅度
        int n = sc.nextInt();//石子数量
        int[] array = new int[t - s + 1];
        int[] arrayStone = new int[n];
        for (int i = 0; i <= t - s; i++) {
            array[i] = s + i;
        }

        for (int i = 0; i < n; i++) {
            arrayStone[i] = sc.nextInt();
        }

        int[] dp = new int[10005];

        for (int i = 0; i < l; i++) {
//            for (int j=0;j<l;j++){
            dp[i] = -1;
//            }
        }
        dp[0] = 0;
        int ans = 0;

        for (int i = 0; i <= t - s; i++) {
            for (int j = 0; j <= l - 2; j++) {
                if (dp[j] > -1) {
                    if (isExist(arrayStone,j + array[i])) {
                        dp[j + array[i]] = Math.min(dp[j] + 1, dp[j + array[i]]);
                    } else if ((j + array[i])>l){

                    } else {
                        dp[j + array[i]] = dp[j];
                    }
                }

            }
        }
        for (int i=9999;i<10005;i++){
            System.out.println(dp[i]);
        }
        System.out.println(dp[l]);
    }

    public static boolean isExist(int[] array, int i) {
        boolean b = false;
        for (int k = 0; k < array.length; k++) {
            if (array[k] == i) {
                b = true;
            }
        }
        return b;


    }

}

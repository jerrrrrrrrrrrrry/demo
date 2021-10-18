package com.example.demo.dp;

import java.io.BufferedInputStream;
import java.util.Scanner;

/**
 * @program: demo
 * @description:
 * @author: Gu
 * @create: 2021-03-23 16:07
 **/
public class Dp_1044 {

    //i个栈外 j个栈内
    public static int method(int i, int j) {
        int m = 0;
        if (i == 0) {
            return 1;
        }
        if (j > 0) {
            m += method(i, j - 1);//pop
        }
        m += method(i - 1, j + 1);//push

        return m;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedInputStream(System.in));
        int n = sc.nextInt();//n
//        int[] array = new int[n];
//        int[][] dp = new int[n][n];
//        for (int i=1;i<n;i++){//push
//            for (int j=n-i;j>=0;j--) {//pop
//                if (j>i){
//                    continue;
//                }
//                dp[i][j] = dp[i - 1][j];
//                int val1 = dp[i][j] + 1;//pop
//                int val2 = dp[i][j];//不pop
//                dp[i][j] = Math.max(val1, val2);
//            }
//        }
        int ans = method(n, 0);

        System.out.println(ans);
    }


}

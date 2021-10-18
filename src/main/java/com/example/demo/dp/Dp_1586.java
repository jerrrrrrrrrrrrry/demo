package com.example.demo.dp;

import java.io.BufferedInputStream;
import java.util.Scanner;

/**
 * @program: demo
 * @description:
 * @author: Gu
 * @create: 2021-03-25 10:06
 **/
public class Dp_1586 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedInputStream(System.in));
        int n = sc.nextInt();
        int[] arr = new int[n+1];

        for (int i = 1; i <= n; i++) {
            arr[i] = sc.nextInt();
        }
        arr[0]=32768;

        int[][] dp = new int[arr[0] + 1][5];
        dp[0][0] = 1;


        for (int k = 1; k*k <= arr[0]; k++) {
            for (int i = k*k; i <= arr[0]; i++) {
                for (int j = 1; j <= 4; j++) {
                    dp[i][j] += dp[i - k * k][j - 1];
                }
            }
        }

        for (int i=1;i<=n;i++){
            int ans = 0;
            for (int j=1;j<=4;j++) {
                ans += dp[arr[i]][j];
            }
            System.out.println(ans);
        }



    }

}

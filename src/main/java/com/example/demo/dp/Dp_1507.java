package com.example.demo.dp;

import java.io.BufferedInputStream;
import java.util.Scanner;

/**
 * @program: demo
 * @description:
 * @author: Gu
 * @create: 2021-03-24 10:02
 **/
public class Dp_1507 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedInputStream(System.in));
        int v = sc.nextInt();//体积上限
        int w = sc.nextInt();//重量上限
        int n = sc.nextInt();//sku数量
        int[][] array = new int[n][3];
        int ans = 0;
        for (int i = 0; i <n; i++) {
            for (int j=0;j<3;j++){
                array[i][j] = sc.nextInt();
            }
        }

        int[][][] dp = new int[v+1][w+1][n+1];

        for (int i=n-1;i>=0;i--){
            for (int j=0;j<=v;j++){
                for (int k=0;k<=w;k++){
                    dp[j][k][i]=dp[j][k][i+1];
                    if (j>=array[i][0]&&k>=array[i][1]) {
                        dp[j][k][i] = Math.max(dp[j - array[i][0]][k - array[i][1]][i+1] + array[i][2], dp[j][k][i]);
                    }
                }
            }
        }
        for (int i=0;i<dp[0][0].length;i++){
            ans = Math.max(ans,dp[v][w][i]);
        }

        System.out.println(ans);



    }

}

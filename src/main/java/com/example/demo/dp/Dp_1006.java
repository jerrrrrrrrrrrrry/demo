package com.example.demo.dp;

import java.io.BufferedInputStream;
import java.util.Scanner;

public class Dp_1006 {

    public static int method(int[][] array, int m, int n, int status) {
        int val1 = 0;
        int val2 = 0;
        if (m == array.length - 1 && n == array[0].length - 1) {
            status = 1;
        }
        if (m >= array.length) {
            return -1;
        }
        if (n >= array[0].length) {
            return -1;
        }
        if (m == 0 && n == 0 && status == 1) {
            return 0;
        }

        if (status == 0) {
            if (m + 1 > array.length) {
                return -1;
            }
            int m1 = method(array, m + 1, n, status);//往下走
            if (m1 > -1) {
                val1 = m1 + array[m + 1][n];
            }
            if (n + 1 > array[0].length) {
                return -1;
            }
            int m2 = method(array, m, n + 1, status);//往右走
            if (m2 > -1) {
                val2 = m2 + array[m][n + 1];
            }
        }

        if (status == 1) {
            if (m < 0) {
                return -1;
            }
            int m1 = method(array, m - 1, n, status);//往上走
            if (m1 > -1) {
                val1 = m1 + array[m - 1][n];
            }
            if (n < 0) {
                return -1;
            }
            int m2 = method(array, m, n - 1, status);//往左走
            if (m2 > -1) {
                val2 = m2 + array[m][n - 1];
            }
        }

        return Math.max(val1, val2);
    }

    public static int method1(int[][] array, int m, int n, int x, int y,int[][][][] mem) {
        int val1 = 0;
        int val2 = 0;
        int val3 = 0;
        int val4 = 0;
        if (m >= array.length || x >= array.length) {
            return -1;
        }
        if (n >= array[0].length || y >= array[0].length) {
            return -1;
        }
        if (m == array.length - 1 && n == array[0].length - 1 && x == array.length - 1 && y == array[0].length - 1) {
            return 0;
        }
//        if (x == array.length - 1 && y == array[0].length - 1) {
//            return 0;
//        }

        if (m == x && n == y) {
            if((m==0&&x==0&&n==0&&y==0)){

            }else {
                return -1;
            }
        }
        if (mem[m][n][x][y]>0){
            return mem[m][n][x][y];
        }



        int m1 = method1(array, m + 1, n, x + 1, y,mem);//全往下走
        if (m1 > -1) {
            val1 = m1 + array[m + 1][n]+array[x+1][y];
        }

        int m2 = method1(array, m, n + 1, x, y + 1,mem);//全往右走
        if (m2 > -1) {
            val2 = m2 + array[m][n + 1]+array[x][y+1];
        }



        int m3 = method1(array, m + 1, n, x, y + 1,mem);//a下b右
        if (m3 > -1) {
            val3 = m3 + array[m + 1][n]+array[x][y+1];
        }

        int m4 = method1(array, m, n + 1, x + 1, y,mem);//b下a右
        if (m4 > -1) {
            val4 = m4 + array[m][n + 1]+array[x+1][y];
        }

        mem[m][n][x][y] = Math.max(val1, Math.max(Math.max(val2, val3), val4));


        return mem[m][n][x][y];
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedInputStream(System.in));
        int m = sc.nextInt();//
        int n = sc.nextInt();//
        int[][] array = new int[m][n];
        int[][][][] mem = new int[m][n][m][n];
        int ans=0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                array[i][j] = sc.nextInt();
            }
        }

//        int[][] dp=new int[m+1][n];
//        dp[m][0]=1;


//        System.out.println(method(array, 0, 0, 0));
        ans = method1(array, 0, 0, 0,0,mem);
//        if (n>1){
//            ans+=array[0][1];
//        }
//        if (m>1){
//            ans+=array[1][0];
//        }
//        System.out.println(ans);
        System.out.println(mem[0][0][0][0]);

    }

}

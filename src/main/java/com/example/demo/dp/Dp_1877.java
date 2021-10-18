package com.example.demo.dp;

import java.io.BufferedInputStream;
import java.util.Scanner;

public class Dp_1877 {

    public static int method(int[] array, int max, int n, int begin, int[][] mem) {
        int val1 = -1;
        int val2 = -1;

        if (n == array.length) {
            return begin;
        }
        if (mem[n][begin] > 0) {
            return mem[n][begin];
        }


        if (begin + array[n] > max) {
//            return -1;
        } else {

            int m1 = method(array, max, n + 1, begin + array[n], mem);
            if (m1 > -1) {
                val1 = m1;
            }
        }
        if (begin - array[n] < 0) {
//            return -1;
        } else {
            int m2 = method(array, max, n + 1, begin - array[n], mem);
            if (m2 > -1) {
                val2 = m2;
            }
        }
        if (val1 > max && val2 <= max) {
            mem[n][begin]=val2;
            return mem[n][begin];
//            return val2;
        }
        if (val2 > max && val1 <= max) {
            mem[n][begin]=val1;
            return mem[n][begin];
//            return val1;
        }
        mem[n][begin]=Math.max(val1, val2);
        return mem[n][begin];
//        return Math.max(val1, val2);

    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedInputStream(System.in));
        int n = sc.nextInt();//
        int begin = sc.nextInt();//
        int max = sc.nextInt();//

        int[] array = new int[n];
        int[][] mem = new int[n][max+1];
        int ans = 0;
        for (int i = 0; i < n; i++) {
            array[i] = sc.nextInt();
        }

//        dp[0] = dp[0] + array[0];
//        dp[1] = dp[1 - 1] + array[1];
        ans = method(array, max, 0, begin, mem);

//        method(array, max, 0, begin, mem);
//        ans = mem[0];
        if (ans < 0 || ans > max) {
            System.out.println(-1);
        } else {
            System.out.println(ans);
        }

//        System.out.println(ans);

    }

}

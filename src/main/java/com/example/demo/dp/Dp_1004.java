package com.example.demo.dp;

import java.io.BufferedInputStream;
import java.util.Scanner;

public class Dp_1004 {

    public static int method(int[][] array, int x1, int y1, int x2, int y2, int[][][][] mem) {
        int m1 = 0;
        int m2 = 0;
        int m3 = 0;
        int m4 = 0;


        if (x1 == array.length - 1 && y1 == array.length - 1 && x2 == array.length - 1 && y2 == array.length - 1) {
            return 0;
        }


        if (mem[x1][y1][x2][y2] > 0) {
            return mem[x1][y1][x2][y2];
        }

        if (x1 + 1 <= array.length - 1 && x2 + 1 <= array.length - 1) {
            if (x1 + 1 == x2 + 1 && y1 == y2) {
                m1 = method(array, x1 + 1, y1, x2 + 1, y2, mem) + array[x2 + 1][y2];
            } else {
                m1 = method(array, x1 + 1, y1, x2 + 1, y2, mem) + array[x1 + 1][y1] + array[x2 + 1][y2];
            }
        }

        if (y1 + 1 <= array.length - 1 && y2 + 1 <= array.length - 1) {
            if (x1 == x2 && y1 + 1 == y2 + 1) {
                m2 = method(array, x1, y1 + 1, x2, y2 + 1, mem) + array[x2][y2 + 1];
            } else {
                m2 = method(array, x1, y1 + 1, x2, y2 + 1, mem) + array[x1][y1 + 1] + array[x2][y2 + 1];
            }
        }

        if (y1 + 1 <= array.length - 1 && x2 + 1 <= array.length - 1) {
            if (x1 == x2 + 1 && y1 + 1 == y2) {
                m3 = method(array, x1, y1 + 1, x2 + 1, y2, mem) + array[x2 + 1][y2];
            } else {
                m3 = method(array, x1, y1 + 1, x2 + 1, y2, mem) + array[x1][y1 + 1] + array[x2 + 1][y2];
            }
        }
        if (x1 + 1 <= array.length - 1 && y2 + 1 <= array.length - 1) {
            if (x1 + 1 == x2 && y1 == y2 + 1) {
                m4 = method(array, x1 + 1, y1, x2, y2 + 1, mem) + array[x2][y2 + 1];
            } else {
                m4 = method(array, x1 + 1, y1, x2, y2 + 1, mem) + array[x1 + 1][y1] + array[x2][y2 + 1];
            }
        }
        mem[x1][y1][x2][y2] = Math.max(m1, Math.max(m2, Math.max(m3, m4)));

        return mem[x1][y1][x2][y2];

    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedInputStream(System.in));
        int n = sc.nextInt();//
        int[][] array = new int[n][n];
        int x = 0;
        int y = 0;
        int v = -1;

        int[][][][] mem = new int[n][n][n][n];
        int[][][][] dp = new int[n][n][n][n];

        while (!(x == 0 && y == 0 && v == 0)) {
            x = sc.nextInt();//
            y = sc.nextInt();//
            v = sc.nextInt();//
            if (!(x == 0 & y == 0 && v == 0)) {
                array[x - 1][y - 1] = v;
            }
        }

        for (int x1 = 0; x1 < n; x1++) {
            for (int y1 = 0; y1 < n; y1++) {
                for (int x2 = 0; x2 < n; x2++) {
                    for (int y2 = 0; y2 < n; y2++) {
                        dp[x1][y1][x2][y2] = Math.max(dp[x1 + 1][y1][x2 + 1][y2] + (((x1 + 1 == x2 + 1) && (y1 == y2)) ? array[x1 + 1][y1] : array[x1 + 1][y1] + array[x2 + 1][y2]), Math.max(Math.max(dp[x1][y1 + 1][x2][y2 + 1], dp[x1 + 1][y1][x2][y2 + 1]), dp[x1][y1 + 1][x2 + 1][y2]));
                    }
                }
            }
        }


        method(array, 0, 0, 0, 0, mem);
        System.out.println(mem[0][0][0][0] + array[0][0]);


    }

}

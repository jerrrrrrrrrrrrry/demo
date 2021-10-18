package com.example.demo.dp;

import java.io.BufferedInputStream;
import java.util.Scanner;

/**
 * @program: demo
 * @description:
 * @author: Gu
 * @create: 2021-03-25 10:06
 **/
public class Dp_1002 {

    public static long method(int[][] h, int[] b, int x, int y,long[][] mem) {

        int x0=0;
        boolean aaa = x<x0;

        long val = 0;
        if (x == b[0] && y == b[1]) {
            return 1;
        }
        if (x > b[0] || y > b[1]) {
            return -1;
        }
        if (h[x][y] == 1) {
            return -1;
        }
        if (mem[x][y]>0){
            return mem[x][y];
        }

        long m1 = method(h, b, x + 1, y,mem);
        if (m1 >= 0) {
            val += m1;
        }
        long m2 = method(h, b, x, y + 1,mem);
        if (m2 >= 0) {
            val += m2;
        }

        mem[x][y]=val;
        return mem[x][y];

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedInputStream(System.in));
        int[] a = new int[2];
        int[] b = new int[2];
        b[0] = sc.nextInt();//x
        b[1] = sc.nextInt();//y
        int[][] h = new int[b[0] + 1][b[1] + 1];
        int h1 = sc.nextInt();//马x
        int h2 = sc.nextInt();//马y
        h[h1][h2] = 1;
//        h[2][1]=1;
//        h[3][2]=1;
        if (h2 - 2 >= 0) {
            h[h1 + 1][h2 - 2] = 1;
            if (h1 - 1 >= 0) {
                h[h1 - 1][h2 - 2] = 1;
            }
        }
        if (h2 - 1 >= 0) {
            h[h1 + 2][h2 - 1] = 1;
            if (h1 - 2 >= 0) {
                h[h1 - 2][h2 - 1] = 1;
            }
        }

        h[h1 + 1][h2 + 2] = 1;
        if (h1 - 1 >= 0) {
            h[h1 - 1][h2 + 2] = 1;
        }
        h[h1 + 2][h2 + 1] = 1;
        if (h1 - 2 >= 0) {
            h[h1 - 2][h2 + 1] = 1;
        }
//        long ans=method(h, b, 0, 0,mem);

        long[][] mem =new long[b[0] + 2][b[1] + 2];
        for (int i=b[0];i>=0;i--){
            for (int j=b[1];j>=0;j--){
                if (i==b[0]&&j==b[1]){
                    mem[i][j]=1;
                    continue;
                }
                if (h[i][j] != 1) {
                    mem[i][j] = mem[i + 1][j] + mem[i][j + 1];
                }
            }
        }

//        System.out.println(ans);
        System.out.println(mem[0][0]);


    }

}

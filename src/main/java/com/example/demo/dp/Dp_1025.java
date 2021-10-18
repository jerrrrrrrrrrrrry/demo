package com.example.demo.dp;

import java.io.BufferedInputStream;
import java.util.Scanner;

/**
 * @program: demo
 * @description:
 * @author: Gu
 * @create: 2021-03-25 10:06
 **/
public class Dp_1025 {

    public static int method(int rest,int index,int per,int maxIndex,int cnt,int[][][] mem){
        int val=0;
        int m1=0;
        int m2=0;
        if (mem[rest][index][per]>0){
            return mem[rest][index][per];
        }
        if (rest<0){
            return -1;
        }
        if (rest==0&&index==maxIndex){
            return 1;
        }
        if (index>=maxIndex){
            return -1;
        }

        if (cnt>rest){
            return -1;
        }


        if (cnt>=per){
            m1=method(rest-cnt,index+1,cnt,maxIndex,1,mem);
        }


        if (m1>-1){
            val+=m1;
        }
        m2=method(rest,index,per,maxIndex,cnt+1,mem);
        if (m2>-1){
            val+=m2;
        }

        mem[rest][index][per]=val;
        return mem[rest][index][per];
    }



    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedInputStream(System.in));
        int n = sc.nextInt();//
        int k = sc.nextInt();//

        int[][][] mem=new int[n+1][k+1][n+2];


        int[][] dp=new int[n+1][k+1];

        int ans = method(n,0,1,k,1,mem);

        System.out.println(ans);

//        for (int i=1;i<=k;i++){
//            for (int j=n;j>0;j--){
//                dp[j][i]=dp[n-j][i-1];
//            }
//        }



    }

}

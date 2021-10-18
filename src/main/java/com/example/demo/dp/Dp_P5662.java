package com.example.demo.dp;

import java.io.BufferedInputStream;
import java.util.*;

public class Dp_P5662 {

    //单种货币
    public static int method(int t,int m,int cnt,int[][] array,int n){
        int val =array[t][0]*cnt+m;//当天总值
        if (t==array.length-1){
            return val;
        }
        int val1 = method(t+1,m,cnt,array,n);//不买不卖
        int val2 = method(t+1,m+array[t][n]*cnt,0,array,n);//卖
        int val3 = method(t+1,m%array[t][n],m/array[t][n],array,n);//买
        return Math.max(val1,Math.max(val2,val3));
    }

    //多种货币一天
    public static int methodAllOne(int t,int m,int[][] array,int n,int ans){
        if (n==array[0].length){
            return ans+m;
        }
        int val1 = methodAllOne(t,m ,  array, n+1,ans);//不买不卖
        int val3 = methodAllOne(t,m%array[t][n],  array, n+1,(m / array[t][n])*array[t+1][n] +ans);//买
        return Math.max(val1,val3);
    }

    //多种货币一天
    public static int methodAllMem(int t,int m,int[][] array,int n,int[][] mem){
        if (m<0){
            return -1;
        }
        if (n==array[0].length){
            return m;
        }
        if (mem[m][n]>0){
            return mem[m][n];
        }
//        int val1 = methodAllMem(t,m ,  array, n+1,mem);//不买不卖
//        int val3 = methodAllMem(t,m%array[t][n],  array, n+1,mem);//买
        int val1=0;
        int val2=0;

        int res1 = methodAllMem(t,m-array[t][n] ,  array, n,mem);//买这一件
        int res2 = methodAllMem(t,m,  array, n+1,mem);//不买这件去买下一件
        if (res1>=0){
            val1=val1+res1+array[t+1][n];
        }
        if (res2>=0){
            val2+=res2;
        }
        mem[m][n] =  Math.max(val1,val2);
        return mem[m][n];
    }

    //多种货币多天
    public static int methodAllMemHelper(int t,int m,int[][] array,int n){
        int val=m;
        for (int i=0;i<t-1;i++){
            int[][] mem =new int[10005][n];
            val = methodAllMem(i,val, array, 0,mem);
        }
//        if (t==array.length-1){
//            return m;
//        }
//        int val1 = methodAllMem(t,m, array, n,mem);
//        int val2 = methodAllMemHelper(t+1,val1, array, n);
        return val;
    }

    //多种货币多天
    public static int methodAll(int t,int m,int[][] array,int n,int cnt){
        if (t==array.length-1){
            return m;
        }
        int val1 = methodAllOne(t,m, array, n, 0);
        int val2 = methodAll(t+1,val1, array, n, 0);
        return val2;
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedInputStream(System.in));
        int t = sc.nextInt();//t天
        int n = sc.nextInt();//n种纪念币
        int m = sc.nextInt();//m块钱
        int[][] array =new int[t][n];

        for (int i = 0;i<t;i++){
            for (int j = 0;j<n;j++){
                array[i][j] = sc.nextInt();
            }
        }

//        ans = methodAllMemHelper(t,m,array,n);


        int val=m;//存放第i天收益
        for (int i=0;i<t-1;i++){
            int[] memDp=new int[10005];
            for (int k=0;k<n;k++){
                for (int j=0;j<=val;j++){
                    if (array[i][k]<array[i+1][k]&&j>=array[i][k]) {
//                        j = j - array[i][k];//买这一件
                        memDp[j]=Math.max(memDp[j],memDp[j-array[i][k]]+array[i+1][k]-array[i][k]);
                    }
                }
            }
            val=val+memDp[val];

        }
        System.out.println(val);
    }

}

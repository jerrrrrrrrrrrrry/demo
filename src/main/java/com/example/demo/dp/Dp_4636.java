package com.example.demo.dp;

import java.io.BufferedInputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

/**
 * @program: demo
 * @description:
 * @author: Gu
 * @create: 2021-03-25 10:06
 **/
public class Dp_4636 {

    public static double length(double a, double b ,double x, double y){

        double res = Math.abs((a*x-y+b)/ Math.sqrt(a*a+1));
        System.out.println(res);
        return res;
    }

    /**
     * 最小二乘法
     * @param X
     * @param Y
     * @return y = ax + b, r
     */
    public static Map<String, Double> lineRegression(double[] X, double[] Y)
    {
        if(null == X || null == Y || 0 == X.length
                || 0 == Y.length || X.length != Y.length)
        {
            throw new RuntimeException();
        }

        // x平方差和
        double Sxx = varianceSum(X);
        // y平方差和
        double Syy = varianceSum(Y);
        // xy协方差和
        double Sxy = covarianceSum(X, Y);

        double xAvg = arraySum(X) / X.length;
        double yAvg = arraySum(Y) / Y.length;

        double a = Sxy / Sxx;
        double b = yAvg - a * xAvg;

        // 相关系数
        double r = Sxy / Math.sqrt(Sxx * Syy);
        Map<String, Double> result = new HashMap<String, Double>();
        result.put("a", a);
        result.put("b", b);
        result.put("r", r);

        return result;
    }

    /**
     * 计算方差和
     * @param X
     * @return
     */
    private static double varianceSum(double[] X)
    {
        double xAvg = arraySum(X) / X.length;
        return arraySqSum(arrayMinus(X, xAvg));
    }

    /**
     * 计算协方差和
     * @param X
     * @param Y
     * @return
     */
    private static double covarianceSum(double[] X, double[] Y)
    {
        double xAvg = arraySum(X) / X.length;
        double yAvg = arraySum(Y) / Y.length;
        return arrayMulSum(arrayMinus(X, xAvg), arrayMinus(Y, yAvg));
    }

    /**
     * 数组减常数
     * @param X
     * @param x
     * @return
     */
    private static double[] arrayMinus(double[] X, double x)
    {
        int n = X.length;
        double[] result = new double[n];
        for(int i = 0; i < n; i++)
        {
            result[i] = X[i] - x;
        }

        return result;
    }

    /**
     * 数组求和
     * @param X
     * @return
     */
    private static double arraySum(double[] X)
    {
        double s = 0 ;
        for( double x : X )
        {
            s = s + x ;
        }
        return s ;
    }

    /**
     * 数组平方求和
     * @param X
     * @return
     */
    private static double arraySqSum(double[] X)
    {
        double s = 0 ;
        for( double x : X )
        {
            s = s + Math.pow(x, 2) ;
        }
        return s ;
    }

    /**
     * 数组对应元素相乘求和
     * @param X
     * @return
     */
    private static double arrayMulSum(double[] X, double[] Y)
    {
        double s = 0 ;
        for( int i = 0 ; i < X.length ; i++ )
        {
            s = s + X[i] * Y[i] ;
        }
        return s ;
    }





    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedInputStream(System.in));
        int n = sc.nextInt();//
        double[] X = new double[n];
        double[] Y = new double[n];

        for (int i=0;i<n;i++){
            X[i]=sc.nextInt();//
            Y[i]=sc.nextInt();//
        }
        Map<String, Double> map = lineRegression(X, Y);

        System.out.println(map);
        for (int i=0;i<n;i++) {
            length(map.get("a"), map.get("b"), X[i],Y[i]);
//            length(0, 1, X[i],Y[i]);

        }


    }

}

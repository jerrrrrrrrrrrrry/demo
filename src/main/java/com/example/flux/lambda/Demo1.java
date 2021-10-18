package com.example.flux.lambda;

import java.util.Comparator;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * @program: demo
 * @description:
 * @author: Gu
 * @create: 2021-10-14 12:41
 **/
public class Demo1 {
    public static void main(String[] args) {
        Runnable r1 = () -> {

        };

        Comparable comparable = new Comparable() {
            @Override
            public int compareTo(Object o) {
                return 0;
            }
        };
        Comparator<Integer> comparator = (o1, o2) -> {
            System.out.println(o1);
            System.out.println(o1.getClass());
            System.out.println(o2);
            System.out.println(o2.getClass());
            return o2.compareTo(o1);
        };
        int res = comparator.compare(2,1);
        System.out.println(res);

        Supplier supplier = ()->"123";
        String a = (String) supplier.get();
        System.out.println(supplier.get());
        Predicate<String> predicate = str->str.length()>3;
        System.out.println(predicate.test("abc"));

        System.out.println(10.0/3.0);

        int n=35;
        double[] dp = new double[n+1];
        dp[0]=2;
        dp[1]=-4;
        for (int i=2;i<=n;i++){
            double tmp = dp[i-2]*dp[i-1];
            dp[i] = 111-(1130.0/dp[i-1])+(3000.0/tmp);
        }
        System.out.println(dp[n]);
    }

}


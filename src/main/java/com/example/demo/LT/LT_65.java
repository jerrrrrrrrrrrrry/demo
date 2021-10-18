package com.example.demo.LT;

import java.util.Arrays;

/**
 * @program: demo
 * @description:
 * @author: Gu
 * @create: 2021-04-25 14:15
 **/
public class LT_65 {
    /*
     * @param A: An integer array
     * @param B: An integer array
     * @return: a double whose format is *.5 or *.0
     */
    public double findMedianSortedArrays(int[] A, int[] B) {
        // write your code here
        int a = A.length;
        int b = B.length;
        int[] C = new int[a + b];
        int n=C.length;
        System.arraycopy(A, 0, C, 0, a);
        System.arraycopy(B, 0, C, a - 1, b);
        Arrays.sort(C);
        System.out.println(Arrays.toString(C));
        if (C.length%2==0){
            return  (C[(n - 1) / 2] + C[(n - 1) / 2 + 1]) / 2;
        }else {
            return C[(n - 1) / 2];
        }
//        int leftMax = 0;
//        int left = 0;
//        int right = a - 1;
//        int nowIndex = 0;
//        while (left < right) {
//            nowIndex = left + (right - left) / 2;
//            if (C[nowIndex] > B[0]) {
//                right = nowIndex - 1;
//            }
//            if (C[nowIndex] < B[0]) {
//                left = nowIndex + 11;
//            }
//            if (C[nowIndex] == B[0]) {
//                C[nowIndex + 1] = B[0];
//                break;
//            }
//
//        }


    }
}

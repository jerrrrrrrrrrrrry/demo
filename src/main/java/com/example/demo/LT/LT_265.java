package com.example.demo.LT;

import java.util.Arrays;

/**
 * @program: demo
 * @description:
 * @author: Gu
 * @create: 2021-04-25 14:15
 **/
public class LT_265 {
    /**
     * @param A: an integer array
     * @return: return maxium contiguous non-negative subarray sum
     */
    public static int maxNonNegativeSubArray(int[] A) {
        // write your code here
        int[] dp = new int[A.length];
        int max=0;
        int cnt=0;
        if (A[0]<0){
            cnt++;
        }else {
            dp[0] = A[0];
            max=A[0];
        }
        for (int i=0;i<A.length;i++){
            if (A[i]>=0) {
                dp[i] = A[i];
                dp[i] = dp[i-1]+A[i];
                max = Math.max(dp[i],max);
            }
            if (A[i]<0){
                cnt++;
            }
        }
        if (cnt==A.length){
            return -1;
        }
        return max;
    }

    public static void main(String[] args) {
        int[] A = {1,2,-3,4,5,-6};
        System.out.println(maxNonNegativeSubArray(A));
    }

}

package com.example.demo.BinarTree;

/**
 * @program: demo
 * @description:
 * @author: Gu
 * @create: 2021-05-14 11:46
 **/
public class LeetCode_477 {
    public int totalHammingDistance(int[] nums) {
        int sum=0;
        for (int i=0;i<nums.length;i++){
            for (int j=i+1;j<nums.length;j++){
                sum+=Integer.bitCount(nums[i]^nums[j]);
            }
        }
        return sum;
    }
}




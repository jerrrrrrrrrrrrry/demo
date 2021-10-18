package com.example.demo.LT;

import java.util.Arrays;

/**
 * @program: demo
 * @description:
 * @author: Gu
 * @create: 2021-04-25 14:15
 **/
public class LT_41 {

    public static int firstMissingPositive(int[] nums) {
        int ans = 0;
        int index = nums[0];
        for (int i=0;i<nums.length;i++){
            if (index>0&&index<=nums.length) {
                int tmp = nums[index-1];
                nums[index-1] = index;
                index = tmp;
            }
        }
        for (int i=0;i<nums.length;i++){
            if (nums[i]!=i+1){
                return i+1;
            }
        }
        return nums.length+1;
    }

    public static void main(String[] args) {
        firstMissingPositive(new int[]{3,4,-1,1});
    }

}

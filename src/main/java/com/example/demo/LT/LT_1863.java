package com.example.demo.LT;

/**
 * @program: demo
 * @description:
 * @author: Gu
 * @create: 2021-04-25 14:15
 **/
public class LT_1863 {
    int sum=0;

    public int subsetXORSum(int[] nums) {
        subsetXORSumHelper(nums,0,0);
        return sum;
    }

    public void subsetXORSumHelper(int[] nums,int index,int val) {
        if (index==nums.length){
            sum+=val;
            return;
        }
        subsetXORSumHelper(nums,index+1,val^nums[index]);
        subsetXORSumHelper(nums,index+1,val);
        return;
    }

    public int subsetXORSumHelper1(int[] nums) {
        int res = 0;
        for (int i=0;i<nums.length;i++){
            res = res^nums[i];
        }
        return res;
    }

}

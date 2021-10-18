package com.example.demo.LT;

/**
 * @program: demo
 * @description:
 * @author: Gu
 * @create: 2021-04-25 14:15
 **/
public class LT_162 {

    public int findPeakElement(int[] nums) {
        if (nums.length==1){
            return 0;
        }
        if (nums.length==2){
            return nums[0]>nums[1]?0:1;
        }
        int left = 0;
        int right = nums.length-1;
        while (left<=right){
            int mid = left+(right-left)/2;
            if (mid==0&&nums[mid]>nums[mid+1]){
                return mid;
            }
            if (mid==nums.length-1&&nums[mid]>nums[mid-1]){
                return mid;
            }
            if (nums[mid]>nums[mid-1]&&nums[mid]>nums[mid+1]){
                return mid;
            }
            if (nums[mid]>nums[mid-1]&&nums[mid]<nums[mid+1]){
                left=mid+1;
            }
            if (nums[mid]<nums[mid-1]&&nums[mid]>nums[mid+1]){
                right=mid-1;
            }
            if (nums[mid]<nums[mid-1]&&nums[mid]<nums[mid+1]){
                right=mid-1;
            }
        }
        return -1;
    }
}

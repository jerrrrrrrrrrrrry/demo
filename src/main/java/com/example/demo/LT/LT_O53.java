package com.example.demo.LT;

import java.util.HashSet;
import java.util.Set;

/**
 * @program: demo
 * @description:
 * @author: Gu
 * @create: 2021-04-25 14:15
 **/
public class LT_O53 {
    public static int search(int[] nums, int target) {
        int resL = -1;
        int resR = -1;
        int left = 0;
        int right = nums.length-1;
        while (left<=right){
            int now = left+(right-left)/2;
            if (nums[now]==target){
                if (now>0&&nums[now-1]==target){
                    right = now-2;
                    resL = now-1;
                }else {
                    resL = now;
                    break;
                }
            }else if (nums[now]>target){
                right = now-1;
            }else {
                left = now+1;
            }
        }
        left = 0;
        right = nums.length-1;
        while (left<=right){
            int now = left+(right-left)/2;
            if (nums[now]==target){
                if (now<nums.length-1&&nums[now+1]==target){
                    left = now+2;
                    resR = now+1;
                }else {
                    resR = now;
                    break;
                }
            }else if (nums[now]>target){
                right = now-1;
            }else {
                left = now+1;
            }
        }
        if (resL>-1&&resR>-1){
            return resR-resL+1;
        }
        return 0;

    }

    public static void main(String[] args) {
        int[] ints = {5,7,7,8,8,10};
        search(ints,8);
    }
}

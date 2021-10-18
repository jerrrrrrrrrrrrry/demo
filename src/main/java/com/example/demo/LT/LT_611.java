package com.example.demo.LT;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: demo
 * @description:
 * @author: Gu
 * @create: 2021-04-25 14:15
 **/
public class LT_611 {

    public int triangleNumber(int[] nums) {
        int cnt = 0;
        for (int i=0;i<nums.length-2;i++){
            for (int j=i+1;j<nums.length-1;j++){
                for (int k=j+1;k<nums.length;k++){
                    if (check(nums[i],nums[j],nums[k])){
                        cnt++;
                    }
                }
            }
        }
        return cnt;
    }


    public boolean check(int a,int b,int c) {
        if (a+b<=c||a+c<=b||b+c<=a){
            return false;
        }
        return true;
    }
}

package com.example.demo.LT;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: demo
 * @description:
 * @author: Gu
 * @create: 2021-04-25 14:15
 **/
public class LT_523 {

    public static boolean checkSubarraySum(int[] nums, int k) {
        int l = nums.length;
        int[] dp = new int[l];
        dp[0]=nums[0];
        for (int i=1;i<l;i++){
            dp[i] = dp[i-1]+nums[i];
        }
        Map<Integer,Integer> map = new HashMap<>();
        map.put(0,-1);
        for (int i=0;i<l;i++){
            if (dp[i]%k==0&&i>=1){
                return true;
            }
            for (int j=0;j<=dp[i]/k;j++) {
                if (map.containsKey(dp[i] - k*j)){
                    if ((i-map.get(dp[i] - k*j))>=2)
                    return true;
                }
            }
            map.put(dp[i],Math.min(i,map.getOrDefault(dp[i],i+1)));
        }
        return false;

    }

    public static void main(String[] args) {
        int[] n = {23,2,6,4,7};
        int k = 13;
        checkSubarraySum(n,k);
    }

}

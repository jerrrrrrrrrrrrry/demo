package com.example.demo.LT;

import java.util.*;

/**
 * @program: demo
 * @description:
 * @author: Gu
 * @create: 2021-04-25 14:15
 **/
public class LT_494 {

    public static int findTargetSumWays(int[] nums, int target) {
//        Map<Integer,Integer> map = new HashMap<>();
//        map.put(0,1);
//        for (int i=1;i<=nums.length;i++){
//            Map<Integer,Integer> tmp = new HashMap<>();
//            for(Integer key:map.keySet()){
//                int per = map.get(key);
//                tmp.put(key+nums[i-1],tmp.getOrDefault(key+nums[i-1],0)+per);
//                tmp.put(key-nums[i-1],tmp.getOrDefault(key-nums[i-1],0)+per);
//            }
//            map=tmp;
//        }
//        if (map.containsKey(target)){
//            return map.get(target);
//        }else {
//            return 0;
//        }

        int[][] dp = new int[nums.length+1][2000+1];
        dp[0][0+1000]=1;
        for (int i=1;i<=nums.length;i++){
            for (int j=-1000;j<1001;j++){
                if (j+nums[i-1]<=1000) {
                    dp[i][j+1000] += dp[i - 1][j + nums[i - 1]+1000];
                }
                if (j-nums[i-1]>=-1000){
                    dp[i][j+1000] += dp[i-1][j-nums[i-1]+1000];
                }
            }
        }
        return dp[nums.length][target+1000];

    }

    public static void main(String[] args) {
        int[] nums = {1,1,1,1,1};
        int cnt = findTargetSumWays(nums,3);
        System.out.println(cnt);
    }



}

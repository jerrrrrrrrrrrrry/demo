package com.example.demo.LT;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @program: demo
 * @description:
 * @author: Gu
 * @create: 2021-04-25 14:15
 **/
public class LT_930 {
    public int numSubarraysWithSum(int[] nums, int goal) {
        int cnt = 0;
        int[] sum = new int[nums.length];
        Map<Integer,Integer> map = new HashMap<>();
        sum[0] = nums[0];
        map.put(sum[0],1);
        if (sum[0]==goal) cnt++;
        for (int i=1;i<nums.length;i++){
            sum[i] = sum[i-1]+nums[i];
            if (sum[i]==goal){
                cnt++;
            }
            if (map.containsKey(sum[i]-goal)){
                cnt+=map.get(sum[i]-goal);
            }
            map.put(sum[i],map.getOrDefault(sum[i],0)+1);

        }
        return cnt;
    }
    public int majorityElement(int[] nums) {
        if (nums.length==1){
            return nums[0];
        }
        Arrays.sort(nums);
        int cnt = 0;
        int now = nums[0];
        for (int i:nums){
            if (now==i){
                cnt++;
                if (cnt>nums.length/2){
                    return i;
                }
            }else {
                cnt=1;
                now = i;
            }
        }
        return -1;
    }
}

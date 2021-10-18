package com.example.demo.LT;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: demo
 * @description:
 * @author: Gu
 * @create: 2021-04-25 14:15
 **/
public class LT_1 {

    public int[] twoSum(int[] nums, int target) {
        int l = nums.length;
        Map<Integer,Integer> map = new HashMap<>();
        for (int i=0;i<l;i++){
            if (map.containsKey(target-nums[i])){
                return new int[]{map.get(target - nums[i]), i};
            }
            map.put(nums[i],i);
        }
        return new int[]{0,0};

    }

}

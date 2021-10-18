package com.example.demo.LT;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: demo
 * @description:
 * @author: Gu
 * @create: 2021-04-25 14:15
 **/
public class LT_217 {

    public boolean containsDuplicate(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int i:nums){
            if (map.containsKey(i)){
                return true;
            }
            map.put(i,1);
        }
        return false;
    }


}

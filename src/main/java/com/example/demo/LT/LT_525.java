package com.example.demo.LT;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: demo
 * @description:
 * @author: Gu
 * @create: 2021-04-25 14:15
 **/
public class LT_525 {

    public static int findMaxLength(int[] nums) {
        int l = nums.length;
        int max = 0;
        int[] sum = new int[l];
        if (nums[0] == 0) {
            sum[0] = -1;
        } else {
            sum[0] = nums[0];
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int j = 1; j < l; j++) {
            if (nums[j] == 0) {
                nums[j] = -1;
            }
            sum[j] = sum[j - 1] + nums[j];
            if (sum[j] == 0) {
                max = Math.max(max, j + 1);
            }
        }
        for (int i = 0; i < l; i++) {
            if (map.containsKey(sum[i])) {
                max = Math.max(i - map.get(sum[i]), max);
            } else {
                map.put(sum[i], i);
            }
        }
        return max;

    }

    public static void main(String[] args) {
        int[] n = {0, 0, 1, 0, 0, 0, 1, 1};
        findMaxLength(n);
    }

}

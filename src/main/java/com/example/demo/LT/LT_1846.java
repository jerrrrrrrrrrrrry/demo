package com.example.demo.LT;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @program: demo
 * @description:
 * @author: Gu
 * @create: 2021-04-25 14:15
 **/
public class LT_1846 {
    public int maximumElementAfterDecrementingAndRearranging(int[] arr) {
        Arrays.sort(arr);
        arr[0]=1;
        for (int i=1;i<arr.length;i++){
            if (arr[i]-arr[i-1]>1){
                arr[i] = arr[i-1]+1;
            }
        }
        return arr[arr.length-1];
    }

}

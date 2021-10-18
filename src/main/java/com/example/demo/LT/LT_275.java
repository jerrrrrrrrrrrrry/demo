package com.example.demo.LT;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: demo
 * @description:
 * @author: Gu
 * @create: 2021-04-25 14:15
 **/
public class LT_275 {
    public static int hIndex(int[] citations) {
        int left = 0;
        int right = citations.length-1;
        if (citations[citations.length-1]==0){
            return 0;
        }
        int ans = 1;
        while (left<=right){
            int now = left+(right-left)/2;
            int l = citations.length-1-now;
            if (citations[now]==l||citations[now]==l+1){
                ans = Math.max(ans,citations[now]);
                right = now-1;
            }else if (citations[now]>l+1){
                right = now-1;
                ans = Math.max(ans,l+1);
            }else if (citations[now]<l){
                left = now+1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] ints = {2,2,2,3,4,5};
        hIndex(ints);
    }
}

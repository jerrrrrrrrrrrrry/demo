package com.example.demo.LT;

import java.util.Arrays;

/**
 * @program: demo
 * @description:
 * @author: Gu
 * @create: 2021-04-25 14:15
 **/
public class LT_1818 {
    public static int minAbsoluteSumDiff(int[] nums1, int[] nums2) {
        int[] abs = new int[nums1.length];
        int ans = 0;
        for (int i=0;i<nums1.length;i++){
            abs[i] = nums1[i]-nums2[i];
            ans+=Math.abs(abs[i]);
        }
        int a = 0;

        for (int i=0;i<nums1.length;i++){
            for (int j=0;j<nums1.length;j++){
                int tmp = Math.abs(abs[j]+nums1[i]-nums1[j]);
                if (tmp<Math.abs(abs[j])) {
                    a = Math.max(a, Math.abs(Math.abs(abs[j]) - tmp));
                }
            }
        }
        return ans-a;

    }

    public static void main(String[] args) {
        int[] a = {1,7,5};
        int[] b = {2,3,5};
        minAbsoluteSumDiff(a,b);
    }

}

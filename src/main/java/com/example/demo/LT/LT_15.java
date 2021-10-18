package com.example.demo.LT;

import java.util.*;

/**
 * @program: demo
 * @description:
 * @author: Gu
 * @create: 2021-04-25 14:15
 **/
public class LT_15 {

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        int status1 = Integer.MAX_VALUE;
        int status2 = Integer.MAX_VALUE;
        for (int i=0;i<nums.length;i++){
            for (int j=i+1;j<nums.length;j++){
                List<Integer> tmp = new ArrayList<>();
                tmp.add(nums[i]);
                tmp.add(nums[j]);
                if (nums[i]!=status1&&nums[j]!=status2){
                    status1=nums[i];
                    status2=nums[j];
                }else if (nums[i]==status1&&nums[j]==status2){
                    continue;
                }
                int left = j+1;
                int right = nums.length-1;
                while (left<=right){
                    int mid = left+(right-left)/2;
                    if (nums[mid]==-nums[i]-nums[j]){
                        tmp.add(nums[mid]);
                        ans.add(tmp);
                        break;
                    }else if (nums[mid]<-nums[i]-nums[j]){
                        left=mid+1;
                    }else if (nums[mid]>-nums[i]-nums[j]){
                        right=mid-1;
                    }
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        threeSum(nums);
    }

}

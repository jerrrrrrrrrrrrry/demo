package com.example.demo.BinarTree;

import java.util.Arrays;

/**
 * @program: demo
 * @description:
 * @author: Gu
 * @create: 2021-05-14 11:46
 **/
public class LeetCode_04_02 {

    public static TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length<=0){
            return null;
        }
        int length = nums.length;
        int nowIndex = nums.length/2;
        TreeNode now = new TreeNode();
        now.val=nums[nowIndex];
        if (nowIndex>=1){
            if(nowIndex==0){
                now.left = null;
            }else{
                now.left=sortedArrayToBST(Arrays.copyOfRange(nums,0,nowIndex));
            }
        }
        if (length>=1) {
            if(nowIndex+1==length){
                now.right = null;
            }else{
                now.right = sortedArrayToBST(Arrays.copyOfRange(nums, nowIndex + 1, length));
            }
        }
        return now;
    }

    public static void main(String[] args) {
        int[] n = {-10,-3,0,5,9};
        sortedArrayToBST(n);
    }
}

//class TreeNode {
//    int val;
//    TreeNode left;
//    TreeNode right;
//
//    TreeNode() {
//    }
//
//    TreeNode(int val) {
//        this.val = val;
//    }
//
//    TreeNode(int val, TreeNode left, TreeNode right) {
//        this.val = val;
//        this.left = left;
//        this.right = right;
//    }
//}

package com.example.demo.BinarTree;

/**
 * @program: demo
 * @description:
 * @author: Gu
 * @create: 2021-05-14 11:46
 **/
public class LeetCode_108 {

    public static TreeNode sortedArrayToBST(int[] nums) {
        return sortedArrayToBSTHelper(nums,0,nums.length);
    }

    public static TreeNode sortedArrayToBSTHelper(int[] nums,int left,int right){
        if (left>=right){
            return null;
        }
        int mid = left+(right-left)/2;
        TreeNode treeNode = new TreeNode();
        treeNode.val=nums[mid];
        treeNode.left=sortedArrayToBSTHelper(nums,left,mid);
        treeNode.right=sortedArrayToBSTHelper(nums,mid+1,right);
        return treeNode;
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

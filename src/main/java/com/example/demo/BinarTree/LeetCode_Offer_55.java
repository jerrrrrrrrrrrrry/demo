package com.example.demo.BinarTree;

import java.util.Arrays;

/**
 * @program: demo
 * @description:
 * @author: Gu
 * @create: 2021-05-14 11:46
 **/
public class LeetCode_Offer_55 {

    public int maxDepth(TreeNode root) {
        return maxDepthHelper(root,0);
    }

    public int maxDepthHelper(TreeNode root,int depth){
        if (root==null){
            return depth;
        }
        int val1 = maxDepthHelper(root.left,depth+1);
        int val2 = maxDepthHelper(root.right,depth+1);
        return Math.max(val1,val2);
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

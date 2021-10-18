package com.example.demo.BinarTree;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: demo
 * @description:
 * @author: Gu
 * @create: 2021-05-14 11:46
 **/
public class LeetCode_938 {

    public int rangeSumBST(TreeNode root, int low, int high) {
        return traverse(root,low,high);
    }

    public int traverse(TreeNode t, int low, int high) {
        if (t==null){
            return 0;
        }
        if (t.val>=low&&t.val<=high){
            return traverse(t.left, low, high)+traverse(t.right, low, high)+t.val;
        }else if (t.val<low) {
            return traverse(t.right,low,high);
        }else {
            return traverse(t.left,low,high);
        }
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

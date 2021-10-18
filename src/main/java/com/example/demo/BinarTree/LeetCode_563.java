package com.example.demo.BinarTree;

/**
 * @program: demo
 * @description:
 * @author: Gu
 * @create: 2021-05-14 11:46
 **/
public class LeetCode_563 {
    int sum = 0;

    public int findTilt(TreeNode root) {
        findTiltHelper(root);
        return sum;
    }

    public int findTiltHelper(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int val1 = findTiltHelper(root.left);
        int val2 = findTiltHelper(root.right);
        sum += Math.abs(val1 - val2);
        return val1 + val2 + root.val;
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

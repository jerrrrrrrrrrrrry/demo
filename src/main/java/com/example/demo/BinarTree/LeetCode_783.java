package com.example.demo.BinarTree;

/**
 * @program: demo
 * @description:
 * @author: Gu
 * @create: 2021-05-14 11:46
 **/
public class LeetCode_783 {
    int min = 1000000;

    public int minDiffInBST(TreeNode root) {
        minDiffInBSTHelper(root);
        return min;
    }
    public int minDiffInBSTHelper(TreeNode root) {
        if (root==null){
            return -1;
        }
        int val1 = minDiffInBSTHelper(root.left);
        int val2 = minDiffInBSTHelper(root.right);
        if (val1>-1&&val2>-1) {
            min = Math.min(min, Math.min(Math.abs(root.val - val1), Math.abs(val2 - root.val)));
        }else if (val1>-1&&val2<0){
            min = Math.min(min, Math.abs(root.val - val1));
        }else if (val2>-1&&val1<0){
            min = Math.min(min, Math.abs(root.val - val2));
        }

        return root.val;
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

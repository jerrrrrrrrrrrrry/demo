package com.example.demo.BinarTree;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: demo
 * @description:
 * @author: Gu
 * @create: 2021-05-14 11:46
 **/
public class LeetCode_897 {

    TreeNode now = new TreeNode();
    TreeNode newRoot = null;


    public TreeNode increasingBST(TreeNode root) {
        increasingBSTHelper(root);
        return newRoot.right;
    }

    public TreeNode increasingBSTHelper(TreeNode root) {
        if (root==null){
            return null;
        }
        increasingBSTHelper(root.left);
        if (newRoot==null){
            newRoot = new TreeNode();
            newRoot.right=root;
        }
        System.out.println(root.val);
        root.left=null;
        now.right=root;
        now=root;
        increasingBSTHelper(root.right);

        return root;
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

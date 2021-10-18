package com.example.demo.BinarTree;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: demo
 * @description:
 * @author: Gu
 * @create: 2021-05-14 11:46
 **/
public class LeetCode_257 {
    int status = 0;

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> strs = new ArrayList<>();
        while (root.val != -10000) {
            StringBuilder str = new StringBuilder();
            traverse(root, str);
            str.delete(0, 2);
            strs.add(str.toString());
            System.out.println(str);
            status = 0;
        }
        return strs;
    }

    public int traverse(TreeNode t, StringBuilder str) {
        if (t == null || t.val == -10000) {
            return -1;
        }
        str.append("->").append(t.val);
        if (t.left == null && t.right == null) {
            status = 1;
            t.val = -10000;
            return -1;
        }
        if (t.left != null && status != 1) {
            traverse(t.left, str);
        }
        if (t.right != null && status != 1) {
            traverse(t.right, str);
        }
        if ((t.left == null || t.left.val == -10000) && (t.right == null || t.right.val == -10000)) {
            t.val = -10000;
        }
        return -1;
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

package com.example.demo.BinarTree;

/**
 * @program: demo
 * @description:
 * @author: Gu
 * @create: 2021-05-14 11:46
 **/
public class LeetCode_872 {
    public static boolean leafSimilar(TreeNode root1, TreeNode root2) {
        String str1 = getLeaf(root1,"");
        String str2 = getLeaf(root2,"");
        if (str1.equals(str2)){
            return true;
        }
        return false;
    }

    public static String getLeaf(TreeNode root,String leaf){
        if (root==null){
            return leaf;
        }
        if (root.left==null&&root.right==null){
            System.out.println(root.val);
            leaf = leaf.concat(root.val+",");
        }

        return getLeaf(root.left,leaf)+getLeaf(root.right,leaf);
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

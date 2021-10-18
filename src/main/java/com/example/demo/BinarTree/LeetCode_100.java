package com.example.demo.BinarTree;

/**
 * @program: demo
 * @description:
 * @author: Gu
 * @create: 2021-05-14 11:46
 **/
public class LeetCode_100 {
    String a="";
    String b="";

    public boolean isSameTree(TreeNode p, TreeNode q) {

        String str1 = traverse(p,a);
        String str2 = traverse(q,b);
        if (str1.equals(str2)){
            return true;
        }
        return false;

    }
    public String traverse(TreeNode root,String str) {
        if (root==null){
            return str;
        }
        String v1 = traverse(root.left,str);

        String v2 = traverse(root.right,str);
        str = str+root.val+","+v1+","+v2;
        System.out.println(str);
        return str;
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

package com.example.demo.LT;

import org.apache.commons.lang3.StringUtils;

import java.util.HashSet;
import java.util.Set;

/**
 * @program: demo
 * @description:
 * @author: Gu
 * @create: 2021-04-25 14:15
 **/
public class LT_O37 {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        String ans = root == null ? "" : String.valueOf(root.val);
        ans = ans + serializeHelper(root);
        System.out.println("ans" + ans);
        return ans;
    }

    public String serializeHelper(TreeNode root) {
        if (root == null) {
            return "";
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(",");
        stringBuilder.append((root.left == null ? "null" : String.valueOf(root.left.val)));
        stringBuilder.append(",");
        stringBuilder.append((root.right == null ? "null" : String.valueOf(root.right.val)));
        stringBuilder.append(serializeHelper(root.left));
        stringBuilder.append(serializeHelper(root.right));
        return stringBuilder.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.equals("") || data == null) {
            return null;
        }
        String[] strings = data.split(",");
        TreeNode head = new TreeNode(Integer.parseInt(strings[0]));
        deserializeHelper(head, strings, 1);
        return head;
    }

    public int deserializeHelper(TreeNode treeNode, String[] strings, int index) {
        if (index >= strings.length) {
            return index;
        }
        treeNode.left = strings[index].equals("null") ? null : new TreeNode(Integer.parseInt(strings[index]));
        treeNode.right = strings[index + 1].equals("null") ? null : new TreeNode(Integer.parseInt(strings[index + 1]));
        int now = index + 2;
        if (treeNode.left != null) {
            now = deserializeHelper(treeNode.left, strings, now);
        }
        if (treeNode.right != null) {
            now = deserializeHelper(treeNode.right, strings, now);
        }
        return now;
    }
}

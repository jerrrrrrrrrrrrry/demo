package com.example.demo.LT;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @program: demo
 * @description:
 * @author: Gu
 * @create: 2021-04-25 14:15
 **/
public class LT_671 {
    int ans = Integer.MAX_VALUE;
    int cnt = 0;

    public int findSecondMinimumValue(TreeNode root) {
        int i = root.val;
        if(root.left==null){
            return -1;
        }
        findSecondMinimumValueHelper(root,i);
        if (cnt==0){
            return -1;
        }
        return ans;
    }

    public void findSecondMinimumValueHelper(TreeNode root,int i) {
        if (root.val>i) {
            ans = Math.min(ans, root.val);
            cnt++;
        }
        if (root.left==null){
            return;
        }
        findSecondMinimumValueHelper(root.left,i);

        findSecondMinimumValueHelper(root.right,i);

    }
}

package com.example.demo.LT;

import java.util.HashSet;
import java.util.Set;

/**
 * @program: demo
 * @description:
 * @author: Gu
 * @create: 2021-04-25 14:15
 **/
public class LT_O38 {
    public static String[] permutation(String s) {
        Set<String> stringSet = new HashSet<>();
        permutationHelper("",s.toCharArray(),s.toCharArray(),0,-1,stringSet);
        String[] ans = new String[stringSet.size()];
        int idx = 0;
        for (String str : stringSet) ans[idx++] = str;
        return ans;
    }

    public static void permutationHelper(String s,char[] chars,char[] nowChars,int n,int per,Set<String> stringSet) {
        if (per>=0) {
            nowChars[per] = 0;
        }
        if (n==chars.length){
            stringSet.add(s);
            nowChars[per] = chars[per];
            return;
        }
        for (int i=0;i<chars.length;i++) {
            if (nowChars[i]!=0){
                permutationHelper(s+chars[i],chars,nowChars,n+1,i,stringSet);
            }
        }
        if (per>=0) {
            nowChars[per] = chars[per];
        }
    }

    public static void main(String[] args) {
        permutation("abc");
        System.out.println(123);
    }
}

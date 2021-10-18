package com.example.demo.LT;

/**
 * @program: demo
 * @description:
 * @author: Gu
 * @create: 2021-04-25 14:15
 **/
public class LT_583 {

    public static int minDistance(String word1, String word2) {
        char[] char1 = word1.toCharArray();
        char[] char2 = word2.toCharArray();
        int[][] dp = new int[1][1];
        int ans = 0;
        for (int j=0;j<char1.length;j++) {
            int index = 0;
            int tmp = 0;
            int n=0;
            for (int i = j; i < char1.length; i++) {
                while (index < char2.length) {
                    if (char1[i] == char2[index]) {
                        index++;
                        n++;
                        tmp=index;
                        break;
                    } else {
                        index++;
                    }
                }
                index=tmp;
            }
            ans = Math.max(n,ans);
        }
//        int ans = minDistanceHelper(word1,word2,0,0,0);
        return char1.length+char2.length-ans*2;
    }

    public static int minDistanceHelper(String word1, String word2,int n,int index1,int index2) {
        if (word1.equals(word2)){
            return n;
        }
        if (index1==word1.length()&&index2==word2.length()){
            return -1;
        }
        if (word1.equals("")||word2.equals("")){
            return n+word1.length()+word2.length();
        }
        int res = Integer.MAX_VALUE;
        if (index2<=word2.length()) {
            if (index1 < word1.length()) {
                String word1N = word1.substring(0, index1) + word1.substring(index1 + 1);
                int value2 = minDistanceHelper(word1N, word2, n + 1, index1, index2);
                int value1 = minDistanceHelper(word1, word2, n, index1 + 1, index2);
                res = value1>0?Math.min(value1,res):res;
                res = value2>0?Math.min(value2,res):res;
            }
        }
        if (index1<=word1.length()) {
            if (index2 < word2.length()) {
                int value3 = minDistanceHelper(word1, word2, n, index1, index2 + 1);
                res = value3>0?Math.min(value3,res):res;
                String word2N = word2.substring(0, index2) + word2.substring(index2 + 1);
                int value4 = minDistanceHelper(word1, word2N, n + 1, index1, index2);
                res = value4>0?Math.min(value4,res):res;
            }
        }
        return res==Integer.MAX_VALUE?-1:res;
    }

    public static void main(String[] args) {
        minDistance("intention" ,"execution");
    }
}

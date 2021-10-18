package com.example.demo.LT;

/**
 * @program: demo
 * @description:
 * @author: Gu
 * @create: 2021-04-25 14:15
 **/
public class LT_1869 {

    public static boolean checkZeroOnes(String s) {
        char[] chars = s.toCharArray();
        int begin = 0;
        int max = 1;
        int[][] dp = new int[chars.length][chars.length];
        for (int i = 0;i<chars.length;i++){
            for (int j = i;j<chars.length;j++){
                if (i==j){
                    dp[i][j]=1;
                    if (max==1&&chars[i]!=49){
                        begin = i;
                    }
                }else if (dp[i][j-1]>0&&chars[j]==chars[i]) {
                    dp[i][j] = dp[i][j - 1] + 1;
                    if ((j-i+1>max)||(j-i+1==max&&chars[i]!=49)){
                        max = dp[i][j];
                        begin = i;
                    }
                }

            }
        }
        if (chars[begin]==49){
            return true;
        }
        return false;

    }

    public static void main(String[] args) {
        String s = "10";
        checkZeroOnes(s);
    }
}

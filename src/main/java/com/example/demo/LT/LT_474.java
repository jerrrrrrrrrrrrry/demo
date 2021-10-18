package com.example.demo.LT;

/**
 * @program: demo
 * @description:
 * @author: Gu
 * @create: 2021-04-25 14:15
 **/
public class LT_474 {

    public static int findMaxForm(String[] strs, int m, int n) {
        int l = strs.length;
//        int[][][] mem = new int[m+1][n+1][l];
//        int[][][] dp = new int[m + 1][n + 1][l + 1];
//        for (int k = 1; k <= strs.length; k++) {
//            for (int i = 0; i <= m; i++) {
//                for (int j = 0; j <= n; j++) {
//                    int tmp = strs[k - 1].length();
//                    int cnt = method(strs[k - 1]);
//                    dp[i][j][k] = dp[i][j][k - 1];
//                    if (i >= tmp - cnt && j >= cnt) {
//                        dp[i][j][k] = Math.max(dp[i][j][k], dp[i - (tmp - cnt)][j - cnt][k - 1] + 1);
//                    }
//                }
//            }
//        }
        int[][] dp = new int[m + 1][n + 1];
        int[][] t = new int[m + 1][n + 1];
        for (int k = 1;k <= strs.length; k++) {
            int[] cnt = method(strs[k - 1]);
            for (int i = m; i >=0; i--) {
                for (int j = n; j >=0; j--) {
                    dp[i][j] = t[i][j];
                    if (i >= cnt[0] && j >= cnt[1]) {
                        dp[i][j] = Math.max(dp[i][j], t[i - cnt[0]][j - cnt[1]] + 1);
                    }
                    t[i][j] = dp[i][j];
                }
            }
        }
//        findMaxFormHelper(strs,m,n,0,mem);
        return dp[m][n];

    }

//    public static int findMaxFormHelper(String[] strs, int m, int n, int index, int[][][] mem) {
//        if (index >= strs.length) {
//            return 0;
//        }
//        if (mem[m][n][index] > 0) {
//            return mem[m][n][index];
//        }
//        int x = strs[index].length();
//        int cnt1 = method(strs[index]);
//        int cnt0 = x - cnt1;
//        int val1 = 0;
//        int val2 = 0;
//        if (m >= cnt0 && n >= cnt1) {
//            val1 = findMaxFormHelper(strs, m - cnt0, n - cnt1, index + 1, mem) + 1;
//        }
//        val2 = findMaxFormHelper(strs, m, n, index + 1, mem);
//        mem[m][n][index] = Math.max(val1, val2);
//        return mem[m][n][index];
//    }

    public static int[] method(String str) {
        int[] zerosOnes = new int[2];
        int length = str.length();
        for (int i = 0; i < length; i++) {
            zerosOnes[str.charAt(i) - '0']++;
        }
        return zerosOnes;
    }

    public static void main(String[] args) {
        String[] str = {"011", "1", "11", "0", "010", "1", "10", "1", "1", "0", "0", "0", "01111", "011", "11", "00", "11", "10", "1", "0", "0", "0", "0", "101", "001110", "1", "0", "1", "0", "0", "10", "00100", "0", "10", "1", "1", "1", "011", "11", "11", "10", "10", "0000", "01", "1", "10", "0"};
        int res = findMaxForm(str, 44, 39);
        System.out.println(res);
    }
}

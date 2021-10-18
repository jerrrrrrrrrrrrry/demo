package com.example.demo.LT;

/**
 * @program: demo
 * @description:
 * @author: Gu
 * @create: 2021-04-25 14:15
 **/
public class LT_518 {

    public static int change(int amount, int[] coins) {
//        int[][] dp = new int[amount + 1][coins.length + 1];
//        for (int i = 0; i <= amount / coins[0]; i++) {
//               dp[i*coins[0]][1] = 1;
//        }
//        for (int i = 0; i <= amount; i++) {
//            for (int j = 2; j <= coins.length; j++) {
//                int cnt =0;
//                int max = i / coins[j - 1];
//                while (cnt<=max) {
//                    if (i >= cnt * coins[j - 1]) {
//                        dp[i][j] += dp[i - cnt * coins[j - 1]][j - 1];
//                    } else {
//                        dp[i][j] = dp[i][j - 1];
//                    }
//                    cnt++;
//                }
//            }
//        }
        int[] dp = new int[amount+1];
        dp[0] =1;
        for (int i=0;i<coins.length;i++){
            for (int j = coins[i]; j <= amount; j++) {
                dp[j] += dp[j-coins[i]];
            }
        }
        return dp[amount];
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 5};
        change(5, nums);
    }

}

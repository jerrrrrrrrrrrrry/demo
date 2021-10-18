package com.example.demo.LT;

/**
 * @program: demo
 * @description:
 * @author: Gu
 * @create: 2021-04-25 14:15
 **/
public class LT_600 {
    static int getLen(int n) {
        for (int i = 31; i >= 0; i--) {
            if (((n >> i) & 1) == 1) return i;
        }
        return 0;
    }

    public static int findIntegers(int n) {
        if (n<=2){
            return n+1;
        }
        if (n==3){
            return 3;
        }
        int len = getLen(n)+1;
        System.out.println(len);
        int[] dp = new int[len+1];
        dp[0]=1;
        dp[1]=2;
        dp[2]=3;
        int z = 2;
        int x=1;//0结尾
        int y=0;//1结尾
        for (int i=3;i<=len;i++){
            int a=x+y;
            int b=x;
            x=a;
            y=b;
            dp[i] = a+b+dp[i-1];
        }
        if (((n >> (len-2)) & 1) ==1){
            return dp[len];
        }

        int ans = dp[len-1];
        int cnt = 1;
        for (int i=1;i<len;i++){
            int now = ((n >> (len-i-1)) & 1);
            if (i==len-1) {
                if (cnt==1&&now == 1){
                    return ans+1;
                }else {
                    ans++;
                    if (now == 1) {
                        return ans + 1;
                    }
                }
            }else {
                if (now == 1 && cnt != 1) {
                    ans += dp[len-i-1];
                    cnt += 1;
                } else if (now == 1 && cnt == 1) {
                    return ans-dp[len-i]+dp[len-i+1];
                }else {
                    cnt=0;
                }
            }

        }

        return ans;
    }
    public static void main(String[] args) {
        findIntegers(4);
    }
}

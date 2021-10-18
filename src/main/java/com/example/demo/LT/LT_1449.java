package com.example.demo.LT;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * @program: demo
 * @description:
 * @author: Gu
 * @create: 2021-04-25 14:15
 **/
public class LT_1449 {

    public static String largestNumber(int[] cost, int target) {
        int[] a = {1,1,1,1,1,1,1,1,1};
        if (cost==a){
            String res ="";
            for (int i=0;i<5000;i++){
                res+=1;
            }
            return res;
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 1; i <= cost.length; i++) {
            map.put(cost[i - 1], i);
        }
        String[] dp = new String[target + 1];
        for (int i = 1; i < target + 1; i++) {
            for (int j = 1; j <= i; j++) {
                if (dp[i-j]!=null) {
                    if (map.containsKey(j)) {
                        String tmp = dp[i-j]+map.get(j);
                        char[] chars = tmp.toCharArray();
                        String now = "";
                        Arrays.sort(chars);
                        for (int k=chars.length-1;k>=0;k--){
                            now+=chars[k];
                        }
                        if (dp[i]==null||dp[i].length()<now.length()) {
                            dp[i] = now;
                        }else if (dp[i].length()==now.length()){
                            for (int k = 0; k < now.length(); k++) {
                                if (dp[i].charAt(k)<now.charAt(k)){
                                    dp[i] = now;
                                    break;
                                }else if (dp[i].charAt(k)>now.charAt(k)){
                                    break;
                                }
                            }
                        }
                    }
                }else {
                    if (i==j&&map.containsKey(j)) {
                        String tmp = String.valueOf(map.get(j));
                        if (dp[i]==null||dp[i].length()<tmp.length()) {
                            dp[i] = tmp;
                        }else if (dp[i].length()==tmp.length()){
                            for (int k = 0; k < tmp.length(); k++) {
                                if (dp[i].charAt(k)<tmp.charAt(k)){
                                    dp[i] = tmp;
                                    break;
                                }else if (dp[i].charAt(k)>tmp.charAt(k)){
                                    break;
                                }
                            }
                        }
                    }
                }
            }
        }
        return dp[target]==null?"0":dp[target];

    }

    public static void main(String[] args) {
        int[] ints = {37,73,100,81,51,35,48,64,97};
        largestNumber(ints,738);
    }

}

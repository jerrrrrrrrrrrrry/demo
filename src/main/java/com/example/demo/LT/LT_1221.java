package com.example.demo.LT;

/**
 * @program: demo
 * @description:
 * @author: Gu
 * @create: 2021-04-25 14:15
 **/
public class LT_1221 {

    public int balancedStringSplit(String s) {
        int[] ints = new int[s.length()];
        int tmp = 0;
        int ans = 0;
        for (int i=0;i<ints.length;i++){
            if (s.charAt(i)=="L".charAt(0)){
                tmp+=-1;
            }else if (s.charAt(i)=="R".charAt(0)){
                tmp+=1;
            }
            if (tmp==0){
                ans++;
            }
        }
        return ans;
    }


}

package com.example.demo.LT;

/**
 * @program: demo
 * @description:
 * @author: Gu
 * @create: 2021-04-25 14:15
 **/
public class LT_231 {
    public boolean isPowerOfTwo(int n) {
        if (n<=0){
            return false;
        }
//        int cnt = Integer.bitCount(n);
//        if (cnt!=1){
//            return false;
//        }else {
//            return true;
//        }
//        if ((n&(~(~n+1)))==0){
//            return true;
//        }
        if ((n&(n-1))==0){
            return true;
        }
        return false;
    }

}

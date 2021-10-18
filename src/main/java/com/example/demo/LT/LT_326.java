package com.example.demo.LT;

import java.util.*;

/**
 * @program: demo
 * @description:
 * @author: Gu
 * @create: 2021-04-25 14:15
 **/
public class LT_326 {
    public boolean isPowerOfThree(int n) {
        if (n==1){
            return true;
        }
        if (n<=0){
            return false;
        }
        if (n%3!=0){
            return false;
        }
        if (n%2==0){
            return false;
        }
        if (n%5==0){
            return false;
        }
        if (n%7==0){
            return false;
        }
        if (n%11==0){
            return false;
        }
        if (n%13==0){
            return false;
        }
        return true;
    }
}

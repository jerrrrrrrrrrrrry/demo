package com.example.demo.LT;

/**
 * @program: demo
 * @description:
 * @author: Gu
 * @create: 2021-04-25 14:15
 **/
public class LT_168 {

    public String convertToTitle(int columnNumber) {
        //A 065 Z 090
//        if (columnNumber==0){
//            return "";
//        }
//        int tmp = columnNumber % 26;
//        char a = (char) (tmp == 0 ? 90 : tmp + 64);
//        if (tmp==0){
//            return convertToTitle(columnNumber/26-1)+a;
//
//        }
//        return convertToTitle(columnNumber/26)+a;
        int n = columnNumber;
        StringBuilder ans = new StringBuilder();
        while (n!=0){
            int m = n%26;
            n=n/26;
            if (m==0){
                n--;
            }
            ans.append((char) (m == 0 ? 90 : m + 64));
        }
        return ans.reverse().toString();
    }

}

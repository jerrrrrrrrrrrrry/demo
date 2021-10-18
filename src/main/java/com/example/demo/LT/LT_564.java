package com.example.demo.LT;

/**
 * @program: demo
 * @description:
 * @author: Gu
 * @create: 2021-04-25 14:15
 **/
public class LT_564 {

    public String nearestPalindromic(String n) {
        char[] chars = n.toCharArray();
        if (chars.length==1){
            return String.valueOf(Integer.parseInt(n)-1);
        }
        if (n.equals("10")){
            return "9";
        }
        if (chars.length==2){
            if (chars[0]==chars[1]){
                if (n.equals("11")){
                    return "9";
                }else {
                    return String.valueOf(Integer.parseInt(n)-11);
                }
            }
        }
        for (int i=chars.length-1;i>=chars.length/2;i--){
            if (i<chars.length-i){
                continue;
            }else {
                chars[i] = chars[chars.length - i-1];
            }
        }
        String m = String.copyValueOf(chars);
        return m;
    }
}

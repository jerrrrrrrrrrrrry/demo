package com.example.demo.LT;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @program: demo
 * @description:
 * @author: Gu
 * @create: 2021-04-25 14:15
 **/
public class LT_20 {
    public boolean isValid(String s) {
        char[] chars = s.toCharArray();
        Deque<Character> stack = new LinkedList<Character>();
        for (int i=0;i<chars.length;i++){
            if (chars[i]==40||chars[i]==91||chars[i]==123){
                stack.push(chars[i]);
            }else if (stack.isEmpty()){
                return false;
            }else if ((chars[i]==41&&stack.peek()==40)||(chars[i]==93&&stack.peek()==91)||(chars[i]==125&&stack.peek()==123)){
                stack.pop();
            }else {
                return false;
            }
        }
        if (!stack.isEmpty()){
            return false;
        }
        return true;
    }
}

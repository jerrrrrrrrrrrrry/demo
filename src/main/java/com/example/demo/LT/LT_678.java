package com.example.demo.LT;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Map;

/**
 * @program: demo
 * @description:
 * @author: Gu
 * @create: 2021-04-25 14:15
 **/
public class LT_678 {

    public boolean checkValidString(String s) {
        Deque<Character> stack = new LinkedList<Character>();
        char[] chars = s.toCharArray();
        for (int i=0;i<s.length();i++) {
            stack.push(chars[i]);
            stack.pop();
        }
        return true;
    }
}

package com.example.demo.LT;

import org.apache.commons.lang3.StringUtils;

import java.util.*;

/**
 * @program: demo
 * @description:
 * @author: Gu
 * @create: 2021-04-25 14:15
 **/
public class LT_726 {

    public static String countOfAtoms(String formula) {
        Deque<Integer> stack = new LinkedList<Integer>();
        Map<String, Integer> map = new HashMap<>();
        char[] chars = formula.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == 41) {
                int index = i + 1;
                int cnt = 0;
                while (index < chars.length && Character.isDigit(chars[index])) {
                    cnt = cnt * 10 + Character.getNumericValue(chars[index]);
                    index++;
                }
                stack.push(cnt == 0 ? 1 : cnt);
            }
        }
        int k = 1;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == 40) {
                k = stack.peek();
            }
            if (chars[i] == 41) {
                stack.pop();
            }
            if (Character.isUpperCase(chars[i])) {
                int index = i + 1;
                int cnt = 0;
                String str = Character.toString(chars[i]);
                while (index < chars.length && Character.isLowerCase(chars[index])) {
                    str = str + chars[index];
                    index++;
                }
                while (index < chars.length && Character.isDigit(chars[index])) {
                    cnt = cnt * 10 + Character.getNumericValue(chars[index]);
                    index++;
                }
                map.put(str, map.getOrDefault(str, 0) + cnt * k);
            }
        }

        System.out.println(123);
        return "";
    }

    public static void main(String[] args) {
        countOfAtoms("K4(ON(SO3)2)2");
    }
}

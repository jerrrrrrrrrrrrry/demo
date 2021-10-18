package com.example.demo.LT;

import org.apache.commons.lang3.StringUtils;

import java.util.*;

/**
 * @program: demo
 * @description:
 * @author: Gu
 * @create: 2021-04-25 14:15
 **/
public class LT_22 {
    public static List<String> generateParenthesis(int n) {
        if (n == 1) {
            return Arrays.asList("()");
        }
        Set<String> res = new HashSet<>();
        Set<String> tmp = new HashSet<>();
        for (String t : generateParenthesis(n - 1)) {
            for (int k = 0; k < t.length(); k++) {
                String str = substring(t, 0, k) + "()" + substring(t, k, t.length());
                tmp.add(str);
            }
        }
        res = tmp;

        return new ArrayList<>(res);
    }

    public static String substring(String str, int start, int end) {
        return str.substring(start, end);
    }

    public static void main(String[] args) {
        generateParenthesis(3);
    }
}

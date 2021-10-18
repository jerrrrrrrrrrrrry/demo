package com.example.demo.LT;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: demo
 * @description:
 * @author: Gu
 * @create: 2021-04-25 14:15
 **/
public class LT_58 {

    public int lengthOfLastWord(String s) {
        s=s.trim();
        return s.length()-1-s.lastIndexOf(" ");
    }


}

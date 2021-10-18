package com.example.demo.LT;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: demo
 * @description:
 * @author: Gu
 * @create: 2021-04-25 14:15
 **/
public class LT_165 {
    public static int compareVersion(String version1, String version2) {
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");
        int l1 = v1.length;
        int l2 = v2.length;
        for (int i=0;i<Math.max(l1,l2);i++){
            if (((i>=l1)?0:Integer.valueOf(v1[i]))>((i>=l2)?0:Integer.valueOf(v2[i]))){
                return 1;
            }
            if (((i>=l1)?0:Integer.valueOf(v1[i]))<((i>=l2)?0:Integer.valueOf(v2[i]))){
                return -1;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        compareVersion("1.1","1.1.1");
    }
}

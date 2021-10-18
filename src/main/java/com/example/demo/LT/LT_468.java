package com.example.demo.LT;

import org.apache.commons.lang3.StringUtils;

/**
 * @program: demo
 * @description:
 * @author: Gu
 * @create: 2021-04-25 14:15
 **/
public class LT_468 {

    public static String validIPAddress(String IP) {
        if (IP.contains(":")){
            String[] strings = IP.split(":");

            if (strings.length!=8||IP.lastIndexOf(":")==IP.length()-1) {
                return "Neither";
            }
            for (int i = 0; i < strings.length; i++) {
                if (strings[i].length()>4) {
                    return "Neither";
                }
                int tmp=0;
                try{
                    tmp = Integer.valueOf(strings[i],16);
                }catch(NumberFormatException e)
                {
                    return "Neither";
                }
            }
            return "IPv6";
        }else {
            String[] strings = IP.split("\\.");
            if (strings.length!=4||IP.lastIndexOf(".")==IP.length()-1) {
                return "Neither";
            }
            for (int i = 0; i < strings.length; i++) {
                int tmp=0;
                try{
                    tmp = Integer.valueOf(strings[i]);
                }catch(NumberFormatException e)
                {
                    return "Neither";
                }
                if ((strings[i].charAt(0) == 48 && strings[i].length()!=1) || tmp < 0 || tmp > 255) {
                    return "Neither";
                }
            }
            return "IPv4";
        }
    }

    public static void main(String[] args) {
        validIPAddress("2001:0db8:85a3:0:0:8A2E:0370:7334:");
    }

}

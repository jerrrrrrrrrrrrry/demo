package com.example.demo.LT;

import java.util.List;

/**
 * @program: demo
 * @description:
 * @author: Gu
 * @create: 2021-04-25 14:15
 **/
public class LT_524 {

    public String findLongestWord(String s, List<String> dictionary) {
        String ans = "";
        for (String tmp:dictionary){
            if (tmp.length()>=ans.length()) {
                if (findLongestWordHelper(s, tmp)) {
                    ans = tmp.compareTo(ans)>0?tmp:ans;
                }
            }
            if (ans==s){
                return ans;
            }
        }
        return ans;

    }

    public boolean findLongestWordHelper(String s,String tmp){
        int j=0;
        for (int i=0;i<s.length();i++){
            if (s.charAt(i)==tmp.charAt(j)){
                j++;
            }
            if (j==tmp.length()){
                return true;
            }
        }
        return false;
    }

}

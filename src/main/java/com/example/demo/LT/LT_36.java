package com.example.demo.LT;

import org.apache.commons.collections.map.HashedMap;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: demo
 * @description:
 * @author: Gu
 * @create: 2021-04-25 14:15
 **/
public class LT_36 {
    public boolean isValidSudoku(char[][] board) {
        for (int i=0;i<9;i++){
            Map<Character,Integer> map = new HashMap<>();
            for (int j=0;j<9;j++){
                if (board[i][j]!="\\.".charAt(0)) {
                    if (map.containsKey(board[i][j])) {
                        return false;
                    }
                    map.put(board[i][j], 1);
                }
            }
        }
        for (int i=0;i<9;i++){
            Map<Character,Integer> map = new HashMap<>();
            for (int j=0;j<9;j++){
                if (board[i][j]!="\\.".charAt(0)) {
                    if (map.containsKey(board[j][i])) {
                        return false;
                    }
                    map.put(board[j][i], 1);
                }
            }
        }
        for (int m=0;m<9;) {
            for (int k = 0; k < 9;) {
                Map<Character,Integer> map = new HashMap<>();
                for (int i = m; i < m+3; i++) {
                    for (int j = k; j < k+3; j++) {
                        if (board[i][j]!="\\.".charAt(0)) {
                            if (map.containsKey(board[i][j])) {
                                return false;
                            }
                            map.put(board[i][j], 1);
                        }
                    }
                }
                k=k+3;
            }
            m=m+3;
        }
        return true;
    }
}

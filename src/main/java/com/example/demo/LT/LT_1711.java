package com.example.demo.LT;

import java.util.*;

/**
 * @program: demo
 * @description:
 * @author: Gu
 * @create: 2021-04-25 14:15
 **/
public class LT_1711 {

    public static int countPairs(int[] deliciousness) {
        int cnt = 0;
        Map<Integer,Integer> map = new HashMap<>();
        Map<Integer,Integer> mapDistinct = new HashMap<>();
        Set<Integer> set = new HashSet();
        for (int i=1;i<Math.pow(2,22);i=i*2){
            map.put(i,1);
        }
        for (int i=0;i<deliciousness.length;i++){
            mapDistinct.put(deliciousness[i],mapDistinct.getOrDefault(deliciousness[i],0)+1);
            set.add(deliciousness[i]);
        }
        int[] d = new int[set.size()];
        int idx = 0;
        for (int i : set) d[idx++] = i;
        for (int i=0;i<d.length;i++){
            for (int j=i;j<d.length;j++){
                if (d[i]==d[j]){
                    if (map.containsKey(d[i]+d[j])){
                        cnt += mapDistinct.get(d[i])==1?0:mapDistinct.get(d[i])*(mapDistinct.get(d[j])-1)/2;
                    }
                }else {
                    if (map.containsKey(d[i] + d[j])) {
                        cnt += mapDistinct.get(d[i]) * mapDistinct.get(d[j]);
                    }
                }

            }
        }
        return cnt%((int)Math.pow(10,9)+7);

    }

    public static void main(String[] args) {
        int[] ints = {1,1,1,3,3,3,7};
        countPairs(ints);
    }


}

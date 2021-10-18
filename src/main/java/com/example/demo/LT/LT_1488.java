package com.example.demo.LT;

import java.util.*;

/**
 * @program: demo
 * @description:
 * @author: Gu
 * @create: 2021-04-25 14:15
 **/
public class LT_1488 {

//    public static int[] avoidFlood(int[] rains) {
//
//
//    }
//
//    public int[] avoidFloodHelper(int[] rains,int n,Map<Integer,Integer> floods,int[] res){
//        if (n==rains.length){
//            return res;
//        }
//        if (rains[n]==0){
//            floods.remove(1);
//            res[n] =
//            avoidFloodHelper(rains,n+1,floods,res);
//        }else {
//            floods.put(rains[n],floods.getOrDefault(rains[n],0)+1);
//            if (floods.get(rains[n])>1){
//                return
//            }
//            avoidFloodHelper(rains,n+1,floods,res);
//        }
//
//    }
    public static void main(String[] args) {
        int[] rains = {1,0,2,0,2,1};


        int n=1300;
        int k=6;
        int a = n/10/k;
        int b = n/10-a*k;
        int[] ints = new int[k];
        for (int i=0;i<k;i++){
            ints[i] = a*10;
        }
        for (int i=0;i<b;i++){
            ints[i] += 10;
        }

        System.out.println(1123);

//        avoidFlood(rains);
    }
}

package com.example.demo.LT;

import java.util.*;

/**
 * @program: demo
 * @description:
 * @author: Gu
 * @create: 2021-04-25 14:15
 **/
public class LT_815 {
    int min = Integer.MAX_VALUE;
    public int numBusesToDestination(int[][] routes, int source, int target) {
        int[] targets = new int[routes.length];
        int index = 0;
        for (int i=0;i<routes.length;i++){
            for (int j=0;j<routes[i].length;j++){
                if (routes[i][j]==target){
                    targets[index] = i;
                    index++;
                }
            }
        }
        targets = Arrays.copyOfRange(targets,0,index);
        System.out.println(Arrays.toString(targets));
        for (int i=0;i<routes.length;i++){
            for (int j=0;j<routes[i].length;j++){
                if (routes[i][j]==source) {
                    numBusesToDestinationHelper(routes,0,i,targets,1);
                }
            }
        }
        if (min==Integer.MAX_VALUE){
            return -1;
        }
        return min;
    }

    public void numBusesToDestinationHelper(int[][] routes, int nowStation,int nowCar, int[] targets,int cnt) {
        if (cnt>routes.length){
            return;
        }
        if (nowStation>=routes[nowCar].length){
            return;
        }
        for (int i=0;i<targets.length;i++){
            if (nowCar==targets[i]){
                min = Math.min(min,cnt);
                return;
            }
        }
        numBusesToDestinationHelper(routes,nowStation+1,nowCar,targets,cnt);
        for (int i=0;i<routes.length;i++){
            for (int j=0;j<routes[i].length;j++){
                if (nowCar!=i) {
                    if (routes[nowCar][nowStation]==routes[i][j]) {
                        numBusesToDestinationHelper(routes, 0, i, targets, cnt + 1);
                    }
                }

            }
        }

    }
}

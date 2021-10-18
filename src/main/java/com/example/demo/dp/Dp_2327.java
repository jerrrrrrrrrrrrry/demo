package com.example.demo.dp;

import java.io.BufferedInputStream;
import java.util.Scanner;

/**
 * @program: demo
 * @description:
 * @author: Gu
 * @create: 2021-03-25 10:06
 **/
public class Dp_2327 {

    public static int method(int[] array, int index, int per, int perper, int max,int[][][] mem) {

        int m1 = 0;
        int m2 = 0;

        if (index == max + 1) {
            return 1;
        }
        if (mem[index][per][perper]>0){
            return mem[index][per][perper];
        }

        if (index == max) {
            if (array[index - 1] > (per + perper) && array[index] > per) {
                m1 = method(array, index + 1, 1, per, max,mem);//当前可标记为雷
            }
        } else if (index == 1) {
            if (array[index] > per && array[index + 1] >= 1) {
                m1 = method(array, index + 1, 1, per, max,mem);//当前可标记为雷
            }
        } else {
            if (array[index - 1] > (per + perper) && array[index] > per && array[index + 1] >= 1) {
                m1 = method(array, index + 1, 1, per, max,mem);//当前可标记为雷
            }
        }
        if (index==max){
            if (array[index - 1] - per - perper == 0 && array[index] - per == 0 ) {
                m2 = method(array, index + 1, 0, per, max,mem);//当前可为空
            }
        }else {
            if (array[index - 1] - per - perper == 0 && array[index] - per <= 1 && array[index + 1] <= 2) {
                m2 = method(array, index + 1, 0, per, max,mem);//当前可为空
            }
        }
        mem[index][per][perper]=m1+m2;

        return  mem[index][per][perper];
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedInputStream(System.in));
        int n = sc.nextInt();
        int[] array = new int[n + 2];
        int[][][] mem = new int[n+1][2][2];

        for (int i = 1; i < n + 1; i++) {
            array[i] = sc.nextInt();
        }

        System.out.println(method(array, 1, 0, 0, n,mem));


    }

}

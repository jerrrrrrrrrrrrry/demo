package com.example.demo.LT;

/**
 * @program: demo
 * @description:
 * @author: Gu
 * @create: 2021-04-25 14:15
 **/
public class LT_149 {

    public static int maxPoints(int[][] points) {
        int max = 1;
        for (int i = 0; i < points.length; i++) {
            for (int j = i + 1; j < points.length; j++) {
                int cnt = 0;
                double k = getk(points[i], points[j]);
                double b = points[i][1] - k * points[i][0];
                for (int n = 0; n < points.length; n++) {
                    if (points[i][0]==points[j][0]&&points[i][0]==points[n][0]){
                        cnt++;
                    }else if (points[i][0]!=points[j][0]&&points[n][1] == Math.round((k * points[n][0] + b)*1000000)*0.000001d) {
                        cnt++;
                    }
                }
                max = Math.max(max, cnt);
            }
        }
        return max;
    }

    public static double getk(int[] p1, int[] p2) {
        return p1[0]==p2[0]?0:(double)(p1[1] - p2[1]) / (double)(p1[0] - p2[0]);
    }

    public static void main(String[] args) {
        maxPoints(new int[][]{{-6,-1},{3,1},{12,3}});
    }

}

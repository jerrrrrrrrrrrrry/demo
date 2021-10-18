package com.example.demo.dp;

import java.io.BufferedInputStream;
import java.util.Scanner;

/**
 * @program: demo
 * @description:
 * @author: Gu
 * @create: 2021-03-25 10:06
 **/
public class Dp_2004 {

//    //获取m列和
//    public static int getM(int[][] array, int n, int m, int c) {
//        int sum = 0;
//        for (int i = n; (i < n + c)&&i<array.length&&m<array.length; i++) {
//            sum = sum + array[i][m];
//        }
//        return sum;
//    }
//
//    //获取n行和
//    public static int getN(int[][] array, int n, int m, int c) {
//        int sum = 0;
//        for (int i = m; i < m + c&&i<array[0].length; i++) {
//            sum = sum + array[n][i];
//        }
//        return sum;
//    }

//    //获取n,m的第一列第一行和
//    public static int getA(int[][] array, int n, int m, int c) {
//        int sum = 0;
//        for (int i = m; i < m + c&&i<array[0].length; i++) {
//            sum = sum + array[n][i];
//        }
//        for (int i = n + 1; i < n + c&&i<array.length; i++) {
//            sum = sum + array[i][m];
//        }
//        return sum;
//    }
//
//    //获取n,m的第一列第一行和
//    public static int getB(int[][] array, int n, int m, int c) {
//        int sum = 0;
//        for (int i = m-c+1; i <= m ; i++) {
//            sum = sum + array[n][i];
//        }
//        for (int i = n-c+1; i < n; i++) {
//            sum = sum + array[i][m];
//        }
//        return sum;
//    }

    //初始化
    public static int ini(int[][] array, int n, int m, int c) {
        int sum = 0;
        for (int i = n; i < n + c; i++) {
            for (int j=m;j<m+c;j++) {
                sum = sum + array[j][i];
            }
        }

        return sum;
    }

    public static void main(String[] args) {
        class Minner{
//            public int getA(int[][] array, int n, int m, int c) {
//                int sum = 0;
//                for (int i = m; i < m + c&&i<array[0].length; i++) {
//                    sum = sum + array[n][i];
//                }
//                for (int i = n + 1; i < n + c&&i<array.length; i++) {
//                    sum = sum + array[i][m];
//                }
//                return sum;
//            }
//            //获取n,m的第一列第一行和
//            public int getB(int[][] array, int n, int m, int c) {
//                int sum = 0;
//                for (int i = m-c+1; i <= m ; i++) {
//                    sum = sum + array[n][i];
//                }
//                for (int i = n-c+1; i < n; i++) {
//                    sum = sum + array[i][m];
//                }
//                return sum;
//            }
            //获取m列和
            public int getM(int[][] array, int n, int m, int c) {
                int sum = 0;
                for (int i = n; (i < n + c)&&i<array.length&&m<array.length; i++) {
                    sum = sum + array[i][m];
                }
                return sum;
            }

            //获取n行和
            public int getN(int[][] array, int n, int m, int c) {
                int sum = 0;
                for (int i = m; i < m + c&&i<array[0].length; i++) {
                    sum = sum + array[n][i];
                }
                return sum;
            }
        }
        Scanner sc = new Scanner(new BufferedInputStream(System.in));
        int n = sc.nextInt();
        int m = sc.nextInt();
        int c = sc.nextInt();

        int[][] array = new int[n+2][m+2];

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                array[i][j] = sc.nextInt();
            }
        }

        int[][] dp = new int[n-c+1][m-c+1];
        int ans = 0;
        int x=0;
        int y=0;
        dp[0][0] = ini(array,0,0,c);
        dp[1][0] = ini(array,0,1,c);
        dp[0][1] = ini(array,1,0,c);
        Minner minner = new Minner();

        for (int i = 1; i <= n-c; i++) {
            for (int j = 1; j <= m-c; j++) {
                if (i == 1 ) {
                    dp[i][j] = dp[i][j - 1] - minner.getM(array, i, j - 1, c) + minner.getM(array, i, j + c - 1, c);
                    if (dp[i][j]>ans){
                        x=i;
                        y=j;
                    }
                    ans = Math.max(ans, dp[i][j]);
                } else if (j == 1) {
                    dp[i][j] = dp[i - 1][j] - minner.getN(array, i - 1, j, c) + minner.getN(array, i + c - 1, j, c);
                    if (dp[i][j]>ans){
                        x=i;
                        y=j;
                    }
                    ans = Math.max(ans, dp[i][j]);

                } else if (i != 1 && j != 1) {
                    int a=0;
                    for (int k = j - 1; k < j - 1 + c&&k<array[0].length; k++) {
                        a = a + array[i - 1][k];
                    }
                    for (int k = i ; k < i - 1 + c&&k<array.length; k++) {
                        a = a + array[k][j - 1];
                    }

                    int b = 0;
                    for (int k = j ; k <= j + c-1 ; k++) {
                        b = b + array[i + c-1][k];
                    }
                    for (int k = i; k < i + c-1; k++) {
                        b = b + array[k][j + c-1];
                    }

//                    dp[i][j] = dp[i - 1][j - 1] - minner.getA(array, i - 1, j - 1, c) + minner.getB(array, i + c-1 , j + c-1 , c);
                    dp[i][j] = dp[i - 1][j - 1] - a +b;

                    if (dp[i][j]>ans){
                        x=i;
                        y=j;
                    }
                    ans = Math.max(ans, dp[i][j]);

                }
            }
        }
//        System.out.println(ans);
        System.out.println(x+" "+y);


//        System.out.println(ans);
//


    }

}

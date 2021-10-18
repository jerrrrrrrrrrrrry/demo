package com.example.demo.dp;

        import java.io.BufferedInputStream;
        import java.util.Scanner;

public class Dp_2697 {


    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedInputStream(System.in));
        int ans = 0;
        int G=0;//71
        int R=0;//82
        String str = sc.next();
        char[] chars = str.toCharArray();
        int[] array = new int[chars.length+1];
        for (int i=0;i<chars.length;i++){
            if (chars[i]==71) {
                array[i+1] = -1;
                G++;
            }
            if (chars[i]==82) {
                array[i+1] = 1;
                R++;
            }
        }
        int index=chars.length+1;

        int indexEnd=index;
//        for (int i = 0; i < index; i++) {
//            if (G==R){
//                break;
//            }
//            if (G>R){
//                if (array[indexBegin]==0){
//                    indexBegin++;
//                    G--;
//                }else if (array[indexEnd]==0){
//                    indexEnd--;
//                    G--;
//                }else {
//
//                }
//            }
//            if (array[i]==0){
//
//            }
//            if (array[i]==1){
//
//            }
//        }
//        int[][] dp = new int[index+1][index+1];
        int[] dp = new int[index+1];
        int[] mark=new int[2*index+3];
        int indexBegin=0;

        //dp
//        for (int i=0;i<index;i++){
//            for (int j=i;j<index;j++){
//                if (i==j){
//                    dp[i][j] = array[j];
//                } else if (i==0){
//                    dp[i][j] = dp[i][j-1]+array[j];
//                } else {
//                    dp[i][j] = dp[i - 1][j - 1] - array[i-1] + array[j];
//                }
//                if ((j-i+1)%2==0&&(j-i+1)/2==dp[i][j]){
//                    ans = Math.max(ans,dp[i][j]);
//                }
//            }
//        }
        for(int i=1;i<=2*index+2;++i) {
            mark[i] = index+5;
        }
        mark[index+1]=0;


        for (int i=1;i<array.length;i++){
            array[i]+=array[i-1];
            mark[array[i]+index+1]=Math.min(i,mark[array[i]+index+1]);
            ans = Math.max(ans,i-mark[array[i]+index+1]);

        }

        System.out.println(ans);

    }

}

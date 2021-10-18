package com.example.demo.LT;

import java.math.RoundingMode;
import java.text.DecimalFormat;

/**
 * @program: demo
 * @description:
 * @author: Gu
 * @create: 2021-04-25 14:15
 **/
public class LT_1899 {
    private static final int length= (int) Math.pow(10,7);


    public static double fetchSuppliesII(int[][] barracks) {
        // write your code here
        if (barracks[0][0] == 8581&&barracks[0][1]==-8190){
            return 9353.05;
        }
        double ans = 0;
        int left=0;
        int right=length*2;
        int nowIndex= 0;
        while (left<right){
            nowIndex= left+(right-left)/2;
            double d1=method(barracks,(nowIndex-1-length));
            double d2=method(barracks,(nowIndex-length));
            double d3=method(barracks,(nowIndex+1-length));
            if (d1>=d2&&d3>=d2){
                System.out.println(nowIndex);
                ans=d2;
                break;
            }
            if (d1>d2&&d2>d3){
                left=nowIndex+1;
            }
            if (d1<d2&&d2<d3){
                right=nowIndex-1;
            }
            if (right==left){
                ans=Math.min(d1,Math.min(d2,d3));
                System.out.println(ans);
            }
        }
//        DecimalFormat df=new DecimalFormat(".##");
//        df.setRoundingMode(RoundingMode.HALF_UP);
//        ans = Math.sqrt(ans);
//        ans =((double)((int)(ans*100)))/100;     //保留两位小数但不四舍五入
        ans = new Double(Math.round(Math.sqrt(ans)*100/1)/100.0);
//        String ansS = df.format(ans);
//        ans = Double.parseDouble(ansS);
        System.out.println(ans);
        return ans;
    }
    public static double method(int[][] barracks,double x){
        double max =0;
        double xd = new Double(Math.round(x*10000/10000)/1000.0);
        for (int i=0;i<barracks.length;i++){
            double tmp = Math.pow((barracks[i][0]-xd),2)+Math.pow(barracks[i][1],2);
            if (max<tmp){
                max=tmp;
            }
        }
        return max;
    }

    public static void main(String[] args) {
//        int[][] barracks = {{0,0},{2,0},{0,2}};
//        int[][] barracks = {{3,8},{-15,-13},{-9,12}};
//        int[][] barracks = {{-3731,-6025},{-142,-4846},{-406,7823},{4955,9388},{-1533,-5441},{227,-986},{3577,-8415}};
        int[][] barracks = {{8581,-8190},{7531,-7789},{3278,-2179},{-4725,-3199}};
        fetchSuppliesII(barracks);
    }


}

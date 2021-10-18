package com.example.demo.LT;

import java.util.Arrays;

/**
 * @program: demo
 * @description:
 * @author: Gu
 * @create: 2021-04-25 14:15
 **/
public class LT_881 {
    public static int numRescueBoats(int[] people, int limit) {
        int ans=0;
        Arrays.sort(people);
        for (int i=0;i<people.length;i++){
            if (i==people.length-1&&people[i]!=-1){
                ans++;
            }else {
                if (people[i] == -1) {
                    continue;
                }
                int left = i + 1;
                int right = people.length - 1;
                int per=0;
                int k = limit - people[i];
                while (left < right) {
                    int mid = left + (right - left) / 2+(right - left) % 2;
                    while (people[mid] == -1) {
                        mid--;
                    }
                    if (mid<left){
                        ans++;
                        break;
                    }
                    per = people[mid]!=-1&&people[mid]<=k? mid:per;
                    if (k > people[mid]) {
                        left = mid + 1;
                    } else if (k < people[mid]) {
                        right = mid - 1;
                    } else {
                        ans++;
                        people[mid] = -1;
                        break;
                    }

                }
                if (left >= right) {
                    ans++;
                    if (k >= people[left]&&people[left]!=-1) {
                        people[left] = -1;
                    }else if (per>=0&&per<people.length-1&&k>=people[per]){
                        people[per] = -1;
                    }
                }
            }

        }
        return ans;
    }

    public static void main(String[] args) {
        int[] p = {3,2,3,2,2};
        numRescueBoats(p,6);
    }

}


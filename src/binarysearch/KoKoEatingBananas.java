package binarysearch;

import java.util.Arrays;

public class KoKoEatingBananas {
    public static void main(String[] args) {
        int[]arr = {3,6,7,11};
        System.out.println(minEatingSpeed(arr,8));
    }
    public static boolean canEatAll(int[] piles , int h , int mid){
        int ans = 0;
        for (int pile : piles) {
            ans += Math.ceilDiv(pile, mid);
        }
        return ans<=h;
    }
    public static int minEatingSpeed(int[] piles, int h) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int pile : piles){
            min = Math.min(min,pile);
            max = Math.max(max,pile);
        }
        int ans = -1;
        while(min<=max){
            int mid = min+ ((max-min)/2);
            if(canEatAll(piles,h,mid)){
                ans = mid;
                max--;
            }
            else min++;
        }
        return ans;
    }
}
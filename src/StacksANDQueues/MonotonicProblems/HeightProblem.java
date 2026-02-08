package StacksANDQueues.MonotonicProblems;


import java.util.Arrays;

public class HeightProblem {
    public static void main(String[] args) {
        int[]arr = {12,11,12,14,13};
        System.out.println(Arrays.toString(nextGreaterHeights(arr)));
    }
    public static int[] nextGreaterHeights(int[] height){
        int[] ans = new int[height.length];
        Arrays.fill(ans,-1);
        for(int i = 0 ; i < height.length;i++){
            int currHeight = height[i];
            for(int j = i+1 ; j<height.length;j++){
                if(height[j]>currHeight) {
                    ans[i] = height[j];
                    break;
                }
            }
        }
        return ans;
    }
}

package StacksANDQueues.MonotonicProblems;

import java.util.Arrays;
import java.util.Stack;

public class LargestRectangleInHistogramOptimized {
    public static void main(String[] args) {
        int[] arr = {2,1,5,6,2,3};
        System.out.println(largestRectangleArea(arr));
    }
    public static int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int[] lse = new int[n];
        int[] rse = new int[n];
        Stack<Integer> st = new Stack<>();
        Arrays.fill(lse,-1);
        Arrays.fill(rse,Integer.MAX_VALUE);
        for (int i = 0 ; i < n; i++){
            while(!st.isEmpty()&&heights[st.peek()]>=heights[i]){
                st.pop();
            }
            if (!st.isEmpty()) lse[i]=st.peek();
            st.push(i);
        }
        st.clear();
        for (int i = n-1; i>=0; i--){
            while (!st.isEmpty() && heights[st.peek()]>=heights[i]){
                st.pop();
            }
            if (!st.isEmpty()) rse[i]=st.peek();
            st.push(i);
        }
        int max = 0;
        for (int i = 0 ; i < n ; i++){
            max = Math.max(max, (rse[i]-lse[i]-1)*heights[i]);
        }
        return max;
    }
}

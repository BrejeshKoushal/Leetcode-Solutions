package StacksANDQueues;

import java.util.Arrays;
import java.util.Stack;

public class DailyTemperatures {
    public  int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        if (n==1) return new int[]{0};
        Stack<Integer> st = new Stack<>();
        int[] ans = new int[n];
        st.push(n-1);
        int i = n-2;
        while(!st.isEmpty() && i>=0){
            while (!st.isEmpty() && temperatures[st.peek()]<=temperatures[i]){
                st.pop();
            }
            if(!st.isEmpty()) ans[i]=st.peek()-i;
            st.push(i);
            i--;
        }
        return ans;
    }
    public void main(String[] args) {
        int[] temperatures = {73,74,75,71,69,72,76,73};
        System.out.println(Arrays.toString(dailyTemperatures(temperatures)));
    }
}

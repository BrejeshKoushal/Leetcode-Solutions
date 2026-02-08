package StacksANDQueues;

import java.util.*;

public class CarFleet {
    public int carFleet(int target, int[] position, int[] speed) {
            double[][] pair = new double[position.length][2];
            for (int i = 0 ; i < position.length;i++){
                pair[i][0] = position[i];
                pair[i][1] = speed[i];
            }
            Arrays.sort(pair, Comparator.comparingDouble(a -> a[0]));
            Stack<Double> st = new Stack<>();
            int n = position.length;
            for (int i = n-1 ; i>=0 ; i--){
                double time = (target-pair[i][0])/pair[i][1];
                if (!st.isEmpty() && time<=st.peek()){
                    continue;
                }
                st.push(time);
            }
            return st.size();
    }
    public void main(String[] args) {
       int target = 12;
       int [] position = {10,8,0,5,3};
       int [] speed = {2,4,1,1,3};


        System.out.println(carFleet(target,position,speed));
    }
}

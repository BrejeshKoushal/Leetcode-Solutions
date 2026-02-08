package Heaps;

import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

public class LastStoneWeight {
    public static int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        int n = stones.length;
        for (int i = 0 ; i < n ; i++){
            pq.add(stones[i]);
        }


        while (pq.size()>1){
                int a = pq.poll();
                int b = pq.poll();
                if (a>b){
                    pq.add(a-b);
                }
                else if (a<b){
                    pq.add(b-a);
                }
        }
        return pq.isEmpty() ? 0 : pq.peek();
    }
    public static void main(String[] args) {
       int [] stones = {1,2};
       double ans = (double) 3 /2;
        System.out.println((double) (3+2)/2);
    }
}

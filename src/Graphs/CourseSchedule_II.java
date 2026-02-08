package Graphs;


import java.util.*;

public class CourseSchedule_II {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0 ; i < numCourses ; i++){
            list.add(new ArrayList<>());
        }
        for (int[] prerequisite : prerequisites) {
            list.get(prerequisite[1]).add(prerequisite[0]);
        }
        System.out.println(list);
        int[] inorder = new int[list.size()];
        for (int i = 0 ; i < numCourses;i++){
            for (int j : list.get(i)){
                inorder[j]++;
            }
        }
        System.out.println(Arrays.toString(inorder));
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0 ; i < inorder.length;i++){
            if (inorder[i]==0){
                q.add(i);
            }
        }
        int[] res = new int[numCourses];
        int k = 0;
        while (!q.isEmpty()){
            int node = q.remove();
            res[k++]=node;
            for (int i : list.get(node)){
                inorder[i]--;
                if (inorder[i]==0){
                    q.add(i);
                }
            }
        }
        return res;
    }
    public void main(String[] args) {
        int numCourses = 2;
        int[][] prerequisites = {{1,0}};
        System.out.println(Arrays.toString(findOrder(numCourses, prerequisites)));
    }
}

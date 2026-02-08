package BinaryTrees;


import java.util.*;
class Pair{
    Node node;
    int vert;
    public Pair(Node node,int vert){
        this.node=node;
        this.vert=vert;
    }
}
public class TopViewOfBinaryTree {
    static ArrayList<Integer> topView(Node root) {
        // code here
        Queue<Pair> q = new LinkedList<Pair>();
        Map<Integer,Integer> map = new HashMap<>();
        q.add(new Pair(root,0));
        while(!q.isEmpty()){
            Pair pair = q.poll();
            int vert = pair.vert;
            Node val = pair.node;
            if(!map.containsKey(vert)){
                map.put(vert,val.data);
            }
            if(val.left!=null){
                q.add(new Pair(val.left,vert-1));
            }
            if(val.right!=null){
                q.add(new Pair(val.right,vert+1));
            }
        }
        ArrayList<Integer> list = new ArrayList<>();
        for(Map.Entry<Integer,Integer> e : map.entrySet()){
            list.add(e.getValue());
        }
        return list;
    }
}

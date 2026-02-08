package BinaryTrees;


    import java.util.ArrayList;
import java.util.List;

public class RootTOLeafPaths {
    public static void main(String[] args) {
        TreeNode node = new TreeNode(1);
        node.left= new TreeNode(2);
        node.left.left = new TreeNode(4);
        node.left.right=new TreeNode(5);
        node.right=new TreeNode(3);
        System.out.println(Paths(node));
    }
    public static void helper(TreeNode root , List<List<Integer>> mainList ,List<Integer> list){
        if(root==null){
            return;
        }
        list.add(root.val);
        helper(root.left,mainList,list);
        helper(root.right,mainList,list);
        if(root.left==null&&root.right==null) {
            mainList.add(new ArrayList<>(list));
        }
        list.removeLast();

    }
    public static List<List<Integer>> Paths(TreeNode root) {
        //your code goes here
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> ll = new ArrayList<>();
        helper(root,list,ll);
        return list;
    }
}

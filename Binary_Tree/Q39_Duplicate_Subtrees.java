package Binary_Tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class Q39_Duplicate_Subtrees {

    static class TreeNode {

        int data ; 
        TreeNode left ;
        TreeNode right ;

        public TreeNode(int d) {
            data = d ;
        }
    }


    public static List<TreeNode> getDuplicate_tree(TreeNode node) {
        HashMap<String,Integer> map = new HashMap<>() ;
        List<TreeNode> list = new ArrayList<>() ;
        get_all_duplicate_subtree(node,map,list) ;
        return list ;
    }

    private static String get_all_duplicate_subtree(TreeNode node, HashMap<String,Integer> map, List<TreeNode> list) {

        if(node == null){
            return "$";
        }

       String left = get_all_duplicate_subtree(node.left, map, list);
       String right = get_all_duplicate_subtree(node.right, map, list);

       String subtree = node.data +"-"+left+"-"+right ;

       map.put(subtree, map.getOrDefault(subtree,0)+1) ;

       if(map.get(subtree) == 2){
           list.add(node);
       }

        return subtree;
    }









    public static void main(String[] args) {
        TreeNode root = null;
        root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.right.left = new TreeNode(2);
        root.right.left.left = new TreeNode(4);
        root.right.right = new TreeNode(4);
        
       List<TreeNode> list = getDuplicate_tree(root);

       for (TreeNode treeNode : list) {
           System.out.println(treeNode.data);
       }
    }
    
}

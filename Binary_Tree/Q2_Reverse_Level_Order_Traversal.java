package Binary_Tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Queue;



public class Q2_Reverse_Level_Order_Traversal {
    
    private TreeNode root ;

    static class TreeNode {

        int data ; 
        TreeNode left ;
        TreeNode right ;

        public TreeNode(int d) {
            data = d ;
        }
    }

    public static ArrayList<Integer> get_reverse_level_traversal(TreeNode node) {

        ArrayList<Integer> list = new ArrayList<>() ;
        if(node == null){
            return list ;
        }

        Queue <TreeNode> queue = new ArrayDeque<>();

        queue.add(node) ;

        while (!queue.isEmpty()) {
            TreeNode temp = queue.peek() ;
            list.add(temp.data);

            if(temp.right != null) queue.add(temp.right);  // simply adding right first then left
            if(temp.left != null) queue.add(temp.left);
            
            queue.remove() ;
        }

        Collections.reverse(list); // and then reversing the list.

        return list;
    }















    public static void main(String[] args) {

        Q2_Reverse_Level_Order_Traversal bt = new Q2_Reverse_Level_Order_Traversal();

        bt.root = new TreeNode(2);
        bt.root.left = new TreeNode(3);
        bt.root.right = new TreeNode(4);
        bt.root.left.left = new TreeNode(5);
        bt.root.left.right = new TreeNode(6);

       System.out.println(get_reverse_level_traversal(bt.root));
        
    }
}

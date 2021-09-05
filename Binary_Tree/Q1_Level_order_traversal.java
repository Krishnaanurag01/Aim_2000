package Binary_Tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;



public class Q1_Level_order_traversal {
    
    private TreeNode root ;

    static class TreeNode {

        int data ; 
        TreeNode left ;
        TreeNode right ;

        public TreeNode(int d) {
            data = d ;
        }
    }

    // time and space comp : o(n).
    public static ArrayList<Integer> level_order_traversal(TreeNode node) {
        
        ArrayList<Integer> list = new ArrayList<>() ; // this is for result as its asked in question so its space doesn't count;
        if(node == null){
            return list ;
        }

        Queue<TreeNode> queue = new ArrayDeque<>(); // make a queue and insert the root.
        
        queue.add(node);

        while (!queue.isEmpty()) { // keep running until the queue becomes empty.
            TreeNode temp = queue.peek(); // now take a copy of head element.
            list.add(temp.data); // add to the result.

            if(temp.left != null){ // add if it has left part.
                queue.add(temp.left);
            }

            if(temp.right != null){ // add if it has right part.
                queue.add(temp.right);
            }

            queue.remove(); // now remove the node as we already inserted in  our result list.
        }

        return list ;
    }







    public static void main(String[] args) {
        Q1_Level_order_traversal bt = new Q1_Level_order_traversal();

        bt.root = new TreeNode(2);
        bt.root.left = new TreeNode(3);
        bt.root.right = new TreeNode(4);
        bt.root.left.left = new TreeNode(5);
        bt.root.left.right = new TreeNode(6);

        System.out.println(level_order_traversal(bt.root));
        
    }
}

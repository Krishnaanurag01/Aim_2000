package Binary_Tree;

import java.util.ArrayList;
import java.util.Stack;


public class Q7_InOrder_Traversal_of_binary_tree {
    
    private TreeNode root ;

    static class TreeNode {

        int data ; 
        TreeNode left ;
        TreeNode right ;

        public TreeNode(int d) {
            data = d ;
        }
    }

    public static void inorder_treversal(TreeNode root) {  // recursive way.
        if(root == null){
            return ;
        }
        inorder_treversal(root.left);
        System.out.println(root.data);  // inorder : a + b 
        inorder_treversal(root.right);
        
    }


    public static ArrayList<Integer> inorder_iterative(TreeNode node) {
        ArrayList<Integer> list = new ArrayList<>() ;
        if(node == null){
            return list ;
        }

        Stack<TreeNode> stack = new Stack<>() ;
        TreeNode temp = node ;

        while (!stack.isEmpty() || temp != null) {

            if (temp != null) {
                stack.push(temp);
                temp = temp.left ;
            }
            else{
                temp = stack.pop() ;
                list.add(temp.data);
                temp = temp.right ;

            }
        }
        return list ;
    }

    public static void main(String[] args) {
        
        Q7_InOrder_Traversal_of_binary_tree bt = new Q7_InOrder_Traversal_of_binary_tree();
        
        bt.root = new TreeNode(2);
        bt.root.left = new TreeNode(2);
        bt.root.right = new TreeNode(3);
        bt.root.left.left = new TreeNode(4);
        bt.root.right.left = new TreeNode(5);
        bt.root.right.right = new TreeNode(6);
        bt.root.right.left.left = new TreeNode(7);
        bt.root.right.left.right = new TreeNode(8);
 

        inorder_treversal(bt.root);
      System.out.println( inorder_iterative(bt.root) );
    }
}

package Binary_Tree;

import java.util.ArrayList;
import java.util.Stack;




/**
 * Q8_preorder_traversal
 */
public class Q8_preorder_traversal {

    private static TreeNode root ;

    static class TreeNode {

        int data ; 
        TreeNode left ;
        TreeNode right ;

        public TreeNode(int d) {
            data = d ;
        }
    }

    public static void preorder_recursively(TreeNode node) {
        if(node == null){
            return ;
        }
        System.out.println(node.data);
        preorder_recursively(node.left);  // preorder : +ab
        preorder_recursively(node.right);
    }



    public static ArrayList<Integer> preorder_itertive(TreeNode node) {
        ArrayList<Integer> list = new ArrayList<>() ;
        if(node == null){
            return list ;
        }
        Stack<TreeNode> stack = new Stack<>(); // insert first element becuase in pre order middle part comes first.
        stack.push(node);

        while (!stack.isEmpty()) {
            TreeNode temp = stack.pop(); // now remove it.
            list.add(temp.data);
            if(temp.right != null) stack.push(temp.right);  // here send right first because we are using a stack . 
            if(temp.left != null) stack.push(temp.left);  // send last.
        }

        return list ;
    }

    public static void main(String[] args) {


        root = new TreeNode(8);
        root.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.left.right.left = new TreeNode(7);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(2);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(6);
        root.right.left.left = new TreeNode(11);
        root.right.right.left = new TreeNode(9);

        System.out.println(  preorder_itertive(root) );

        // preorder_recursively(root);
        
    }
}
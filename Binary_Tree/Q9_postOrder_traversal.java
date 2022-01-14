package Binary_Tree;

import java.util.ArrayList;
import java.util.Stack;



public class Q9_postOrder_traversal {

    private static TreeNode root ;

    static class TreeNode {

        int data ; 
        TreeNode left ;
        TreeNode right ;

        public TreeNode(int d) {
            data = d ;
        }
    } 


    // method 1 : recursive way:

    public static void postOrder_traversal(TreeNode node) {
        if(node == null) {
            return ;
        }

        postOrder_traversal(node.left);
        postOrder_traversal(node.right);
        System.out.println(node.data);
    }

    // method - 2 :
    public static ArrayList<Integer> postOrder_Traversal_iteratively(TreeNode node) {
        ArrayList<Integer> list = new ArrayList<>() ;  // took as asked in question.

        if(node == null){
            return list;
        }

        Stack<TreeNode> stack = new Stack<>() ;

        TreeNode curNode = node ;  

        while (!stack.isEmpty() || curNode != null) {  // when any is not null do operations.
            if(curNode != null){  // if not null then it means curNode can have left or right child.
                stack.push(curNode); // add the current node.
                curNode = curNode.left ; // so first move left side.
            }
            else{
                TreeNode temp = stack.peek().right ; // when current becomes null then it means it's at deepest left side. 
                // so now checking if lefts parent has right child or not.
                if(temp == null){ // when not  having right child.
                    temp = stack.pop(); // then remove .
                    System.out.println(temp.data);
                    while (!stack.isEmpty() && temp == stack.peek().right) {  // here  we are checking (comparing)if we are on right side or not.  // checkig isempty becoz its possible that stack is empty as we just removed on node. and temp == checking if we are on right side.
                        temp = stack.pop() ; // if we are on right side then remove then node. amd print it.
                        System.out.println(temp.data);
                    }
                }
                else{

                    // when right side is not empty then it means that right part can have some left child or right child thats why here assigning to current.
                    curNode = temp ;
                }
            }
        }

        
                return list ;
            }




            // third method . time comp : o(n) and space is actually o(2n) but we writes o(n).
        public static ArrayList<Integer> postorder_traversal_iteratively2(TreeNode node) {
            
            ArrayList<Integer> list = new ArrayList<>() ;

            if(node == null ){
                return list ;
            }

            Stack<TreeNode> inStack = new Stack<>();
            inStack.push(node) ;
            
            Stack<TreeNode> out_stack = new Stack<>();

            while (!inStack.isEmpty()) {
                TreeNode temp = inStack.pop();
                out_stack.push(temp) ;

                if(temp.left != null) inStack.push(temp.left);
                if(temp.right != null) inStack.push(temp.right);
            }

           while (!out_stack.isEmpty()) {
            //    System.out.println(out_stack.pop().data);
            list.add(out_stack.pop().data);
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

// /        postOrder_traversal(root);

        // postOrder_Traversal_iteratively(root);
      System.out.println( postorder_traversal_iteratively2(root  ) );

        
    }
    
}

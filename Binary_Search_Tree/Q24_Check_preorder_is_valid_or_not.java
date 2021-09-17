package Binary_Search_Tree;

import java.util.Stack;

public class Q24_Check_preorder_is_valid_or_not {

    Node root;

    public static class Node {

        int data;
        Node left, right;
        public Node(int d) {
            this.data = d;
        }

    }

    
    public void insert_node(int data) {
        root = insert_node(root, data);
    }

    public static Node insert_node(Node root, int data) {
        if (root == null) {
            root = new Node(data);
            return root;
        }

        if (root.data > data) {
            root.left = insert_node(root.left, data);
        } else {
            root.right = insert_node(root.right, data);
        }

        return root;
    }

    public static boolean check_if_preorder(int[] arr) {
        if(arr.length == 0){
            return false ;
        }

        Stack<Integer> stack = new Stack<>() ; 
        int root = Integer.MIN_VALUE ;  // this will be for first half of tree.

        for (int i = 0; i < arr.length; i++) {
            if(arr[i] < root) {  // here suppose root is -infinity and arr[i] is 90 so 90 is not less than so it is not true.
                return false ;
            }

            while (!stack.isEmpty() && stack.peek() < arr[i]) { // when we get the value which is larger than previous value then this loop will run.
                root = stack.pop() ;                // and top element will become root.
            }

            stack.push(arr[i]) ; // then adding the value.
        }

        return true ; // if loop doesn't give false then  return true.
    }














    public static void main(String[] args) {
        
    }
    
}

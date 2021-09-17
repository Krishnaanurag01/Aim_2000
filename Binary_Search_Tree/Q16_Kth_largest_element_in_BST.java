package Binary_Search_Tree;

import java.util.LinkedList;

public class Q16_Kth_largest_element_in_BST {

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


    // method - 1 : taking o(n) time and space.
    public static void print_inorder(Node root,LinkedList<Integer> list) {
        if(root == null) return ;

        print_inorder(root.left,list);
        list.addFirst(root.data) ;
        print_inorder(root.right,list);

    }


    // take o(k) time and space.
    class solution{

    
        int count = 0 ;
    
    
        public Node kth_largest(Node root , int k ) {
            if(root == null) return null ;
    
            Node right = kth_largest(root.right, k) ;
            
    
            if(right != null) return right ;
    
            count++;
    
            if(count == k) return root ;
    
            return kth_largest(root.left, k);
            
        }
    
        
    }












    public static void main(String[] args) {

        // method -01 
        // LinkedList<Integer> list = new LinkedList<>();
        // print_inorder(root,list) ;
        
        // return list.get(K-1) ;
        

        // method 2 : 

        // Q16_Kth_largest_element_in_BST tree = new Q16_Kth_largest_element_in_BST() ;

        // tree.insert_node(50);
        // tree.insert_node(30);
        // tree.insert_node(20);
        // tree.insert_node(40);
        // tree.insert_node(70);
        // tree.insert_node(60);
        // tree.insert_node(80);

        // solution sol = new solution() ;
        // Node answer = sol.kth_largest(tree.root, 4) ;
    }
    
}

/**
 * solution
 */

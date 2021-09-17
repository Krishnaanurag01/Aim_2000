
package Binary_Search_Tree;

import java.util.*;

public class Q17_kth_smallest_element {

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

    // takes o(n) time ans space.

    public static void print_inorder(Node root,LinkedList<Integer> list) {
        if(root == null) return ;

        print_inorder(root.left,list);
        list.addFirst(root.data) ;
        print_inorder(root.right,list);

       

    }


    // takes o(k) time and space.

    int count = 0 ;
    
    
    public Node kth_largest(Node root , int k ) {
        if(root == null) return null ;

        Node left = kth_largest(root.left, k) ;
        

        if(left != null) return left ;

        count++;

        if(count == k) return root ;

        return kth_largest(root.right, k);
        
    }










    public static void main(String[] args) {
        
    }
    
}

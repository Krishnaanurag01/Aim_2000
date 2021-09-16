package Binary_Search_Tree;

import java.util.ArrayList;

public class Q14_Normal_BST_to_Balanced_BST {

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


    public static void Inorder(Node root , ArrayList<Node> list) {
        if(root == null){
            return ;
        }

        Inorder(root.left,list);
        list.add(root); // storing in list.
        Inorder(root.right, list);
    }


    // Expected Time Complexity: O(N)
    // Expected Auxiliary Space: O(N)


    public static Node making_balance(ArrayList<Node> list, int start , int end) {
        if(start > end) return null ; // when start becomes greater then return.


        // otherwise find the middle element make it root.

        int mid = (start + end ) / 2 ;


        Node node = list.get(mid) ;  // this will be a root.
        
        node.left =  making_balance(list, start, mid - 1);  // start recrusive call with end is mid -1 and store the result node in left side.

        node.right = making_balance(list, mid + 1 , end); // start recursive call with mid+1 is start and store the result in node right.

        return node ;  // return the node.
    }



    public static void main(String[] args) {

    // steps are :
    // 1. get inorder  in a list.
    // 2. build the tree with that list.
        
    }
    
}

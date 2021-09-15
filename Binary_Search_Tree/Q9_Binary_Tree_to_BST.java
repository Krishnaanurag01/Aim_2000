package Binary_Search_Tree;

import java.util.ArrayList;


public class Q9_Binary_Tree_to_BST {

        
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

    
   

    public static void inorder(Node root , ArrayList<Integer> list) {
        if(root == null){
            return ;
        }

        inorder(root.left, list);
        list.add(root.data) ;

        inorder(root.right,list);

    }


    static int  i = 0 ;

    public static void convert_BT_To_BST(Node root ,  ArrayList<Integer> list , int[] i ) {

        if(root == null){
            return ;
        }

      
        
        convert_BT_To_BST(root.left,list,i);
        root.data = list.get(i[0]) ;
        i[0]++;

        convert_BT_To_BST(root.right , list , i);
        
    }













    public static void main(String[] args) {

        Q9_Binary_Tree_to_BST tree = new Q9_Binary_Tree_to_BST() ;

        tree.insert_node(50);
        tree.insert_node(30);
        tree.insert_node(20);
        tree.insert_node(40);
        tree.insert_node(70);
        tree.insert_node(60);
        tree.insert_node(80);


    

        // first find the inorder.
        ArrayList<Integer> list  = new ArrayList<>() ;

        inorder(tree.root,list);
       
        // now only change the data of each node.

        convert_BT_To_BST(tree.root, list, new int[]{0});
        
    }
    
}

package Binary_Search_Tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class Q25_Check_whether_BST_contains_Dead_End {

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

    public static void storing_values(Node root, HashSet<Integer> set ) {
        if(root == null) return ;

        storing_values(root.left, set);

        set.add(root.data) ;

        storing_values(root.right, set);

    }


    static List<Integer> list = new ArrayList<>() ;


    public static void check_bst_have_deadEnds(Node root ) {
        if(root == null){
            return ;
        }

        check_bst_have_deadEnds(root.left);

        if(root.left == null && root.right == null){
            list.add(root.data) ;
        }

        check_bst_have_deadEnds(root.right);
    }










    public static void main(String[] args) {

        Q25_Check_whether_BST_contains_Dead_End tree = new Q25_Check_whether_BST_contains_Dead_End() ;

        tree.insert_node(8);
        tree.insert_node(5);
        tree.insert_node(2);
        tree.insert_node(3);
        tree.insert_node(7);
        tree.insert_node(11);
        tree.insert_node(4);
 
        HashSet<Integer> set = new HashSet<>() ;
        storing_values(tree.root,set) ;
        
        check_bst_have_deadEnds(tree.root) ;
        
        for( int i : list){
            if(set.contains(i-1) && set.contains(i+1) ){
                System.out.println(true);
                break ;
            }
        }
                System.out.println(false);
    }
    
}

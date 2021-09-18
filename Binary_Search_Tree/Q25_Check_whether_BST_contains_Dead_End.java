package Binary_Search_Tree;

import java.util.ArrayList;
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



    // method 1 : storing all the nodes value in hashmap and also storing every leaf nodes which takes o(n) space and o(n) time.

    public static void storing_values(Node root, HashSet<Integer> set ) {
        if(root == null) return ;

        storing_values(root.left, set);

        set.add(root.data) ; // storing every value in the hashset.

        storing_values(root.right, set);

    }


    static List<Integer> list = new ArrayList<>() ; /// this will store all the leaf nodes.


    public static void check_bst_have_deadEnds(Node root ) {
        if(root == null){
            return ;
        }

        check_bst_have_deadEnds(root.left);

        if(root.left == null && root.right == null){
            list.add(root.data) ; /// storing leaf nodes to the list.
        }

        check_bst_have_deadEnds(root.right);
    }


    // method 2 :

    // time is : o(n) and space is o(1).
    public static boolean checking_dead_end(Node root, int start , int end) {
        if(root == null) return false ;

        if(start == end) return true ; // when range is same then it means we can't insert data from current node.

      
        // when we move left side then, left range will be start and right end will be root.data -1 becuase left side has root - 1 range.
        // when we move right side then , right range will be root + 1 data to infinity.
        // when either of left or right is true then return true. otherwise false.
        return  checking_dead_end(root.left, start , root.data - 1) ||  checking_dead_end(root.right,root.data + 1 , end);
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
        
        // now checking if any element of the leaf node has leaf -1 and leaf + 1 value in whole tree , if it has then we have dead end in the tree.
        for( int i : list){
            if(set.contains(i-1) && set.contains(i+1) ){
                System.out.println(true);
                break ;
            }
        }
                System.out.println(false);
    }
    
}

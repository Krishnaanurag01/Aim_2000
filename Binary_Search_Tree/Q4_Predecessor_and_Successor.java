package Binary_Search_Tree;

import java.util.ArrayList;
import java.util.Stack;



public class Q4_Predecessor_and_Successor {
    Node root;

    /**
     * Node
     */
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


    public static ArrayList<Node> getInorder(Node root) {


        ArrayList<Node> list = new ArrayList<>() ;
        if(root == null){
            return list ;
        }

        Stack<Node> stack = new Stack<>() ;
        Node dummy = root ;

        while (!stack.empty() || dummy != null) {
            if(dummy != null){
                stack.push(dummy) ;
                dummy = dummy.left ;
            }
            else{
                Node temp = stack.pop() ;
                list.add(temp) ;
                dummy = temp.right ;

            }
        }

        return list ;
    }


    // taking o(n) time and space.

    public static void get_prede_successor(Node root, int key ) {

        ArrayList<Node> list = new ArrayList<>() ;

        list = getInorder(root) ;

        Node pre = null ;
        Node suc = null ;

        for (int i = 0; i < list.size() ; i++) {
            if(list.get(i).data >= key){
                if( i > 1 ){
                    pre = list.get(i-1) ;
                }
                else{
                    pre = new Node(-1) ;
                }

                if(i < list.size() - 1){
                    suc = list.get(i+1) ;
                }
                else{
                    suc = new Node(-1) ;
                }

            }
        }

        System.out.println(pre.data);
        System.out.println(suc.data);
        
    }


    // method -2 giving error.


    // public static void get_pre_suc(Node root , int key) {
    //     if(root == null) return ;

    //     Node predecessor = null ;
    //     Node successor = null ;

    //     if(root.data == key){
    //         if(root.left != null) predecessor = findPrec(root) ;
    //         if(root.right != null) successor = findSucc(root) ;

    //         return ;
    //     }

    //     if(root.data > key){
    //         successor = root ;
    //         get_pre_suc(root.left, key);
    //     }
    //     else{
    //         predecessor = root ;
    //         get_pre_suc(root.right, key);
    //     }

    //     System.out.println(predecessor.data);
    //     System.out.println(successor.data);

    // }


    // private static Node findSucc(Node root2) {
    //     Node p   = root2.left ;

    //     while (p.right != null) {
    //         p = p.right ;
    //     }
    //     return p;
    // }

    // private static Node findPrec(Node root2) {

    //     Node q = root2 .right ;

    //     while (q.left != null) {
    //         q = q.left ;
    //     }
    //     return q ;
    // }

    public static void main(String[] args) {

        Q4_Predecessor_and_Successor tree = new Q4_Predecessor_and_Successor() ;

        tree.insert_node(50);
        tree.insert_node(30);
        tree.insert_node(20);
        tree.insert_node(40);
        tree.insert_node(70);
        tree.insert_node(60);
        tree.insert_node(80);

    //    get_prede_successor(tree.root,20);

    // get_pre_suc(tree.root, 40);
        
    }
    
}

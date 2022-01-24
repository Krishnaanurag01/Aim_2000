package Binary_Tree;
// import java.util.*;


public class Q23_Binary_Tree_to_DLL {

    // private static TreeNode root ;

    static class Node {

        int data ; 
        Node left ;
        Node right ;

        public Node(int d) {
            data = d ;
        }
        
    }


    //   same as BST Q11 

    public static Node convert_BST_To_DLL(Node root) {

        if(root == null){
            return root ;
        }

        Node dummy = new Node(-1) ;
        prev = dummy ;

        convert_BST_To_DLL_(root);

        Node head = dummy.right ;

        dummy.right = head.left = null ;  


        // do this when want to return circular ll .

        // head.left = prev ;
        // prev.right = head ;

        return head ;
    }

    static Node prev  ;

    public static void convert_BST_To_DLL_(Node root) {
        if(root == null) return ;
         
        // doing inorder traversal : it will give sorted ll.

        convert_BST_To_DLL_(root.left) ;

        root.left = prev ;
        prev.right = root ;
        prev = root ;


        convert_BST_To_DLL_(root.right);
    }















    public static void main(String[] args) {
        
    }
    
}

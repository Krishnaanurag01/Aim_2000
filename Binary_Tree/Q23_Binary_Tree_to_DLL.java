package Binary_Tree;
// import java.util.*;


public class Q23_Binary_Tree_to_DLL {

    // private static TreeNode root ;

    static class TreeNode {

        int data ; 
        TreeNode left ;
        TreeNode right ;

        public TreeNode(int d) {
            data = d ;
        }
    }




    // public static Node bt_to_dll(Node node) {
    //     if(node == null) return null ;

    //     Node head = null ;
    //     Node prev = null ;
    //     int[] flag = {0};

    //     inorder(node,head,prev,flag);
    //     return head;
    // }


    // private static void inorder(Node node, Node head, Node prev, int[] flag) {

    //     if(node == null ) return ;

    //     inorder(node.left,head,prev,flag);

    //     if(flag[0] == 0){
    //         head = node ;
    //         prev = node ;
    //     }
    //     else{
    //         prev.right = node ;
    //         prev.right.left = prev ;
    //         prev = node ;
    //     }


    //     inorder(node.right,head,prev,flag);
    // }


    static TreeNode head ; 
    static TreeNode prev = null;

    public static void binaryTree_to_dll(TreeNode node) {
        if(node == null){
            return ;
        }

        binaryTree_to_dll(node.left);

        if(prev == null){
            head = node ;
            prev = node ;
        }
        else{
            node.left = prev ;
            prev.right = node ;
            prev = prev.right;
        }
    }
















    public static void main(String[] args) {
        
    }
    
}

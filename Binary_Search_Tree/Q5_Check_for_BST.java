package Binary_Search_Tree;

public class Q5_Check_for_BST {

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





    // method 01 :

    public static class BSTpair{
        boolean isBst ; // this will tell our current node is bst or not.
        int min ; // it will store the min value. 
        int max ; // it will store the max value. 
    }



    public static BSTpair isBST(Node root) {
        if(root == null){ // when reached the null return bstpair .
            BSTpair pair = new BSTpair() ;
            pair.isBst = true ; // null node is also bst.
            pair.min = Integer.MAX_VALUE ; // this is identity.
            pair.max = Integer.MIN_VALUE ;
            return pair ;
        }

        BSTpair left_pair = isBST(root.left);  // doing post order.
        BSTpair right_pair = isBST(root.right) ;

        BSTpair mp = new BSTpair() ;  /// now create a pair for current node.
        mp.isBst = left_pair.isBst && right_pair.isBst && root.data >= left_pair.max && root.data <=  right_pair.min ; // it will store true if its left and right is also bst and root value is greater than left max and lower than rights min.

        mp.min = Math.min(root.data, Math.min(left_pair.min , right_pair.min)); // it will store the min 
        mp.max = Math.max(root.data, Math.max(left_pair.max , right_pair.max)); // store the max.
        

        return mp ;
  
        
    }



    public static void main(String[] args) {

        Q5_Check_for_BST tree = new Q5_Check_for_BST() ;

        tree.insert_node(50);
        tree.insert_node(30);
        tree.insert_node(20);
        tree.insert_node(40);
        tree.insert_node(70);
        tree.insert_node(60);
        tree.insert_node(80);

    //   int[] f = new int[1] ;
    //   f[0] = 1 ;

    //   Node prev = null ;
    //   check_if_bst(tree.root, prev, f);

    System.out.println( isBST(tree.root).isBst) ;

    //   System.out.println(f[0]);
        
    }


   
    
}

 // easiest sol : just check the inorder of tree , if it is sorted then it is a bst else not a bst
class Solution
{

    public static class Node {

        int data;
        Node left, right;

        public Node(int d) {
            this.data = d;
        }

    }
    

    // method 02 :
      
   // just check the inorder traversal. as inorder traversal is always sorted if not then not a nst.
    boolean isBST(Node root){
        prev = null ;
        isBST_ = true ;
        helper(root) ;
        
        return isBST_ ;
    }
    
    static boolean isBST_ ;
    static Integer prev ;
  
    public void helper(Node node ){
        if(node == null){
            return ;
        }
        
        helper(node.left) ;
        
        if(prev == null){
            prev = node.data ;
        }
        else{
            if(prev >= node.data){
                isBST_ = false ;
                return ;
            }
            else{
                prev = node.data ;
            }
        }
        
        helper(node.right) ;
    }


    // method 03 : using Inorder morris traversal. time will be same and space comp is not O(1)
    // check the next Q5.
}

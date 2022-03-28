package Binary_Tree;
import java.util.*;


public class Q29_Leaf_at_same_level {

    private static TreeNode root ;

    static class TreeNode {

        int data ; 
        TreeNode left ;
        TreeNode right ;

        public TreeNode(int d) {
            data = d ;
        }
    }

    // method 01 : giving error

    // static int ans =  1 ;
    // static int leafHeight = -1 ;

    // public static void check_leaf_level(TreeNode node , int height ,int[] arr) {
    //     if(node == null){
    //         return ;
    //     }

    //     if(ans == 0) return ;

    //     if(node.left == null && node.right == null){
    //         if(arr[0] == -1 ){
    //             arr[0] = height ;
    //         }
    //         else{
    //             if(arr[0] != height){
    //                 ans = 0 ;
    //             }
    //         }
    //     }

    //     check_leaf_level(node.left, height+1,arr);
    //     check_leaf_level(node.right, height+1,arr);
        
    // }


    // method 02 : working!

    public static boolean check_leaf(TreeNode node , int height , int[] arr){

        if(node == null) return true ;

        if(node.left == null && node.right == null){
            if(arr[0] == -1){
                arr[0] = height ;
            }
            
            return arr[0] == height ;
        }

      return check_leaf(node.left, height+1, arr) && check_leaf(node.right, height+1, arr); // if any return false then return false.
    }


    /// method 3 : and the best one.

    boolean check(TreeNode root)
    {
        
        HashSet<Integer> set = new HashSet<>() ; // this will contain all the height of leaf nodes, if all leaf node have same height then this set will contain only one value. else it has more than 1 value
        
        // sending the set and 0(height) initally
        helper(root,set, 0) ;
        
        return set.size() == 1 ; // checking if set has only one height
    
    }
    
    void helper(TreeNode root, HashSet<Integer> set, int h){
        
        if(root == null)
        return ;
        
        if(root.left == null && root.right == null){
            /// adding leaf height
            set.add(h) ;
            return ;
        }
        
        // sending to child with height + 1
        helper(root.left,  set, h+1) ;
        helper(root.right, set, h+1) ;
        
    }


    public static void main(String[] args) {

        root = new TreeNode(20);
        root.left = new TreeNode(8);
        root.right = new TreeNode(22);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(3);
        root.left.right.right = new TreeNode(14);
        root.left.right.left = new TreeNode(10);
        root.right.right = new TreeNode(25);

        System.out.println(check_leaf(root,0,new int[]{-1}));
        
    }
    
}

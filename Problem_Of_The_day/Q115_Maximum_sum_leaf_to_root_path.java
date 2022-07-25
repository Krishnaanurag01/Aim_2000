package Problem_Of_The_day;

public class Q115_Maximum_sum_leaf_to_root_path {

    class Node{
        int data ;
        Node left, right ;
    }
    
    public static int maxPathSum(Node root)
    {
        return helper(root) ;
    }
    
    static int helper(Node root){
        if(root == null) return  0 ;
        if(root.left == null && root.right == null) return root.data ;
        
        int left = helper(root.left) ;
        int right = helper(root.right) ;
        
        
        return Math.max(left,right) + root.data ;
    }
}

package Binary_Tree;

public class Q70_Path_Sum {

    class TreeNode{
        int val ;
        TreeNode left, right ;
    }

    static boolean isTrue ;
    public boolean hasPathSum(TreeNode root, int targetSum) {
        
        isTrue = false ;
        
        helper(root , targetSum ) ;
        
        return isTrue ;
    }
    
    
    void helper(TreeNode root , int target){
        
        if(root == null)
            return  ;
       
        target = target - root.val ;
        if( root.left == null && root.right == null && target == 0)
            isTrue = true ;
        
        helper(root.left , target ) ;
        helper(root.right, target ) ;
        
        return  ;
        
    }
    
}

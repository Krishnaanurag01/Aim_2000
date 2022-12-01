package Binary_Tree;

public class Q88_Distribute_Coins_in_Binary_Tree {

    class TreeNode{
        int val ;
        TreeNode left,right ;
    }

    public int distributeCoins(TreeNode root) {
        int[] steps = new int[1] ;
        helper(root, steps) ;
        return steps[0] ;
    }
    
    int helper(TreeNode root, int[] steps){
        if(root == null) return  0 ;
        int left = helper(root.left, steps) ; // movement of coins from left
        int right = helper(root.right, steps) ; // from right. 
        steps[0] += Math.abs(left) + Math.abs(right) ;
        
        return (left + right + root.val - 1) ; // storing 1 coin for current and root and returning rest.
    }
}

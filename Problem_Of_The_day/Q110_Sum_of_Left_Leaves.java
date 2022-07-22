package Problem_Of_The_day;

public class Q110_Sum_of_Left_Leaves {

    class TreeNode{
        int val ;
        TreeNode left, right ;
    }

    public int sumOfLeftLeaves(TreeNode root) {
        return helper(root,0) ;
    }
    
    int helper(TreeNode root, int id){
        if(root == null) return 0 ;
        if(root.left == null && root.right == null && id == -1) return root.val ;
        int left = helper(root.left,-1) ; // sending left with id -1
        int right = helper(root.right,1) ; // right with id +1
         
        return left + right;
    }
}

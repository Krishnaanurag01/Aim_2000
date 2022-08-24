package Problem_Of_The_day;

public class Q182_Path_Sum_III {

    public int pathSum(TreeNode root, int targetSum) {
       
        return path_with_k_sum(root,targetSum);
    }
    
     public int path_with_k_sum(TreeNode node, long sum) {
         if(node  == null) return 0 ;
         
         int count = 0 ;
         count += helper(node.left, sum - node.val) + helper(node.right, sum - node.val) ; // if path start from current node then check rest of the sum in left or right side
         count += path_with_k_sum(node.left, sum) + path_with_k_sum(node.right, sum) ; // else path may also be available from child nodes
         if(node.val == sum) count++ ;
         return count ;
    }
    
    int helper(TreeNode node, long sum){
        if(node == null) return 0 ;
        
        int count = 0 ;
        if(node.val == sum) count++  ;
        
        count += helper(node.left, sum - node.val) ;
        count += helper(node.right, sum - node.val) ;
        return count ;
    }



    class TreeNode{
        int val ;
        TreeNode left, right ;
    }
}

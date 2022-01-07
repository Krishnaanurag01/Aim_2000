package Binary_Tree;
import java.util.*;

public class Q45_Maximum_Level_Sum_of_a_Binary_Tree {

    
    public class TreeNode {
        int val ;
        TreeNode left ;
        TreeNode right ;
    }

    public int maxLevelSum(TreeNode root) {
        
        int ans = 0 ;
        int level = 1 ;
        
        LinkedList<TreeNode> q = new LinkedList<>() ;
        q.add(root) ;
        int max_sum = Integer.MIN_VALUE ; // taking the max_sum -infinity by default.
        
        while(q.size() != 0 ){
            int size = q.size() ;
            int sum = 0 ; // now initializing the sum for each level 
            
            while(size-- > 0 ){
                TreeNode rn = q.removeFirst() ;
                sum += rn.val ; // calculating the sum by adding all nodes value in sum
                if(rn.left != null) q.addLast(rn.left) ;
                if(rn.right != null) q.addLast(rn.right) ;
            }
            
            if(max_sum < sum){ // checking if max_sum is less than our current sum then update both the max_sum and ans.
                max_sum = sum ;
                ans = level ;
            }
            
            level++ ;
            
        }
        
        return ans ;
        
    }
    
}

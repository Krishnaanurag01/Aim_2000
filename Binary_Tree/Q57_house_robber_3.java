package Binary_Tree;
import java.util.*;

public class Q57_house_robber_3 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {}

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }


    static HashMap<TreeNode,Integer> map ; // using map for memoization.
    public int rob(TreeNode root) {
        
        map = new HashMap<>() ;
       return robHelper(root) ;
    }
    
    
    public int robHelper(TreeNode root) {
        
        if(root == null){
            return  0 ;
        }
        
        if(map.containsKey(root)){ // checking we have already solved the problem
            return map.get(root) ;
        }

                    // robbing current house + grand child houses
        int profitINC = root.val + ( root.left != null ? robHelper(root.left.left) : 0 ) + (root.left != null ? robHelper(root.left.right) : 0 ) +   ( root.right != null ? robHelper(root.right.left) : 0 ) + (root.right != null ? robHelper(root.right.right) : 0 ) ;
        
        
        // if not robbing current house.then rob child houses
        int profitEXC = 0 + ( robHelper(root.left) ) + ( robHelper(root.right) ) ;
        
        int maxProfit = profitINC > profitEXC ? profitINC : profitEXC ;
        map.put(root,maxProfit) ; // storing for optimization
        
        return maxProfit ;
        
    }
    
}

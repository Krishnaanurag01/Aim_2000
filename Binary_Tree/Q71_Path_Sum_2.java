package Binary_Tree;
import java.util.*;

public class Q71_Path_Sum_2 {

    class TreeNode{
        int val ;
        TreeNode left, right ;
    }


    List<List<Integer>> ans ;
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        ans = new ArrayList<>() ;
        
        helper(root,targetSum,new ArrayList<>());
        
        return ans ;
    }
    
    void helper(TreeNode root ,  int target, List<Integer> pans){
        if(root == null ) return ;
        
        if( (target-root.val) == 0 && root.left == null && root.right == null){
            
            pans.add(root.val) ;
            ans.add( new ArrayList<>(pans) ) ;
            pans.remove(pans.size() - 1) ;

            return  ;
        }
        
        pans.add(root.val) ;
        helper(root.left, target - root.val, pans) ;
                    

        helper(root.right, target - root.val, pans) ;
        pans.remove(pans.size() - 1) ;
        
        return ;
    }

    
}

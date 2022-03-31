package Binary_Tree;
import java.util.*;

public class Q75_All_Possible_Full_Binary_Trees {

    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;
    
        TreeNode(int val) {
          this.val = val;
        }
      }
    

    public List<TreeNode> allPossibleFBT(int n) {
        return helper(n) ;
    }
    
    List<TreeNode> helper(int n){
        if(n == 1){ // base case smallest fully binary tree.
            ArrayList<TreeNode> base = new ArrayList<>() ;
            base.add(new TreeNode(0)) ;
            return base ;
        }
        
        List<TreeNode> ans = new ArrayList<>() ;
        
        for(int i = 1 ; i < n ; i+=2){ /// running fow +1 gap becuase for a full binary tree the count of all node is odd and left and right subtree should also have odd count of nodes.
            List<TreeNode> left = helper(i) ;
            List<TreeNode> right = helper(n-i-1) ;
            
            for(TreeNode l : left){
                for(TreeNode r : right){
                    TreeNode root = new TreeNode(0) ;
                    root.left = l ;
                    root.right = r ;
                    ans.add(root) ;
                }
            }
        }
        
        return ans ;
    }
    
}

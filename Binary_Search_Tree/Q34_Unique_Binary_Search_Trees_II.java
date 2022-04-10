package Binary_Search_Tree;
import java.util.*;

public class Q34_Unique_Binary_Search_Trees_II {

    class TreeNode{
        int val ;
        TreeNode left,right ;

        TreeNode(int val) { this.val = val;  }
    }


    public List<TreeNode> generateTrees(int n) {
        return helper(1,n) ; // sending starting and ending point.
    }
    
    public List<TreeNode> helper(int sp, int ep){
        if( sp > ep ){ // base condition when start point is greater than end point then return null in a list.
            List<TreeNode> list = new ArrayList<>() ;
            list.add(null) ;
            return list ;
        }
        
        List<TreeNode> ans = new ArrayList<>() ;
        
        for(int i = sp ; i <= ep ; i++){
            
            List<TreeNode> left_list = helper(sp , i-1) ; // getting the left subtree.
            List<TreeNode> right_list = helper(i+1 , ep) ; // getting the right subtree
            
            for(TreeNode left : left_list){
                for(TreeNode right : right_list){
                    TreeNode root = new TreeNode(i) ; ///creating root node everytime, means creating unique tree 
                    root.left = left ; // assing left and right
                    root.right = right ;
                    ans.add(root) ; // adding to answer.
                }
            }
        }
        return ans ;        
    }
    
}

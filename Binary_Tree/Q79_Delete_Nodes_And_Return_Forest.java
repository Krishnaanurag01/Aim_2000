package Binary_Tree;
import java.util.*;

public class Q79_Delete_Nodes_And_Return_Forest {

    class TreeNode{
        int val ;
        TreeNode left, right ;
    }

    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        
        HashSet<Integer> set = new HashSet<>() ; // adding to set for faster serching.
        for(int i : to_delete){
            set.add(i) ;
        }
        
        ArrayList<TreeNode> ans = new ArrayList<>() ; // answer list
        helper(root,set,ans) ;
        if(!set.contains(root.val)) ans.add(root) ; // if root is not to be delete then addto answer.
        return ans ;
    }
    
    TreeNode helper(TreeNode root, HashSet<Integer> set, ArrayList<TreeNode> ans ){
        
        if(root == null) return root ;
        root.left = helper(root.left,set,ans) ; // if left or right side return null then update the left and right
        root.right = helper(root.right,set,ans) ;
        
        if(set.contains(root.val)){ // if root is to be deleted
            if(root.left != null) ans.add(root.left) ; // then add it's non null childs.
            if(root.right != null) ans.add(root.right) ;
            return null ; // and making current node null.
        }
        
        return root ;
    }
    
}

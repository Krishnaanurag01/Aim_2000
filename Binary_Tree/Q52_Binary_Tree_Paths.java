package Binary_Tree;
import java.util.* ;

public class Q52_Binary_Tree_Paths {

     public class TreeNode {
             int val;
             TreeNode left;
             TreeNode right;
             TreeNode() {}
             TreeNode(int val) { this.val = val; }
             TreeNode(int val, TreeNode left, TreeNode right) {
                 this.val = val;
                 this.left = left;
                 this.right = right;
             }
         }


    public List<String> binaryTreePaths(TreeNode root) {
        List<String> list = new ArrayList<>() ;
        helper(root,list,""+root.val) ; // adding root val initially
        
        return list ;
    }
    
    public void helper(TreeNode root, List<String> list, String asf){
        
        if(root == null)
            return ;
        
        if(root.left == null && root.right == null){ // when reached leaf add it to the anser list
            list.add(asf) ;
            return ;
        }
        
        if(root.left != null) // going to left and also including the left child and same for right
        helper(root.left,list, asf+"->"+root.left.val) ;
        
        
        if(root.right != null)
        helper(root.right,list, asf+"->"+root.right.val) ;
        
        
    }

}
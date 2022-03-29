package Binary_Tree;
import java.util.*;

public class Q65_Node_To_Root_Path_Binary_Tree {

    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;
    
        TreeNode(int val) {
          this.val = val;
        }
      }
    
      public static ArrayList<TreeNode> nodeToRootPath(TreeNode node, int data) {
        // write your code here
        if(node == null) return new ArrayList<TreeNode>(); // returning empty list if did not found anything
    
        if(node.val == data){ // else if  found our node node then add to list and return
          ArrayList<TreeNode> ans = new ArrayList<TreeNode>();
          ans.add(node) ;
          return ans ;
        }
    
        ArrayList<TreeNode> left = nodeToRootPath(node.left,data) ;
        
        // if left answer has our answer then add current node and return
        if(left.size() > 0 ){
          left.add(node) ;
          return left ;
        }
    
        // if right answer has our answer then add current node and return
        ArrayList<TreeNode> right =  nodeToRootPath(node.right,data);
    
        if(right.size() > 0 ){
          right.add(node) ;
          return right ;
        }
    
    
        // else return empty
        return new ArrayList<TreeNode>(); 
    
      }
    
}

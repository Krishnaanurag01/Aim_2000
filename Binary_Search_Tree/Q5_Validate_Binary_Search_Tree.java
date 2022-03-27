package Binary_Search_Tree;

public class Q5_Validate_Binary_Search_Tree {

    public static class TreeNode {

        int val;
        TreeNode left, right;

        public TreeNode(int d) {
            this.val = d;
        }

    }
    
    // method 03 : using Inorder morris traversal. time will be same and space comp is not O(1)
    // check morris traveral in binary tree package for explanation.

    public boolean isValidBST(TreeNode root) {
        
        Integer prev = null ;
        
        TreeNode curr = root ;
        
        while(curr != null ){
            TreeNode left = curr.left ;
            
            if(left == null){
                
                if(prev == null){
                    prev = curr.val ;
                }
                else if(curr.val <= prev ){
                    return false;
                }
                else{
                    prev = curr.val ;
                }
                curr = curr.right ;
            }
            else{
                TreeNode rightMostNode = getRightMostNode(left,curr);
                
                if(rightMostNode.right == null){
                    rightMostNode.right = curr ;
                    curr = curr.left ;
                }
                else{
                    rightMostNode.right = null ;
                    
                    
                   if(prev == null){
                    prev = curr.val ;
                }
                else if(curr.val <= prev ){
                       return false;
                      }
                    else{
                       prev = curr.val ;
                      }
                    
                    curr = curr.right ;
                }
            }
        }
        
        return true ;
    }
    
    public TreeNode getRightMostNode(TreeNode node, TreeNode curr){
        
        while(node.right != null && node.right != curr){
            node = node.right ;
        }
        
        return node ;
    }
}

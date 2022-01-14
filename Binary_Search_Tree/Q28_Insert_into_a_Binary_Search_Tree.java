package Binary_Search_Tree;



public class Q28_Insert_into_a_Binary_Search_Tree {

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


    public TreeNode insertIntoBST(TreeNode root, int val) {
        if(root == null){ // once reach null return new node.
          return new TreeNode(val)  ;  
        } 
        
        if(root.val > val ){ // check if root val is greater then proceed to left
           root.left = insertIntoBST(root.left,val) ;
        }
        else{ // else go to right
           root.right = insertIntoBST(root.right,val) ;
        }
        
        
        return root ;
    }
    
}

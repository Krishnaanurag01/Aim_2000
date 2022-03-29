package Binary_Tree;

public class Q66_Count_All_Single_Child_Parent_In_Binary_Tree {

    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;
    
        TreeNode(int val) {
          this.val = val;
        }
      }
    
      public static int countExactlyOneChild(TreeNode node) {
    
        int[] count = {0};
        helper(node,count) ;
        return count[0] ;
         
      }
    
      static void helper(TreeNode node,int[] count){
    
        if(node == null) return ;
    
        if( (node.left != null && node.right == null ) || (node.right != null && node.left == null) ){
          count[0]++ ;
        }
    
        helper(node.left,count) ;
        helper(node.right,count) ;
    
        return ;
      }
    
    
}

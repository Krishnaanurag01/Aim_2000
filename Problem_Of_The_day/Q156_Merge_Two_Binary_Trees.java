package Problem_Of_The_day;

public class Q156_Merge_Two_Binary_Trees {

    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        
        if(root1 == null ) return root2 ;
        if(root2 == null ) return root1 ;  
        
        return helper(root1, root2) ;
    }
    
    TreeNode helper(TreeNode r1, TreeNode r2){
        
        if(r1 == null && r2 == null) return null ;
        
        int val = (r1 != null ? r1.val : 0 ) + ( r2 != null ? r2.val : 0 ) ;
        TreeNode root = new TreeNode(val) ;
        
        root.left = helper(r1 != null ? r1.left : r1, r2 != null ? r2.left : r2);        
        root.right = helper(r1 != null ? r1.right : r1, r2 != null ? r2.right : r2);

        return root;
    }


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
}

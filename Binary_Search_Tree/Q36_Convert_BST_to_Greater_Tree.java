package Binary_Search_Tree;

public class Q36_Convert_BST_to_Greater_Tree {

    class TreeNode{
        TreeNode left, right ;
        int val ;
    }
    
    int sum = 0 ;
    public TreeNode convertBST(TreeNode root) {
        if(root == null) return root ;
        
        convertBST(root.right) ;
        sum += root.val  ;
        root.val = sum ;
        convertBST(root.left) ;

        return root ;
    }
}

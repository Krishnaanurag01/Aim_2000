package Binary_Tree;

public class Q80_Count_Good_Nodes_in_Binary_Tree {

    class TreeNode{
        int val ;
        TreeNode left,right ;
    }

    public int goodNodes(TreeNode root) {
        int[] count = {0} ;
        helper(root,root.val,count) ;
        return count[0] ;
    }
    
    void helper(TreeNode root, int msf, int[] count){
        if(root == null) return ;
        if(root.val >= msf ) count[0]++ ;
        
        helper(root.left, msf > root.val ? msf : root.val , count) ;     
        helper(root.right, msf > root.val ? msf : root.val , count) ;
    }
    
}

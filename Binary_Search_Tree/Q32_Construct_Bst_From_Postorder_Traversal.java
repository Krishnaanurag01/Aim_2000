package Binary_Search_Tree;

public class Q32_Construct_Bst_From_Postorder_Traversal {

    public static class TreeNode {
        int val = 0;
        TreeNode left , right ;
        TreeNode(int val) { this.val = val; }
    }
    
    public static TreeNode bstFromPostorder(int[] postorder) {
        return helper(postorder,0,postorder.length-1); // passing to helper with si and ei
    }

    // same as bst from preorder. only few differences

    static TreeNode helper(int[] post, int si, int ei){
        if(si > ei) return null ;

        TreeNode root = new TreeNode(post[ei]) ; // assining the last val of post order that always point to root.
        if(si == ei ) return root ;

        int flValIdx = si ; // finding the first val index that is greater than our root val
        while ( flValIdx < post.length && post[flValIdx] < root.val ) flValIdx++ ;

        root.left = helper(post,si,flValIdx-1) ; 
        root.right = helper(post,flValIdx,ei-1) ;

        return root ; 
    }
    
}

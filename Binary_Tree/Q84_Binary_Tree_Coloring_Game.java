package Binary_Tree ;

public class Q84_Binary_Tree_Coloring_Game {

    static int lc, rc ;
    public boolean btreeGameWinningMove(TreeNode root, int n, int x) {
        lc = 0 ; // left count of x
        rc = 0 ; // right count of x
        helper(root,x) ;
        int nodesTillParent = n - ( lc + rc + 1) ; // subtracting the left subtree childs + right subtree childs     + 1(for curr node) from total nodes gives the nodes present till x parent node(including) .
        int max = Math.max(lc, Math.max(rc,nodesTillParent)) ;
        return max > (n/2) ;
    }
    
    int helper(TreeNode root, int x){
        if(root == null ) return 0 ;
        
        int leftCount = helper(root.left,x) ;
        int rightCount = helper(root.right,x) ;
        
        if(root.val == x){
            lc = leftCount ;
            rc = rightCount ;
            // return lc+rc+1 ;
        }
        
        return leftCount + rightCount + 1 ;
    }
}
package Binary_Tree;

public class Q6_Symmetrical_tree {
    
    private TreeNode root ;

    static class TreeNode {

        int data ; 
        TreeNode left ;
        TreeNode right ;

        public TreeNode(int d) {
            data = d ;
        }
    }

    public static boolean isSymmetric(TreeNode root) {
        if(root == null){
            return true;
        }
        
        return isSymmetric(root.left,root.right);
    }
    
    private static boolean isSymmetric(TreeNode left , TreeNode right){
        if( left == null || right == null){
            return left == right ;
        }
        
        if( left.data != right.data){
            return false;
        }
        
        return isSymmetric(left.right , right.left) && isSymmetric(left.left , right.right) ;
    }










    public static void main(String[] args) {

        Q6_Symmetrical_tree bt = new Q6_Symmetrical_tree() ; 

        bt.root = new TreeNode(2);
        bt.root.left = new TreeNode(3);
        bt.root.right = new TreeNode(4);
        bt.root.left.left = new TreeNode(5);
        bt.root.left.right = new TreeNode(6);

        System.out.println(isSymmetric(bt.root));
        
    }
}

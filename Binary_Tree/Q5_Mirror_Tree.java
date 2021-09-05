package Binary_Tree;



public class Q5_Mirror_Tree {

    private TreeNode root ;

    static class TreeNode {

        int data ; 
        TreeNode left ;
        TreeNode right ;

        public TreeNode(int d) {
            data = d ;
        }
    }

    public static void Mirror_Tree(TreeNode node) {
        if(node == null ){
            return ;
        }
        
        TreeNode t = node.left ;
        node.left = node.right ;
        node.right = t ;

        Mirror_Tree(node.left);
        Mirror_Tree(node.right);


    }





















    public static void main(String[] args) {

        Q5_Mirror_Tree bt = new Q5_Mirror_Tree() ;

        bt.root = new TreeNode(2);
        bt.root.left = new TreeNode(3);
        bt.root.right = new TreeNode(4);
        bt.root.left.left = new TreeNode(5);
        bt.root.left.right = new TreeNode(6);

        Mirror_Tree(bt.root);

        
    }
}

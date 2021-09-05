package Binary_Tree;


public class Q3_Height_of_Binary_Tree {
    
    private TreeNode root ;

    static class TreeNode {

        int data ; 
        TreeNode left ;
        TreeNode right ;

        public TreeNode(int d) {
            data = d ;
        }
    }




    public static int height_of_bt(TreeNode node) { // height of binary tree in tearms of edges . height is also said as depth of the deepest node.
        if(node == null){
            return -1 ; // return 0 if counting heights in tearms of node.
        }

        int leftHeight = height_of_bt(node.left);
        int rightHeight = height_of_bt(node.right);

        int maxHeightFromBothSide = Math.max(leftHeight, rightHeight) + 1 ;

        return maxHeightFromBothSide ;

         
    }










    public static void main(String[] args) {
     
        Q3_Height_of_Binary_Tree bt = new Q3_Height_of_Binary_Tree();

        bt.root = new TreeNode(2);
        bt.root.left = new TreeNode(3);
        bt.root.right = new TreeNode(4);
        bt.root.left.left = new TreeNode(5);
        bt.root.left.right = new TreeNode(6);

       System.out.println( height_of_bt(bt.root) );
    }
}

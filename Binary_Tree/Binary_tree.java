package Binary_Tree;



public class Binary_tree {
    private TreeNode root ;

    static class TreeNode {

        int data ; 
        TreeNode left ;
        TreeNode right ;

        public TreeNode(int d) {
            data = d ;
        }
    }

    public static int sum(TreeNode root) {
        if(root == null){
            return  0 ;
        }

        int leftSide = sum(root.left);  // find the sum of left side.
        int rightSide = sum(root.right); // sum of right side.
        int totalSum = leftSide + rightSide + root.data ; // addding with current root data.

        return totalSum ;
    }

    public static int size(TreeNode root) {
        if(root == null){
            return 0 ;
        }

        int leftSide = size(root.left); // size of left side.
        int rightSide = size(root.right); // size of right side.

        int totalCount = leftSide + rightSide + 1 ; // adding both side size plus current element.

        return totalCount ;
    }

    public static int max(TreeNode node) {
        if(node == null){
            return Integer.MIN_VALUE ;
        }

        int leftSide = max(node.left);  // max of left size.
        int rightSide = max(node.right) ; // max of right size.

        int maxInBothSide = Math.max(node.data, Math.max(leftSide, rightSide));  /// first find the max of both side and  then add it with the current .

        return maxInBothSide ;
    }

    public static int height_of_bt(TreeNode node) { // height of binary tree in tearms of edges . height is also said as depth of the deepest node.
        if(node == null){
            return -1 ; // return 0 if counting heights in tearms of node.
        }

        int leftHeight = height_of_bt(node.left);   // same as above.
        int rightHeight = height_of_bt(node.right);

        int maxHeightFromBothSide = Math.max(leftHeight, rightHeight) + 1 ;

        return maxHeightFromBothSide ;

         
    }













    public static void main(String[] args) {

        Binary_tree bt = new Binary_tree() ;

        bt.root = new TreeNode(2);
        bt.root.left = new TreeNode(3);
        bt.root.right = new TreeNode(4);
        bt.root.left.left = new TreeNode(5);
        bt.root.left.right = new TreeNode(6);

        System.out.println(sum(bt.root));
        System.out.println(size(bt.root));
        System.out.println(max(bt.root));
        System.out.println(height_of_bt(bt.root));
        
    }
}

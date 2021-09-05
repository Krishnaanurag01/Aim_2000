package Binary_Tree;

public class Q4_Diameter_of_Binary_Tree {

    private TreeNode root ;

    static class TreeNode {

        int data ; 
        TreeNode left ;
        TreeNode right ;

        public TreeNode(int d) {
            data = d ;
        }
    }

    public static int height(TreeNode node) {
        if(node == null){
            return 0 ;
        }

        int leftSide = height(node.left);
        int rightSide = height(node.right);

        int maxHeight = Math.max(leftSide, rightSide) + 1 ;

        return maxHeight ;
    }



    // this will take o(n2) time as we are using recursive function under another recursive function.

    public static int diameter(TreeNode node) {
        if(node == null){
            return 0 ;
        }

        int leftDia = diameter(node.left);
        int rightDia = diameter(node.right);

        int bothSideDia = height(node.left) + height(node.right) + 2 ; // here using another recursive function.

        int ans = Math.max(bothSideDia, Math.max(leftDia, rightDia)); // max dia will be either in left side or right side o\w both side share the  max dia.

        return ans ;

        
    }


    // time comp is : o(n) and o(n) space
    public static int diameter2(TreeNode root , int[] max) { // here max is of 1 size as we can't send variable with reference thats why we send it within an array.
        if(root == null){
            return 0 ; 
        }

        int left_part = diameter2(root.left , max) ;  // find for left side.
        int right_part = diameter2(root.right , max) ; // for right side.

        max[0] = Math.max(max[0], left_part + right_part) ; // keep updating value when found bigger.

        return 1 + left_part + right_part ; // this calculates the height.

    }





    public static void main(String[] args) {
        
        Q4_Diameter_of_Binary_Tree bt = new Q4_Diameter_of_Binary_Tree() ;

        bt.root = new TreeNode(2);
        bt.root.left = new TreeNode(3);
        bt.root.right = new TreeNode(4);
        bt.root.left.left = new TreeNode(5);
        bt.root.left.right = new TreeNode(6);

        System.out.println(height(bt.root));
        System.out.println(diameter2(bt.root, new int[]{0}));
    }
    
}

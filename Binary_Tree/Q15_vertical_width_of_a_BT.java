package Binary_Tree;

public class Q15_vertical_width_of_a_BT {

    private static TreeNode root ;

    static class TreeNode {

        int data ; 
        TreeNode left ;
        TreeNode right ;

        public TreeNode(int d) {
            data = d ;
        }
    }

    // time : o(n) and space is : o(height of the tree)

    public static int getVerticalWidth(TreeNode root) {
        if(root == null){
            return 0 ;
        }

        int[] minAndMaxLevel = new int[2]; // this array will store the height of left most node at 0th index  and right  most node in 1st index.

        width(root,0,minAndMaxLevel);// start recursion.

        return minAndMaxLevel[1] - minAndMaxLevel[0] + 1 ; // formula : end - start + 1 == width .
    }






    private static void width(TreeNode root, int level, int[] arr) {

        if(root == null){
            return ;
        }

        arr[0] = Math.min(arr[0],level); // keep updating the min height if found lower
        arr[1] = Math.max(arr[1],level); // keep updating the max height if found higher.

        width(root.left, level-1 , arr); // now traverse left with current level - 1 ;
        width(root.right, level+1 , arr); // and level + 1 traverse in right side.

    }






    public static void main(String[] args) {

        root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(6);
        root.right.left.left = new TreeNode(7);
        root.right.left.right = new TreeNode(8);

        System.out.println(getVerticalWidth(root));
        
    }
    
}

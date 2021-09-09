package Binary_Tree;


public class Q24_Transform_to_Sum_Tree {

    private static TreeNode root ;

    static class TreeNode {

        int data ; 
        TreeNode left ;
        TreeNode right ;

        public TreeNode(int d) {
            data = d ;
        }
    }


  

    public static int sumTree(TreeNode node) {
        if(node == null) return 0 ;



        int left_part  = sumTree(node.left);
        int right_part = sumTree(node.right);
        int root_data_backup = node.data ;

        node.data = left_part+right_part ;

        return left_part+right_part+root_data_backup ;


    }










    public static void main(String[] args) {
        root = new TreeNode(20);
        root.left = new TreeNode(8);
        root.right = new TreeNode(22);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(3);
        root.left.right.right = new TreeNode(14);
        root.left.right.left = new TreeNode(10);
        root.right.right = new TreeNode(25);


        System.out.println(sumTree(root));
        
    }
    
}

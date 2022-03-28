package Binary_Tree;

public class Q19_Check_for_Balanced_Tree {

    private static TreeNode root ;

    static class TreeNode {

        int data ; 
        TreeNode left ;
        TreeNode right ;

        public TreeNode(int d) {
            data = d ;
        }
    }
    


    // time and space is o(n).


    public static int isBalanced(TreeNode root) {
        if(root == null) return 0  ;

        int left = isBalanced(root.left) ; // move to left. if it has -1 then we have not balanced root in tree so simply return it.
        if(left == -1) return -1;
        int right = isBalanced(root.right) ; // same above.
        if(right == -1) return -1;


        if(Math.abs(left-right) > 1) return -1 ; // checking if not balanced.

        return Math.max(left, right) + 1 ; // returning height.

    }

    //  Method 02 : 

    boolean isB = true ;

    static boolean isBalancedd ;
    
    boolean isBalanced2(TreeNode root)
    {
       isBalancedd = true ;
       
       helper(root) ;
       
       return isBalancedd ;
        
    }
    
    int helper(TreeNode root){
        
        if(root == null){
            return  0 ;
        }
        
        int left = helper(root.left) ;
        int right = helper(root.right) ;
        
        if(Math.abs( left - right ) > 1){
            isBalancedd = false ;
            return Integer.MIN_VALUE ;
        }
        
        return 1 + Math.max(left,right) ;
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


        System.out.println(isBalanced(root) != 1);
    }
    
}

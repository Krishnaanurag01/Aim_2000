package Binary_Tree;


public class Q28_Sum_Tree {

    private static TreeNode root ;

    static class TreeNode {

        int data ; 
        TreeNode left ;
        TreeNode right ;

        public TreeNode(int d) {
            data = d ;
        }
    }



    // method 1 : but code not accepting.

    public static boolean get_sum_tree(TreeNode root) {
        if(root == null) return true ;

        sumtree(root);
        return isSum ;
    }


   static boolean isSum = true ;

    private static int sumtree(TreeNode root2) {
        if(root2 == null){
            return 0;
        }
        if(root2.left == null && root2.right == null){
            return root2.data ;
        }

        if(isSum == false) return 0 ;

        int left = sumtree(root2.left);
        int right = sumtree(root2.right);

        int ns = left + right ;

        if(root2.data != ns && root2.left != null && root2.right != null ){
            isSum = false ;
        }


        return root2.data + ns ;
    }




// method 2 : 

public static boolean isleaf(TreeNode node) {
    if(node == null){
        return false;
    }
    if(node.left == null && node.right == null){
        return true;
    }
    return false;
}

public static boolean isSumTree(TreeNode root) {
    if(root == null || isleaf(root)){ // if we encounter the leaf node or null node then return  true becuase they are sum tree part by default.
        return true ;
    }

    int ls , rs ; // left sun and right sum

    if(isSumTree(root.left) == true && isSumTree(root.right) == true ){ // if we ever have a false then it will not run .
        if(root.left == null){ // checking if it doesn't exist. then left sum is 0 
            ls = 0 ;
        }
        else if(isleaf(root.left)==true){ // if leaf node then take the data
            ls = root.left.data ;
        }
        else{ // else , here we multiply data with 2 means : the root node is always a sum of its children and we have to pass the root node (eg : 50 (left -> 30 + right -> 20)) and its children sum : left(30) + right (20) so we can simply say its 2*root data.
            ls = 2*(root.left.data) ;
        }
        // for right side now. same as above

        if(root.right == null){
            rs = 0 ;
        }
        else if(isleaf(root.right)==true){
            rs = root.right.data ;
        }
        else{
            rs = 2*(root.right.data) ;
        }

        if(root.data == ls + rs ){ // checking the root node sum is equals to its children node.
            return true ;
        }
        else{
            return false;// if not equal then return false and then loop will not go ahead.
        }
    }


    return false;
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

        sumtree(root);
        
    }
    
}

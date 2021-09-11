package Binary_Tree;

public class Q31_Check_if_2_trees_are_mirror_or_not {

    static class TreeNode {

        int data;
        TreeNode left;
        TreeNode right;

        public TreeNode(int d) {
            data = d;
        }
    }


    // time is : o(n)
    // space is : o(1) and if stack frame is countable then o(height of tree.)

    public static boolean is_mirror_BT(TreeNode tree1 , TreeNode tree2) {
        if(tree1 == null || tree2 == null){ // when any of it is  null then check if second tree is also  null or not.
            return tree1 == tree2 ;
        }

        if(tree1.data != tree2.data ){ /// if data are different then return false.
            return false ;
        }


        // for mirror : check 1st tree left with 2nd tree right and 1st tree right with 2nd tree left.
        // imagine you're folding two trees then which node cover whom. 
        return is_mirror_BT(tree1.left, tree2.right) && is_mirror_BT(tree1.right, tree2.left) ;
    }













    public static void main(String[] args) {

        TreeNode a = new TreeNode(1);
        TreeNode b = new TreeNode(1);
        a.left = new TreeNode(2);
        a.right = new TreeNode(3);
        a.left.left = new TreeNode(4);
        a.left.right = new TreeNode(5);
 
        b.left = new TreeNode(3);
        b.right = new TreeNode(2);
        b.right.left = new TreeNode(5);
        b.right.right = new TreeNode(4);
        


        System.out.println(is_mirror_BT(a,b));
    }
    
}

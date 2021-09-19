package Binary_Search_Tree;

public class Q27_Flatten_BST_to_sorted_list {
    
    
    TreeNode root;

    public static class TreeNode {

        int data;
        TreeNode left, right;
        public TreeNode(int d) {
            this.data = d;
        }

    }

    
    public void insert_node(int data) {
        root = insert_node(root, data);
    }

    public static TreeNode insert_node(TreeNode root, int data) {
        if (root == null) {
            root = new TreeNode(data);
            return root;
        }

        if (root.data > data) {
            root.left = insert_node(root.left, data);
        } else {
            root.right = insert_node(root.right, data);
        }

        return root;
    }


    // method : 01
    // time and space is : o(n) 

    static TreeNode prev = null ;

    public static void flattening_bst_to_list(TreeNode root) {
        if(root == null ) return ;

        flattening_bst_to_list(root.right);
        flattening_bst_to_list(root.left);

       root.right = prev;
        root.left = null;
        prev = root ;


    }


    // method : 03 
    // time : o(n) and space is o(1).

    public static void bst_to_list_constant_space(TreeNode root) {
        TreeNode current = root ;

        while (current != null) {
            
            if(current.left != null){

                TreeNode right_max = current.left ;

                while (right_max.right != null) {
                    right_max = right_max.right ;
                }

                right_max.right = current.right ;
                current.right = current.left ;
                current.left = null ;
            }

            current = current.right ;
        }
    }






    public static void main(String[] args) {
        
    }
}

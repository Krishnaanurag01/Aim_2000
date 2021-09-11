package Binary_Tree;


public class Q36_Lowest_Common_Ancestor_in_a_Binary_Tree {

    TreeNode root ;
    
    static class TreeNode {

        int data;
        TreeNode left;
        TreeNode right;

        public TreeNode(int d) {
            data = d;
        }
    }



    public static TreeNode get_LCA(TreeNode node , int n1 , int n2) {
        if(node == null || node.data == n1 || node.data == n2 ){ // if reached null node then return that else if reached any of n1 or n2 then return it, we can't reach both n1 and n2 at same time and tree will always be unique.
            return node ;
        }


       TreeNode left = get_LCA(node.left, n1, n2); // go for left part.
       TreeNode right = get_LCA(node.right, n1, n2); // go for right part.

       if(left == null){ // if any of right or left is null then return other part because there might be a chance that other is not null and contains the n1 or n2.
           return right;
       }
       else if(right == null){
           return left ;
       }
       else{ // when both are not null then it's sure that both are n1 and n2 and the moment both is not null then return the current node it will be the common ancestor.
           return node;
       }
       
    }












    public static void main(String[] args) {

        Q36_Lowest_Common_Ancestor_in_a_Binary_Tree tree = new Q36_Lowest_Common_Ancestor_in_a_Binary_Tree();

        tree.root = new TreeNode(1);
        tree.root.left = new TreeNode(2);
        tree.root.right = new TreeNode(3);
        tree.root.left.left = new TreeNode(4);
        tree.root.left.right = new TreeNode(5);
        tree.root.right.left = new TreeNode(6);
        tree.root.right.right = new TreeNode(7);

        System.out.println(get_LCA(tree.root, 2, 4).data);
        
    }
}

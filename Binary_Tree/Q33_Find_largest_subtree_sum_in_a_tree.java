package Binary_Tree;


public class Q33_Find_largest_subtree_sum_in_a_tree {
    private static TreeNode root;

    static class TreeNode {

        int data;
        TreeNode left;
        TreeNode right;

        public TreeNode(int d) {
            data = d;
        }
    }

    static int sum = 0;

    public static int largest_sum_subTree(TreeNode node) {

        if (node == null) {
            return 0;
        }

        int left = largest_sum_subTree(node.left); // simply so for left and right .
        int right = largest_sum_subTree(node.right);


        int total = left + right + node.data; // calculate the subtree sum and update it with the global sum variable is found larger.
        sum = Math.max(sum, total);

        return total;
    }

    public static void main(String[] args) {

        root = new TreeNode(1);
        root.left = new TreeNode(-2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(-6);
        root.right.right = new TreeNode(2);

        largest_sum_subTree(root);

        System.out.println(sum);
    }

}

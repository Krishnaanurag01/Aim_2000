package Binary_Tree;

public class Q58_Longest_ZigZag_Path_in_a_Binary_Tree {

    // Node class

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    // node class end


    class Pair { // always return -1 for null when answering it terms of edges.
        int forwardSlope = -1;
        int backwardSlope = -1;
        int maxLen = 0; // denotes max length zigzag path came so far.
    }

    public int longestZigZag(TreeNode root) {
        return helper(root).maxLen;
    }

    public Pair helper(TreeNode root) {

        if (root == null)
            return new Pair(); // return empty pair object.

        Pair left = helper(root.left);    
        Pair right = helper(root.right);
        Pair nPair = new Pair(); // new pair for current node.

        // checking if -> any maxLength zig zag path came in left or right subtree, or choosing the Max of left tree right slope + 1 ( for current edge between left child) or right tree left slope + 1 ( for currwnt edge)
        nPair.maxLen = Math.max(Math.max(left.maxLen, right.maxLen),
                Math.max(left.backwardSlope, right.forwardSlope) + 1);

                // as this pair is returning for current node parent so if parent of current node go to forward then it need current node backward and so on.
        nPair.forwardSlope = left.backwardSlope + 1; 
        nPair.backwardSlope = right.forwardSlope + 1;

        return nPair;
    }

}
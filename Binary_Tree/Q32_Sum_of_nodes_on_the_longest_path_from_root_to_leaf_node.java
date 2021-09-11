package Binary_Tree;

public class Q32_Sum_of_nodes_on_the_longest_path_from_root_to_leaf_node {

    private static TreeNode root ;

    static class TreeNode {

        int data ; 
        TreeNode left ;
        TreeNode right ;

        public TreeNode(int d) {
            data = d ;
        }
    }




    public static int[] sum_of_longest_path(TreeNode node ) {
        
        if(node == null){  // when reach the null node then return an array.
            return new int[]{0,0}; // 0th index is height and 1st index is sum .
        }


        int[] left_part = sum_of_longest_path(node.left); // go for left and right.
        int[] right_part = sum_of_longest_path(node.right);

        left_part[0] += 1; // now on returing increase the height.
        left_part[1] += node.data ; // and add current node data.
        right_part[0] +=1; // heihgt increasing of right side.
        right_part[1] += node.data ;// and add current node data.


        if(left_part[0] == right_part[0]){            // when left and right tree have same height then return the max sum array.
            return left_part[1] > right_part[1]? left_part : right_part ;
        }

        return left_part[0] > right_part[0] ? left_part : right_part ; // otherwise return the array with higher height.
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

        int[] ans = sum_of_longest_path(root);
        System.out.println(ans[0] +" "+ ans[1]);
    }
    
}

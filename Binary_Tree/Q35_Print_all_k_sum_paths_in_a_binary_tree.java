package Binary_Tree;

import java.util.ArrayList;


public class Q35_Print_all_k_sum_paths_in_a_binary_tree {

    static class TreeNode {

        int data;
        TreeNode left;
        TreeNode right;

        public TreeNode(int d) {
            data = d;
        }
    }



    public static void path_with_k_sum(TreeNode node ,ArrayList<Integer> list, int k) {
        if(node == null){
            return ;
        }

        list.add(node.data); // add the current then go to left and right.

        path_with_k_sum(node.left,list, k);
        path_with_k_sum(node.right,list, k);

        int sum = 0 ;

        for (int i = list.size()-1 ; i >= 0; i--) {
            sum += list.get(i) ;
            if(sum == k){ // when sum == k , it occurs after adding the last i index so from that i to the last index if our path.
                for (int j = i ; j < list.size() ; j++) { // so printing from i to last.
                    System.out.print(list.get(j) +" ");
                }
                System.out.println();
            }
        }

        list.remove(list.size()-1); // now remove this last added notes and start searching other side.
    }







    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(3);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(1);
        root.left.right.left = new TreeNode(1);
        root.right = new TreeNode(-1);
        root.right.left = new TreeNode(4);
        root.right.left.left = new TreeNode(1);
        root.right.left.right = new TreeNode(2);
        root.right.right = new TreeNode(5);
        root.right.right.right = new TreeNode(2);
        
        ArrayList<Integer> list = new ArrayList<>(); 

        path_with_k_sum(root, list, 5);
    }
    
}

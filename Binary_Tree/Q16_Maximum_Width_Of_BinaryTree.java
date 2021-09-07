package Binary_Tree;

import java.util.LinkedList;


public class Q16_Maximum_Width_Of_BinaryTree {

    private static TreeNode root ;

    static class TreeNode {

        int data ; 
        TreeNode left ;
        TreeNode right ;

        public TreeNode(int d) {
            data = d ;
        }
    }

    public static class Pair{
        TreeNode node ;
        int index ;

        Pair(TreeNode node , int index){
            this.node = node ;
            this.index = index ;
        }
    }

    // time and space is o(n).


    public static int get_max_width(TreeNode root) {
        if(root == null){
            return 0 ;
        }

        LinkedList<Pair> queue = new LinkedList<>() ; // for level order traversal.

        queue.addLast(new Pair(root, 0)); // add first node.
        int max_width = 0 ;

        while (queue.size() != 0) { // travesal of each level.
            int size = queue.size() ; // find the size of each traversal
            int left_max = queue.getFirst().index ; //  assign index to both left and right .
            int right_max = queue.getFirst().index ; // 

            while (size-- > 0) { // now  traverse into  your level.
                Pair rp = queue.removeFirst(); // remove first and add it left or right if present.

                right_max = Math.max(right_max, rp.index); // keep updating right side.

                if(rp.node.left != null) queue.addLast(new Pair(rp.node.left,rp.index * 2 + 1));  // 2*root_index + 1 == left child index. and 2*root_index + 2 is right child index.  we are findig width with index because we have to include the null in between left and right node.
                if(rp.node.right != null) queue.addLast(new Pair(rp.node.right,rp.index * 2 + 2));
            }

            max_width = Math.max(max_width, right_max - left_max + 1); // now calculate width and update it.

        }

        return max_width ;
    }


    // if ask to calulate without including the null node. then do this.

    // public static int get_max_width(Node root) {
    //     if(root == null){
    //         return 0 ;
    //     }

    //     LinkedList<Node> queue = new LinkedList<>() ;

    //     queue.addLast(root);
    //     int max_width = 0 ;

    //     while (queue.size() != 0) {
    //         int size = queue.size() ;
    //         max_width = Math.max(max_width, size);
           
    //         while (size-- > 0) {
    //             Node rp = queue.removeFirst();

                

    //             if(rp.left != null) queue.addLast(rp.left);
    //             if(rp.right != null) queue.addLast(rp.right);
    //         }

            

    //     }

    //     return max_width ;
    // }






    public static void main(String[] args) {
        root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(6);
        root.right.left.left = new TreeNode(7);
        root.right.left.right = new TreeNode(8);

        System.out.println(get_max_width(root));
        
    }
    
}

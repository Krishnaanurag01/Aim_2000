package Binary_Tree;

import java.util.ArrayList;
import java.util.LinkedList;


public class Q17_Bottom_View_of_Binary_Tree {

    private static TreeNode root ;

    static class TreeNode {

        int data ; 
        TreeNode left ;
        TreeNode right ;

        public TreeNode(int d) {
            data = d ;
        }
    }

    static class vPair {
        // vpair= vertical pair.
        TreeNode node ;
        int hl ; // horizontal level

        public vPair(TreeNode node , int level){
            this.node = node ;
            hl =level ;
        }

    }


    public static void width(TreeNode root , int level , int[] arr) {
        if(root == null){
            return ;
        }

        arr[0] = Math.min(arr[0], level);
        arr[1] = Math.max(arr[1], level);

        width(root.left, level-1, arr);
        width(root.right, level+1, arr);
    }


    // this is same as top view we just have to override the value of each level.
    // we can also use method 1 of top view in this.

    // time and space is : o(n)


    public static ArrayList<Integer> get_bottom_view(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>() ;

        if(root == null) return list ;

        int[] minMax = new int[2] ; 
        width(root, 0,minMax);

        int len = minMax[1] - minMax[0] + 1 ;

        LinkedList<vPair> queue = new LinkedList<>() ;
        queue.add( new vPair(root, Math.abs(minMax[0])));

        for (int i = 0; i < len ; i++) list.add(null) ;

        while (queue.size() != 0 ) {
            int size = queue.size() ; 

            while (size-- > 0) {
                vPair pair = queue.removeFirst();

                list.set(pair.hl, pair.node.data) ; // here we overriding the value to get the last value of that level.

                if(pair.node.left != null) queue.addLast(new vPair(pair.node.left, pair.hl - 1));
                if(pair.node.right != null) queue.addLast(new vPair(pair.node.right, pair.hl + 1));
            }
        }

        return list ;
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

        System.out.println(get_bottom_view(root));
        
    }
    
}

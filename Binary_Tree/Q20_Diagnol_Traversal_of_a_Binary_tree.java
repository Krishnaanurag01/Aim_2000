package Binary_Tree;

import java.util.ArrayList;
import java.util.LinkedList;

public class Q20_Diagnol_Traversal_of_a_Binary_tree {

    private static TreeNode root ;

    static class TreeNode {

        int data ; 
        TreeNode left ;
        TreeNode right ;

        public TreeNode(int d) {
            data = d ;
        }
    }


    // as each element is getting traversed two times : first time when adding to the queue and second time on removing 
    // so time would be o(2n) and space is o(n) . time and space is : o(n)


    // for diagonal : left node of every node comes in next diagonal and right of every node and left of upper level is comes under one diagonal.
    public static ArrayList<ArrayList<Integer>> get_diagonal_traversal(TreeNode node) {

        ArrayList<ArrayList<Integer>> parentList = new ArrayList<>() ;
        if(node == null) return parentList ;

        LinkedList<TreeNode> queue = new LinkedList<>() ;
        queue.add(node) ;

        while (queue.size() != 0) {
            int size = queue.size() ;
            ArrayList<Integer> innerList = new ArrayList<>() ;

            while (size-- > 0) { // checking each node of a level
                TreeNode rnode = queue.removeFirst() ; // remove the first node and if left present then add to queue .
                while (rnode != null) { // keep running untill becomes null.
                    innerList.add(rnode.data); // add to the list.

                    if(rnode.left != null) queue.addLast(rnode.left); // if left present then add to queue.

                    rnode = rnode.right ; // move to right
                }
            }

            parentList.add(innerList);
        }

        return parentList ;
        
    }

    // this is for anti clock wise

    public static ArrayList<ArrayList<Integer>> get_diagonal_traversal2(TreeNode node) {

        ArrayList<ArrayList<Integer>> parentList = new ArrayList<>() ;
        if(node == null) return parentList ;

        LinkedList<TreeNode> queue = new LinkedList<>() ;
        queue.add(node) ;

        while (queue.size() != 0) {
            int size = queue.size() ;
            ArrayList<Integer> innerList = new ArrayList<>() ;

            while (size-- > 0) { // checking each node of a level
                TreeNode rnode = queue.removeFirst() ; // remove the first node and if right present then add to queue .
                while (rnode != null) { // keep running untill becomes null.
                    innerList.add(rnode.data); // add to the list.

                    if(rnode.right != null) queue.addLast(rnode.right); // if right present then add to queue.

                    rnode = rnode.left ; // move to left
                }
            }

            parentList.add(innerList);
        }

        return parentList ;
        
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

       System.out.println(get_diagonal_traversal(root)) ;
    }
    
}

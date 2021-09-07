package Binary_Tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;


public class Q14_Vertical_Order_Of_Binary_Tree {

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


    /// method -1 ;

    // time and space : o(n)


    public static List<List<Integer>> vertical_level_of_BT(TreeNode root) {

        if(root == null){
            return null ;
        }

        LinkedList<vPair> queue = new LinkedList<>();  // for level order traversal.
        HashMap<Integer,List<Integer>> map = new HashMap<>() ; // for storing the vertical level vallues.

        int minVlevel = 0 ; // for adding the values in ans in order.
        int maxVLevel = 0 ;//  || 

        queue.addLast(new vPair(root, 0));  // add the  first pair.

        while (queue.size() != 0) {
            int size = queue.size() ; // this will find the nummber of process of each level.

            while (size-- > 0) {
                vPair pair = queue.removeFirst(); // first remove the first  pair.

                map.putIfAbsent(pair.hl, new ArrayList<>() ); // now as we have to store list in map so we have to initialize list before  using it so if not present in list then create it for that level.
                map.get(pair.hl).add(pair.node.data); // this will add the node value in current list of current level .


                minVlevel = Math.min(minVlevel, pair.hl); // help in storig the result in order.
                maxVLevel = Math.max(maxVLevel, pair.hl);

                if(pair.node.left != null) queue.addLast(new vPair(pair.node.left,pair.hl-1));  // now go the left with -1 in level
                if(pair.node.right != null) queue.addLast(new vPair(pair.node.right,pair.hl+1)); // go for the right with +1 in level
            }
        }

        List<List<Integer>> ansList = new ArrayList<>() ; // now finall add the answer in answer list.

        for(int i = minVlevel ; i<= maxVLevel ; i++){ // this will help in storing result in order.
            ansList.add(map.get(i));
        }

       
        return ansList ;
    }















    public static void main(String[] args) {
        
        root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(6);
        root.right.left.left = new TreeNode(7);
        root.right.left.right = new TreeNode(8);

       System.out.println(vertical_level_of_BT(root));
    }
}

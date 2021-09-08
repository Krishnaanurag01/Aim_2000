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



    // method 2 : time and space is  o(n) but  here we didn't extra space for hashmap.


    public static void width(TreeNode root , int level , int[] arr) {  // first find the width. check q15 for it.
        if(root == null) return ;

        arr[0] = Math.min(arr[0], level);
        arr[1] = Math.max(arr[1], level);

        width(root.left, level-1, arr);
        width(root.right, level+1, arr);
    }

    public static List<List<Integer>> vertical_order(TreeNode root) {
        List<List<Integer>> anslist = new ArrayList<>() ;

        if(root == null) return anslist ;

        int[] minMax = new int[2] ;
        width(root,0, minMax);
        int len = minMax[1] - minMax[0] + 1 ; // gives the width of tree.

        LinkedList<vPair> queue = new LinkedList<>() ; // for level order traversal.

        queue.add(new vPair(root, Math.abs(minMax[0]))); // here minMax[0] will have left most vertical level and most probably in negative so if take abs of that will then we can store directly to anslist. for ex : if left most is -2 then abs give 2 so root level becomes 2 and left most will be 0 level .


        for (int i = 0; i < len ; i++)  anslist.add(new ArrayList<>()) ; // initializing list for every anslist.


        while (queue.size() != 0) {
            int size = queue.size() ;

            while (size-- > 0) {
                vPair rp = queue.removeFirst() ;

                anslist.get(rp.hl).add(rp.node.data) ; // adding to the anslist.

                if(rp.node.left !=null) queue.add(new vPair(rp.node.left, rp.hl - 1));  // moving left with level - 1 ; 
                if(rp.node.right !=null) queue.add(new vPair(rp.node.right, rp.hl + 1)); // moving right with level + 1 ;
            }
        }

        return anslist ;
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
       System.out.println(vertical_order(root));
    }
}

package Binary_Tree;

import java.util.*;



/// same as Q43

public class Q44_All_node_at_distance_k {


    static class TreeNode {
        int val ;
        TreeNode left ;
        TreeNode right ;

        TreeNode(int val){
            this.val = val ;
            this.left = null ;
            this.right = null ;
        }
    }

    public static List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        return sum_at_distK(root,target,k);
    }
    
     static List<Integer> sum_at_distK(TreeNode root, TreeNode target, int k){
        // Your code goes here

         List<Integer> list = new ArrayList<>() ;
         
        if(root == null){
            return list ;
        }

        HashMap<TreeNode , TreeNode> map = new HashMap<>() ; // this will store parents of each node.

         storeParent(root , map) ;


       

        // using bfs for finding the sum.

        LinkedList<TreeNode> queue = new LinkedList<>() ;
        HashSet<TreeNode> set = new HashSet<>() ;

        queue.add(target);
        set.add(target) ;

        int level = 0 ;

        while (queue.size() > 0 && k >= level ) {

            int size = queue.size() ;

            while (size-- > 0) {
                
                TreeNode rem = queue.removeFirst() ;
                if(level == k){
                    
                list.add( rem.val ) ;
                }

                if(rem.left != null && !set.contains(rem.left)){
                    queue.add(rem.left) ;
                    set.add(rem.left) ;
                }

                
                if(rem.right != null && !set.contains(rem.right)){
                    queue.add(rem.right) ;
                    set.add(rem.right) ;
                }

                if(map.get(rem) != null && !set.contains(map.get(rem))){
                    queue.add(map.get(rem));
                    set.add(map.get(rem)) ;
                }
            }

            level++ ;
            
        }





        return list ;
    }


    private static void storeParent(TreeNode root, HashMap<TreeNode, TreeNode> map) {


        map.put(root, null); // root node parent is null.

        // doing bfs.

        LinkedList<TreeNode> queue = new LinkedList<>() ;

        queue.add(root) ;

        while (queue.size() > 0) {
            
            TreeNode rem = queue.removeFirst() ;

            if(rem.left != null){
                map.put(rem.left, rem) ;
                queue.add(rem.left) ;
            }

            
            if(rem.right != null){
                map.put(rem.right, rem) ;
                queue.add(rem.right) ;
            }

        }

        return ;
    }
    
}

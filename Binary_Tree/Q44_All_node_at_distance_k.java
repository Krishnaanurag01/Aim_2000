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

class TreeNode {
    int val ;
    TreeNode left ;
    TreeNode right ;

    TreeNode(int val){
        this.val = val ;
        this.left = null ;
        this.right = null ;
    }
}

// this is the optimnal solution : takes O(2n) time and O(1) space (excluding recursive space.)
class Solution {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        List<Integer> ans = new ArrayList<>() ;
        nodeToRoot(root,target,k,ans) ;
        return ans ;        
    }
    
    // using node to root path algo: and finding all the nodes k distance away from each and every parenr or path node of target.
    int nodeToRoot(TreeNode root, TreeNode target, int k, List<Integer> ans){
        if(root == null) return -1 ;
        
        if(root.val == target.val){
            kdown(root,k,null,ans) ; // searching down of target node.
            return 1 ;
         }
        
        int ld = nodeToRoot(root.left, target,k,ans) ;
        if(ld != -1){ // means left side has target node in its path so run kdown from here as well. it will find all the node that is k distance away from target and in between the current node and target node.
            kdown(root,k-ld,root.left,ans) ; 
            return 1+ld ;
        }
        
        int rd = nodeToRoot(root.right, target,k,ans) ;
        if(rd != -1){ // means right side has target node in its path so run kdown from here as well. it will find all the node that is k distance away from target and in between the current node and target node.
            kdown(root,k-rd,root.right,ans) ;   
            return 1+rd ;
        }
        
        return -1 ;
    }
    
    
    // going k down.
    void kdown(TreeNode root, int k , TreeNode blockedNode, List<Integer> ans){
        
        if(root == null || k < 0 || root == blockedNode) return ;
        
        if(k == 0){
            ans.add(root.val) ;
            return ;
        }
        
        kdown(root.left ,k-1,blockedNode,ans) ;   
        kdown(root.right ,k-1,blockedNode,ans) ;   
    }
}
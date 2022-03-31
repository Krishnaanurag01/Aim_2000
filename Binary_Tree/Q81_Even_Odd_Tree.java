package Binary_Tree;
import java.util.*;
public class Q81_Even_Odd_Tree {
 
       class TreeNode{
        int val ;
        TreeNode left,right ;
    }

    //using bfs .
    public boolean isEvenOddTree(TreeNode root) {
        
        int idx = 0 ; // level 0
        LinkedList<TreeNode> q = new LinkedList<>() ;
        q.add(root) ;
        
        while(q.size() != 0){
            int size = q.size() ;
            Integer prev = null ;
            while(size-- > 0){
                TreeNode rn = q.removeFirst() ;
                if(idx % 2 == 0 ){ // when even index
                    if(rn.val % 2 == 0) return false; // if val is even return false.
                    if(prev == null) prev = rn.val ; // update prev
                    else if(prev >= rn.val ) return false ; // not increasing order then return false
                    else prev = rn.val ;
                }
                else{ // when odd index.
                     if(rn.val % 2 != 0) return false; // if val is odd then return false
                    if(prev == null) prev = rn.val ; 
                    else if(prev <= rn.val ) return false ; // not decreasing return false;
                    else prev = rn.val ;
                }
                
                if(rn.left != null) q.add(rn.left) ;
                if(rn.right != null) q.add(rn.right) ;
            }
            idx++ ; // increasing the level
        }
        return true ;
    }
}

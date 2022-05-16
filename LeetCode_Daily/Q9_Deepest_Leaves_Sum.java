package LeetCode_Daily;
import java.util.*;

public class Q9_Deepest_Leaves_Sum {

    public class TreeNode {
             int val;
             TreeNode left;
             TreeNode right;
             TreeNode() {}
             TreeNode(int val) { this.val = val; }
             TreeNode(int val, TreeNode left, TreeNode right) {
                 this.val = val;
                 this.left = left;
                 this.right = right;
             }
         }

         // using bfs for finding the sum of deepest leaf nodes.
    public int deepestLeavesSum(TreeNode root) {
        
        LinkedList<TreeNode> q = new LinkedList<>() ;
        q.add(root) ;
        
        int ans = 0 ;
        while(q.size() > 0 ){
            int sum = 0 ;
            int size = q.size() ;
            while(size-- > 0 ){
                TreeNode rn = q.removeFirst() ;
                sum += rn.val ;
                if(rn.left != null) q.add(rn.left);             
                if(rn.right != null) q.add(rn.right);
            }
            ans = sum ;
        }
        return ans ;
    }
}

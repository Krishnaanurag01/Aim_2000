package Binary_Tree;
import java.util.*;

public class Q49_Binary_Tree_Level_Order_Traversal_II {

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

    public List<List<Integer>> levelOrderBottom(TreeNode root) {

        LinkedList<List<Integer>> ll = new LinkedList<>() ;
        
        List<List<Integer>> ans = new ArrayList<>() ;
        LinkedList<TreeNode> q = new LinkedList<>() ;
        q.add(root) ;
        
        while(q.size() != 0 ){
            
            int size = q.size() ;
            List<Integer> inList = new ArrayList<>() ;

            while (size-- > 0) {
                TreeNode rn = q.removeFirst() ;

                inList.add(rn.val) ;

                if (rn.left != null) {
                    q.add(rn.left) ;
                }

                if (rn.right != null) {
                    q.add(rn.right) ;
                }
            }

            ll.add(inList) ;
            
        }

        while ( ll.size() != 0 ) {
            ans.add(ll.removeLast() ) ;
        }

        return ans ;
        
    }
    
}

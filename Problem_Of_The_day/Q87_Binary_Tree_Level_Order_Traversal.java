package Problem_Of_The_day;
import java.util.*;

public class Q87_Binary_Tree_Level_Order_Traversal {

    public List<List<Integer>> levelOrder(TreeNode root) {
    
        List<List<Integer>> ans = new ArrayList<>() ;
        if(root == null) return ans ;
        LinkedList<TreeNode> q = new LinkedList<>() ;
        q.add(root) ;
        
        while(q.size() > 0){
            int size = q.size() ;
            List<Integer> list = new ArrayList<>();
            while(size-- > 0){
                TreeNode rn = q.removeFirst() ;
                list.add(rn.val);
                if(rn.left != null) q.add(rn.left) ;
                if(rn.right != null) q.add(rn.right) ;
            }
            ans.add(list) ;
        }
        
        return ans ;
    }

    class TreeNode{
        int val ;
        TreeNode left, right ;
    }
}

package Problem_Of_The_day;
import java.util.*;

public class Q211_Average_of_Levels_in_Binary_Tree {

    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> list = new ArrayList<>() ;
        if(root == null) return list ;
        
        LinkedList<TreeNode> q = new LinkedList<>() ;
        q.add(root) ;
        
        while(q.size() > 0){
            int size = q.size() ;
            int bkp = size ;
            long sum = 0 ;
            while(size-- > 0){
                TreeNode rn = q.removeFirst() ;
                sum += rn.val ;
                if(rn.left != null) q.add(rn.left) ;
                if(rn.right != null) q.add(rn.right) ;
            }
            list.add( (sum*1.0)/bkp );
        }
        return list ;
    }

    class TreeNode{
        int val ;
        TreeNode left,right ;
    }
}

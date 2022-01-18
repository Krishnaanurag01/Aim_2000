package Problem_Of_The_day;
import java.util.*;

public class Q40_Maximum_sum_of_Non_adjacent_nodes {

    static class Node {
        Node left,right ;
        int data ;

        Node(int x){
            data = x ;
            left = null ;
            right = null ;
        }
        
    }

    static HashMap<Node,Integer> map = new HashMap<>() ;
    
    static int getMaxSum(Node root)
    {
        
        if(root == null) return  0;
        
        if(map.containsKey(root)){
            return map.get(root) ;
        }
        
        int include = root.data  ;
        
        
        if(root.left != null) {
            include += getMaxSum(root.left.left);
            
            include += getMaxSum(root.left.right);
        }
        
        if(root.right != null) {
             include +=getMaxSum(root.right.left);
            
            include +=getMaxSum(root.right.right);
            
        }
        
        int excluding = getMaxSum(root.left) + getMaxSum(root.right);
        
        int max = include > excluding ? include : excluding ;
        
        map.put(root , max) ;
        
        return map.get(root) ;
       
    }
}

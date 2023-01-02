package Problem_Of_The_day;
import java.util.*;

public class Q325_maximum_value {
    
    ArrayList<Integer> maximumValue(Node node) {
        ArrayList<Integer> ans = new ArrayList<>() ;
        LinkedList<Node> q = new LinkedList<>();
        q.add(node) ;
        
        while(q.size() > 0){
            int size = q.size() ;
            int max = 0 ;
            while(size-- > 0){
                Node rn = q.removeFirst() ;
                max = Math.max(max, rn.data) ;
                
                if(rn.left != null) q.add(rn.left) ;
                if(rn.right != null) q.add(rn.right) ;
            }
            ans.add(max) ;
        }
        
        return ans ;
     }

    class Node{
        int data ;
        Node left,right ;
     }
}

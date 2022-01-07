package Binary_Tree ;
import java.util.*;

public class Q46_Maximum_Node_Level {

    public class Node {
        int data ;
        Node left ;
        Node right ;        
    }


    public static int maxNodeLevel(Node root)
    {
        
        int ans = 0 ; // this will contain the answer.
        
        int level = 0 ; // managing level of binary tree.
        int max_size = 0 ; // this is the max size of any particular level.
        
        LinkedList<Node> q = new LinkedList<>() ;
        
        q.add(root) ;
        
        while(q.size() != 0 ) {
            int size = q.size() ; // got the size of current level
            
            if(max_size < size){ // if current level contains more node than max_size then update both the max size and ans.
                max_size = size ;
                ans = level ;
            }
            
            while(size-- > 0 ){
                Node rf = q.removeFirst() ;
                
                if(rf.left != null) q.add(rf.left) ;
                
                if(rf.right != null) q.add(rf.right) ;
            }
            level++ ; // increasing the level .
            
        }
        
        return ans ;
    }
}
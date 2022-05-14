package LeetCode_Daily;
import java.util.*;

public class Q8_Populating_Next_Right_Pointers_in_Each_Node_II {

    class Node{
        Node left ;
        Node right, next ;
    }

    // using bfs to point next with right node.
    public Node connect(Node root) {
        if(root == null) return root ;
        
        LinkedList<Node> q = new LinkedList<>() ;
        q.add(root) ;
        
        while(q.size() > 0){
            int size = q.size() ;
            Node bkp = null ;
            while(size-- > 0){
                Node rn = q.removeFirst() ;
                if(bkp == null){
                    bkp = rn ;
                }
                else{
                    bkp.next = rn ;
                    bkp = rn ;
                }
                
                if(rn.left != null) q.add(rn.left);
                if(rn.right != null) q.add(rn.right);
            }
        }
        
        return root ;
    }    
}

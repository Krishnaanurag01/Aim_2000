package Problem_Of_The_day;
import java.util.*;

public class Q195_Next_Right_Node {

    class Node{
        int data ;
        Node left,right ;
        Node(int x){
            data = x ;
        }
    }

    Node nextRight(Node root, int key)
    {
        if(root == null ) return new Node(-1) ;
        LinkedList<Node> q = new LinkedList<>() ;
        q.add(root) ;
        
        while(q.size() > 0){
            int size = q.size() ;
            boolean foundPrev = false;
            while(size-- > 0){
                Node rn = q.removeFirst() ;
                if(foundPrev) return rn ;
                if(rn.data == key) foundPrev = true ;
                
                if(rn.left != null) q.add(rn.left) ;
                if(rn.right != null) q.add(rn.right) ;
            }
        }
        
        return new Node(-1);
    }
}

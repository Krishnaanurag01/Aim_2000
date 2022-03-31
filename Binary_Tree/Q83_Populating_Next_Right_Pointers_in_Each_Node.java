package Binary_Tree;
import java.util.*;
public class Q83_Populating_Next_Right_Pointers_in_Each_Node {


// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};


    public Node connect(Node root) {
        
        if(root == null) return root ;
        
        LinkedList<Node> q = new LinkedList<>() ;
        q.add(root) ;
        
        while(q.size() > 0 ){
            int size = q.size() ;
            Node prev = null ;
            while(size-- > 0){
                Node rp = q.removeFirst() ;
               if(prev == null) prev = rp ; // prev is null then make current node prev.
                else{
                    prev.next = rp ; // assign current node as prev's right
                    prev = rp ; // update prev
                }
                
                if(rp.left != null) q.add(rp.left) ;
                if(rp.right != null) q.add(rp.right);
            }
        }
        
                
        return root ;
    }
    
}

package Binary_Search_Tree;
import java.util.*;

public class Q33_Construct_BST_from_inorder {

    class Node{
        Node left, right ;
        int data ;

        Node(int data){
           this.data = data ;
        }
    }

    class Pair{
        Node node = null ;
        int lb = Integer.MIN_VALUE ; // by default left bound is -infinity
        int rb = Integer.MAX_VALUE ; // right bound
        
        Pair(){}
        Pair(Node node, int lb, int rb){
            this.node = node ;
            this.lb = lb ;
            this.rb = rb ;
        }
    }
    
    public Node constructBST(int[] arr)
    {
        LinkedList<Pair> q = new LinkedList<>() ;
        q.add(new Pair() ) ; // adding the first initial pair.
        
        Node root = null ;
        int idx = 0 ;
        
        while(q.size() > 0 && idx < arr.length ) {
            Pair rp = q.removeFirst() ;
            int ele = arr[idx] ;
            
            if(ele < rp.lb || ele > rp.rb) continue ; // if ele is not in range of rp.
            
            Node node = new Node(ele) ; // else create a new node and do operation below
            idx++ ;
            if(rp.node == null) root = node ; // setting the root.
            else{
                
                if(rp.node.data >= ele){ // means current node is left child.
                    rp.node.left = node ;
                }
                else{
                    rp.node.right = node;
                }
            }
            
            q.add( new Pair(node, rp.lb, ele ) ) ; // adding left side range
            q.add( new Pair(node, ele , rp.rb) ); // right side range.
            
        }
        
        return root ;
    }
    
}

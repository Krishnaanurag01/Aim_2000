package Graph_level_02;
import java.util.*;

public class Q49_Clone_Graph {

    class Node {
        public int val;
        public List<Node> neighbors;
        Node(int val){
            this.val = val ;
            neighbors = new ArrayList<>() ;
        }
    }

    HashMap<Node,Node> map ;
    public Node cloneGraph(Node node) {
     
        map = new HashMap<>() ;
        return helper(node) ;
    }
    
    Node helper(Node node){
        if(node == null) return node ;
        Node nnode = new Node(node.val) ;
        map.put(node,nnode) ; // storing node with clone node
        
        for(Node nbr : node.neighbors){
            if(map.containsKey(nbr)){ // nbr is already cloned then add directly from map.
                nnode.neighbors.add( map.get(nbr)) ; 
            }
            else{ // else go further.
                nnode.neighbors.add( helper(nbr));
            }
        }

        return nnode ;
    }
}

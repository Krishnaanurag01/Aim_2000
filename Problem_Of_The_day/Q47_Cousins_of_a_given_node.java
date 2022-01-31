package Problem_Of_The_day;
import java.util.*;
public class Q47_Cousins_of_a_given_node {

    class Node {
        int data;
        Node left;
        Node right;
        Node(int data) {
            this.data = data;
            left = null;
            right = null;
        }
    } 
    
    public static ArrayList<Integer> printCousins(Node root, Node node_to_find)
    {
        //code here
        
        HashMap<Node,Node> map = new HashMap<>() ; // key -> child and value -> parent
        ArrayList<Integer> list = new ArrayList<>() ; // ans list
        
        LinkedList<Node> q = new LinkedList<>() ;
        
        q.add(root) ;
        boolean nodeFound = false ; // this denote that our given node is not founded yet
        
        while(q.size() != 0 ){
            int size = q.size() ;
            
            while(size-- > 0){
                Node rn = q.removeFirst() ;
                
                
                if(rn.left != null){
                    map.put(rn.left,rn); // child is key and rn is parent
                    q.add(rn.left) ;
                    
                     if(rn.left == node_to_find) // if given node is founded 
                      nodeFound = true ; //  mark true
                      
                }
                
                
                if(rn.right != null){
                    map.put(rn.right,rn); // child is key and rn is parent
                    q.add(rn.right) ;
                    
                    if(rn.right == node_to_find) // if right child is given node then mark true
                      nodeFound = true ;
                }
            }
            
            if(nodeFound == true){ // check if true then remove each node of q and 
                while(q.size() > 0){
                    Node rn = q.removeFirst() ;
                    if(map.get(rn) != map.get(node_to_find)){ // check if it has differnet parent as given node if yes then add to answer.
                        list.add(rn.data) ;
                    }
                }
            }
        }
        
        if(list.size() == 0 )
        list.add(-1) ;
        
        return list ;
    }

}

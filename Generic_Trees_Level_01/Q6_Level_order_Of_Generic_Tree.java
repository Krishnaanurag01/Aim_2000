package Generic_Trees_Level_01;
import java.util.*;

public class Q6_Level_order_Of_Generic_Tree {

    private static class Node {
        int data;
        ArrayList<Node> children = new ArrayList<>();
      }
    
     
    
      public static void levelOrder(Node node){
    
        LinkedList<Node> q = new LinkedList<>() ;
        q.add(node) ;
    
        while(q.size() > 0 ){
          int size = q.size() ;
          while ( size-- > 0 ) {
            Node rn = q.removeFirst() ; // printing the first node
            System.out.print(rn.data+" "); 
            if(rn.children.size() > 0){ // adding it's children if available
              q.addAll(rn.children) ;
            }
          }
        }
        System.out.println(".");
      }
    
}

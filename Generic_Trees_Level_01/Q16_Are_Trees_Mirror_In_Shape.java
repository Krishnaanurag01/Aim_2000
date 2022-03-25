package Generic_Trees_Level_01;
import java.util.*;

public class Q16_Are_Trees_Mirror_In_Shape {
    
    private static class Node {
        // int data;
        ArrayList<Node> children = new ArrayList<>();
      }
    
      public static boolean areMirror(Node n1, Node n2) {
        
         
            if(n1.children.size() != n2.children.size()){ // if both contains differenct count of children then return false
              return false; 
            }
        
            for(int i = 0 ; i < n1.children.size() ; i++){
        
              int j = n1.children.size() - 1 - i ; // for mirror image, left of first tree should be equals to right of second tree. 

              Node child1 = n1.children.get(i) ;  // left side child
              Node child2 = n2.children.get(j) ;  // right side child
        
              // and check if they are also following this property if not return false.
               if ( areMirror(child1,child2) == false )
               return false ;
            }
        
            return true; 
      }
    
}

package Generic_Trees_Level_01;
import java.util.*;

public class Q17_Is_Generic_Tree_Symmetric {

    private static class Node {
        // int data;
        ArrayList<Node> children = new ArrayList<>();
      }

      public static boolean IsSymmetric(Node node) {
    
        for( int i = 0 ; i < node.children.size()/2 ; i++ ) {
    
          int j = node.children.size() - 1 - i ;
    
          Node childA = node.children.get(i) ;  
          Node childB = node.children.get(j) ;
    
          // both end child should have equal childrens if  not then return false.
          if(childA.children.size() != childB.children.size() ){
            return false; 
          }
    
          if( IsSymmetric(childA) && IsSymmetric(childB) == false)
          return false;
          
        }

        return true ;

      }
    
     

    
    
}

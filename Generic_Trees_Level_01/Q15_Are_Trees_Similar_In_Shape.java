package Generic_Trees_Level_01;
import java.util.*;

public class Q15_Are_Trees_Similar_In_Shape {


    private static class Node {
        // int data;  // uncomment if when running
        ArrayList<Node> children = new ArrayList<>();
      }

      // two trees are similar when thery holds same number of childrens and so does there children.

      public static boolean areSimilar(Node n1, Node n2) {
        
        if(n1.children.size() != n2.children.size()){ // if both contains differenct count of children then return false
          return false; 
        }
    
        for(int i = 0 ; i < n1.children.size() ; i++){
    
            // get both trees ith child
          Node child1 = n1.children.get(i) ; 
          Node child2 = n2.children.get(i) ;
    
          // and check if they are also following this property if not return false.
           if ( areSimilar(child1,child2) == false )
           return false ;
        }
    
        return true; 
    
      }
    
}

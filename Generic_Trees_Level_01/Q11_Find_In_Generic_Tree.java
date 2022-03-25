package Generic_Trees_Level_01;
import java.util.*;

public class Q11_Find_In_Generic_Tree {
    
    private static class Node {
        int data;
        ArrayList<Node> children = new ArrayList<>();
      }

    
      public static boolean find(Node node, int data) {
        
        if(node.data == data){ // if current node is same then return true 
          return true ;
        }
    
        for (Node child : node.children) { //check if child node is true then return true
           if(find(child,data))
           return true ;
        }
    
        // else false
        return false;

      }
          

}

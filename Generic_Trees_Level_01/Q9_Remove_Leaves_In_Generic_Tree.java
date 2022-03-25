package Generic_Trees_Level_01;
import java.util.*;

public class Q9_Remove_Leaves_In_Generic_Tree {

    private static class Node {
        // int data; // uncomment it when running here.
        ArrayList<Node> children = new ArrayList<>();
      }
    
      public static void removeLeaves(Node node) {
    
        for (int i = 0 ; i < node.children.size() ; i++) {
    
          if(node.children.get(i).children.size() == 0){
            node.children.remove(i) ;
            i-- ;
          }
          else{
            removeLeaves(node.children.get(i)) ;
          }
        }
      }

    
}

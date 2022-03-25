package Generic_Trees_Level_01;
import java.util.*;

public class Q13_Lowest_Common_Ancestor {

    private static class Node {
        int data;
        ArrayList<Node> children = new ArrayList<>();
      }


      // this is Q12.
      public static ArrayList<Integer> nodeToRootPath(Node node, int data) {
        if (node.data == data) {
          ArrayList<Integer> path = new ArrayList<>();
          path.add(node.data);
          return path;
        }
    
        for (Node child : node.children) {
          ArrayList<Integer> ptc = nodeToRootPath(child, data);
          if (ptc.size() > 0) {
            ptc.add(node.data);
            return ptc;
          }
        }
    
        return new ArrayList<>();
      }


      // It uses Q12 to find the lca
    
      public static int lca(Node node, int d1, int d2) {
        // write your code here

        ArrayList<Integer> list1 = nodeToRootPath(node,d1); // finding path for d1
        ArrayList<Integer> list2 = nodeToRootPath(node,d2); // finding path for d2
    
        int i = list1.size() - 1 ; 
        int j = list2.size() - 1 ;
    
        // now decrementing index until we find the diffrent value
        while ( i >= 0 && j >= 0 && list1.get(i) == list2.get(j) ) {
          i--;
          j--;
        }
    
    // increasing index to the last equal element
        i++ ;
        j++ ;
    
        // the last equal element is our lca
        return list1.get(i) ;
    
      }
    
    
}

package Generic_Trees_Level_01;
import java.util.*;

public class Q14_Distance_Between_two_nodes_in_Generic_Tree {

    private static class Node {
        int data;
        ArrayList<Node> children = new ArrayList<>();
      }
    
    
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
    


      // using Q12 for finding the path
    
      public static int distanceBetweenNodes(Node node, int d1, int d2){
      
            ArrayList<Integer> list1 = nodeToRootPath(node,d1); // finding path for d1
            ArrayList<Integer> list2 = nodeToRootPath(node,d2); // finding path for d2
        
            int i = list1.size() - 1 ; 
            int j = list2.size() - 1 ;
        
           // now decrementing index until we find the diffrent value
           while ( i >= 0 && j >= 0 && list1.get(i) == list2.get(j) ) {
            list1.remove(i--) ;
            list2.remove(j--) ;
           }
       
           // now both the list will be containing different nodes that will be our answer.
           return list1.size() + list2.size() ;
    
      }

    
    
}

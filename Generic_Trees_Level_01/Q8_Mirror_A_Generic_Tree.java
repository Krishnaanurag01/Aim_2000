package Generic_Trees_Level_01;
import java.util.*;

public class Q8_Mirror_A_Generic_Tree {
    
  private static class Node {
    // int data; // uncomment it when runnning here
    ArrayList<Node> children = new ArrayList<>();
  }


  public static void mirror(Node node){

    LinkedList<Node> q = new LinkedList<>() ;
    q.add(node) ;

    while(q.size() > 0){

      int size = q.size() ;

      while(size-- > 0){

        Node rp = q.removeFirst() ;

        if(rp.children.size() > 1){

           ArrayList<Node> nList = new ArrayList<Node>(); // reversing the child
           ArrayList<Node> oList = rp.children ;

           while(oList.size() > 0){
            nList.add( oList.remove(oList.size() -1) ) ;
           }

           rp.children = nList ;
        }

        for (Node child : rp.children) {
          q.add(child) ;
        }

      }
    }

  }



    
}

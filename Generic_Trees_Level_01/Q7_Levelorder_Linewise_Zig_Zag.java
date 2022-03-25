package Generic_Trees_Level_01;
import java.util.*;

public class Q7_Levelorder_Linewise_Zig_Zag {

    
  private static class Node {
    int data;
    ArrayList<Node> children = new ArrayList<>();
  }
  
  public static void levelOrderLinewiseZZ(Node node){
    
    boolean leftToRight = true ;

    LinkedList<Node> q = new LinkedList<>() ;
    q.add(node) ;

    while ( q.size() > 0 ) {
      int size = q.size() ;

      Stack<Node> bkp = new Stack<Node>();
      while(size-- > 0){
        Node rp = q.removeFirst() ;
        System.out.print(rp.data +" ");

        if(leftToRight){
         while ( rp.children.size() > 0 ) {
           bkp.push(rp.children.remove(0)) ;
         }
        }
        else{
          while ( rp.children.size() > 0 ) {
           bkp.push(rp.children.remove(rp.children.size() - 1)) ;
         }
        }
      }

        leftToRight = !leftToRight ;
          while(bkp.size() > 0){
            q.add(bkp.pop());
          }

      System.out.println();

    }
  }

}

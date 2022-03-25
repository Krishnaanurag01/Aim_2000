package Generic_Trees_Level_01;
import java.util.*;

public class Q12_Node_To_Root_Path_In_Generic_Tree {

    private static class Node {
        int data;
        ArrayList<Node> children = new ArrayList<>();
      }
    
    
     public static ArrayList<Integer> nodeToRootPath(Node node, int data){
    
       ArrayList<Integer> ans = new ArrayList<Integer>(); // this will contain our answer.
    
       helper(node,data,ans) ; //
    
       return ans;
    
     }
    
     public static boolean helper(Node node, int data, ArrayList<Integer> list){
    
       if(node.data == data){ // if it is equals to the node data then add it and return true
         list.add(data) ;
         return true ; /// this denotes that we successfully founded the given data node so if there's any parent of current node available then we can add it to the list node as well.
       }
    
       for (Node child : node.children) {
         boolean shouldIbeInc = helper(child,data,list); // if it true then we must have foudned the node so add current node and return true.
    
         if(shouldIbeInc){
           list.add(node.data) ;
           return true ;
         }
       }
    
       return false;
    
     }
    
    
}

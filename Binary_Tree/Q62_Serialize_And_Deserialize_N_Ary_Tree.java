package Binary_Tree;
import java.util.*;

public class Q62_Serialize_And_Deserialize_N_Ary_Tree {


    static class Node {
        public int val;
        public ArrayList<Node> children;
        public Node(int _val) {
          val = _val;
          children = new ArrayList<Node>();
        }
      }
    
      // Encodes a tree to a single string.
      public static String serialize(Node root) {
    
        if(root == null) return "" ;   
        StringBuilder sb = new StringBuilder() ;
        helper(root,sb) ;
        return sb.toString() ;
      }
    
      public static void helper(Node root, StringBuilder sb){
    
        sb.append(root.val+",") ; 
        for(Node child : root.children){
          helper(child,sb) ;// adding all child
        }
        sb.append("null"+",") ; // denotes end of the children.
    
      }
    
      // Decodes your encoded data to tree.
      public static Node deserialize(String str) {
        String[] arr = str.split(",");
        Stack<Node> stack = new Stack<>() ; // it will hold nodes.
    
        for(int i = 0 ; i < arr.length - 1 ; i++){ // traversing 1 less so that we won't remove or last node from stack.
        String val = arr[i] ;
    
        if(val.equals("null")){  // if we found null then it must be of some child and that child is in the top of stack and and the top child does not need to add this null in its children we just need to add this top node in the stack top node that will be parent of last top node.
          Node removedNode = stack.pop();  // getting parent of null
          stack.peek().children.add(removedNode) ; // getting parent of removed node and adding in it.
        }
        else{
          Node nnode = new Node( Integer.parseInt(val) ) ; // else create a node and add to the stack.
          stack.push(nnode) ;
        }
        }
    
        return stack.pop() ; // returning the root 
      }
    
}

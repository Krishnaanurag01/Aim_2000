package Generic_Trees_Level_01;
import java.util.*;
import java.io.*;

public class Q10_Linearize_A_Generic_Tree {

    private static class Node {
        int data;
        ArrayList<Node> children = new ArrayList<>();
    
        public String toString() {
            return ""+data ;
        }
      }
    
      public static void display(Node node) {
        String str = node.data + " -> ";
        for (Node child : node.children) {
          str += child.data + ", ";
        }
        str += ".";
        System.out.println(str);
    
        for (Node child : node.children) {
          display(child);
        }
      }
    
      public static Node construct(int[] arr) {
        Node root = null;
    
        Stack<Node> st = new Stack<>();
        for (int i = 0; i < arr.length; i++) {
          if (arr[i] == -1) {
            st.pop();
          } else {
            Node t = new Node();
            t.data = arr[i];
    
            if (st.size() > 0) {
              st.peek().children.add(t);
            } else {
              root = t;
            }
    
            st.push(t);
          }
        }
    
        return root;
      }
    
    
      public static void linearize(Node node){
        // write your code here
    
        for (Node child : node.children) {
          linearize(child) ;
        }
    
    
        while(node.children.size() > 1){
          Node lastNode = node.children.remove(node.children.size() - 1) ; /// removig the last child
          Node secondLastNode = node.children.get(node.children.size() - 1) ; // now getting the last element (it's second last as we removed the last above)
    
          Node tail = getTail(secondLastNode) ; // getting tail of it.
    
          tail.children.add(lastNode) ; 
        }
    
      }
    
      static Node getTail(Node node){
    
        while ( node.children.size() == 1) {
          node = node.children.get(0) ;
        }
    
        return node ;
      }
    
      public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        String[] values = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
          arr[i] = Integer.parseInt(values[i]);
        }
    
        Node root = construct(arr);
        linearize(root);
        display(root);
      }
    
}

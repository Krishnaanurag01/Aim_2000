package Generic_Trees_Level_01;
import java.util.*;
import java.io.*;

public class Q18_Predecessor_And_Successor_Of_An_Element {

    private static class Node {
        int data;
        ArrayList<Node> children = new ArrayList<>();
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


      static int predecessor;
      static int successor;
      static int state;  
    
      public static void predecessorAndSuccessor(Node node, int data) {

        // optimization.
        if(state == 2) // means we already found our pre and successor so no need to traverse the tree further.
        return ;

        if(node.data == data){ // when equal then change the state to 1 means now we will find successor.
            state = 1 ;
        }else if (state == 0) { // when state is 0 keep updating the predecessor
            predecessor = node.data ;
        }
        else if(state == 1 ){ // when it is 1 keep updating the successor
            successor = node.data ;
            state = 2 ;
        }

        // preorder.
        for (Node child : node.children) {
            predecessorAndSuccessor(child, data);
        }

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
        int data = Integer.parseInt(br.readLine());

        
        predecessor = -1; 
        successor = -1 ;
        state = 0;

        predecessorAndSuccessor(root, data);

        System.out.println("Predeceessor : " + predecessor );
        System.out.println("Successor : " + successor );
      }
    
}

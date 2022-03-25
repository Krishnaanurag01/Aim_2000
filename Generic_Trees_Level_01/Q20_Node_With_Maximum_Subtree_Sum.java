package Generic_Trees_Level_01;
import java.util.*;
import java.io.*;

public class Q20_Node_With_Maximum_Subtree_Sum {

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
    
      public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        String[] values = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
          arr[i] = Integer.parseInt(values[i]);
        }
    
        Node root = construct(arr);
        // write your code here
    
        parent = -1 ; // intialization
        maxSum = Integer.MIN_VALUE; // and assigning it by min value.
         helper(root) ;
        System.out.println( parent+"@" + maxSum ) ;
      }
      
      static int parent ;
      static int maxSum ;
      public static int helper(Node node){
    
        int sum = 0 ;
    
        // adding all the substree sum 
        for (Node child : node.children) {
    
          sum += helper(child) ;
        }
    
        sum = sum + node.data ;
     
        // sum is greater than the max sum then we have found a new subtree so update both parent and maxSum.
        if(sum > maxSum){
          maxSum = sum ;
          parent = node.data ;
        }
    
        return sum ;
    
      }
    
    
}

package Generic_Trees_Level_01;
import java.util.*;
import java.io.*;

public class Q21_Diameter_Of_Generic_Tree {

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
    
        dia = 0 ;
        helper(root) ;
        System.out.println(dia);
      }
    
      static int dia  ;
    
      static int helper(Node node){
    
        int dch = -1 ; // deepest child height
        int sdch = -1 ; /// second deepest child height
    
        for (Node child : node.children) {
    
          int cHt = helper(child) ; // child height
    
          if(cHt > dch){
            // then give dch val to sdch and update dch with cHt
    
            sdch = dch ;
            dch = cHt ;
          }
          else if( sdch < cHt){
            sdch = cHt ;
          }
    
        }
    
    // checking if deepest child height + second deepest child height +2 is greater than our previous answer or not.
        if( dch + sdch + 2 > dia ){ // here adding +2 becuase we dch and sdch are two differnt nodes height so there are two edges present in between these two nodes.
          dia = dch + sdch + 2 ;
        }
    
    // now sending the deepest height + 1 ( for current node)
        return dch + 1 ; 
      }
    
}

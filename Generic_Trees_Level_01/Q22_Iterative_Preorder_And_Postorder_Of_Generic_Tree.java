package Generic_Trees_Level_01;
import java.util.*;
import java.io.*;

public class Q22_Iterative_Preorder_And_Postorder_Of_Generic_Tree {

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
    
      static class Pair{
        Node node ;
        int state ;
    
        Pair(Node node, int state){
          this.node = node ;
           this.state = state ;
        }
      }
    
      public static void IterativePreandPostOrder(Node node) {
        
        Stack<Pair> stack = new Stack<>() ;
        stack.push( new Pair( node , -1 ) ) ;
    
        String pre = "" ;
        String post = "" ;
    
        while ( stack.size() > 0 ) {
          Pair tp = stack.peek() ;
          if(tp.state == -1){
            pre += " "+tp.node.data ;
            tp.state++ ;
          }
          else if(tp.state == tp.node.children.size()){
            post += " "+ tp.node.data ;
            stack.pop() ;
          }
          else{
            Pair np = new Pair(tp.node.children.get(tp.state),-1) ;
            stack.push(np) ;
            tp.state++ ;
          }
        } 
    
        System.out.println(pre);
        System.out.println(post);
    
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
        IterativePreandPostOrder(root);
      }
    
    
}

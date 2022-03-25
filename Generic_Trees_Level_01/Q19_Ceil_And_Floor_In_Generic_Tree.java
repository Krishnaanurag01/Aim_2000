package Generic_Trees_Level_01;
import java.util.*;
import java.io.* ;

public class Q19_Ceil_And_Floor_In_Generic_Tree {

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
    
      
      static int ceil; // this is just greater than data
      static int floor; // just smaller than data
      public static void ceilAndFloor(Node node, int data) {
        // Write your code here
    
        if(node.data != data){   // if current node data is same then perform following
           if( node.data > data && ceil > node.data)
           {
             ceil = node.data ;
           }
           else if( node.data < data && node.data > floor ){
             floor = node.data ;
           }
        }
    
        for (Node child : node.children) {
          ceilAndFloor(child,data) ;
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
    
        int data = Integer.parseInt(br.readLine());
    
        Node root = construct(arr);
        ceil = Integer.MAX_VALUE; // initialize it with max value becuase we have to find min value among the larger values.
        floor = Integer.MIN_VALUE; //   --------------- min ------------------------------ max --------------- smaller ------
        ceilAndFloor(root, data);
        System.out.println("CEIL = " + ceil);
        System.out.println("FLOOR = " + floor);
      }
    
}

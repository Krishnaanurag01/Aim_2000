package Generic_Trees_Level_01;
import java.util.*;
import java.io.*;

public class Q23_ITERABLE_AND_ITERATOR {

    static class GenericTree implements Iterable<Integer>{ // iterable interface allows any class to perfomr loop over it.

        Node root ; // root of the generic tree
        GenericTree(Node node){
            this.root = node ;
        }

        public Iterator<Integer> iterator(){ 
            GenricIterator gi = new GenricIterator(root) ; // as we can't return object of any implement so we are reutring the another class object that is implementign the iterator interface.
            return gi ;
        }
    }

    static class GenricIterator implements Iterator<Integer>{

        Integer nval ; // next val
        Stack<Pair> stack  ; // Q22 logic 

        GenricIterator(Node root){
            stack = new Stack<>() ;
            stack.push( new Pair(root, -1)) ; // adding root with -1 state, same as q22
            next() ;// also finding the first value
        }

        public boolean hasNext(){
            if(nval == null ){ // if next value is not present the return false
                return false ;
            } // else true
            return true ;
        }

        @Override
        public Integer next() {

            Integer val = nval ;
            nval = null ;

            while ( stack.size() > 0 ) { // same logic as Q22
                Pair tp = stack.peek() ;
                if(tp.state == -1){ // when came to prefix value
                    nval = tp.node.data ; // then assing next val varibale with current value.
                  tp.state++ ;
                  break ;
                }
                else if(tp.state == tp.node.children.size()){
                  stack.pop() ;
                }
                else{
                  Pair np = new Pair(tp.node.children.get(tp.state),-1) ;
                  stack.push(np) ;
                  tp.state++ ;
                }
              } 
            return val;
        }
    }

    // same old functions and class.

    static class Node{
        int data ;
        ArrayList<Node> children = new ArrayList<>() ;
    }

    static Node root ;


    static class Pair{
        Node node ;
        int state ;
    
        Pair(Node node, int state){
          this.node = node ;
           this.state = state ;
        }
    }
    // same old function.
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        String[] values = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
          arr[i] = Integer.parseInt(values[i]);
        }
    
        Node root = construct(arr);

        GenericTree gt = new GenericTree(root) ;

        for (int val : gt) {
            System.out.println(val);
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

        return root ;
      }
    
}

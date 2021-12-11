package Stack_and_Queue_level01;
import java.util.*;

// this approach uses linked list insted of stack and treemap for keep track of max element.

public class Q38_Max_stack_optimal_approach {

    public static class MaxStack {

        static class Node{ // doubly ll
            int val ;
            Node next ;
            Node pre ;

            Node(int x){
                this.val = x ;
            }
        }

        private final Node head ;
        private final Node tail ;

        TreeMap<Integer,ArrayList<Node>> tmap ;

        public Node addTop(int x){ // this will add node in last.

            Node newNode = new Node(x) ;
            Node preNode = tail.pre ;

            newNode.next = tail ;
            tail.pre = newNode ;

            preNode.next = newNode ;
            newNode.pre = preNode ;

            return newNode ;
        }

        public Node getTop(){ // return top most node. (last)

            return tail.pre ;
        }

        public void remove(Node add){ // remove given node.

            Node next = add.next ;
            Node prev = add.pre ;

            prev.next = next ;
            next.pre = prev ;
        }

        public MaxStack() { // intializing phase
    
            tmap = new TreeMap<>() ;
            head = new Node(-1) ;
            tail = new Node(-1) ;

            head.next = tail ;
            tail.pre = head ;
        }
    
        public void push(int x) {

            Node add = addTop(x) ;// after adding to ll it will have the address of added node

            ArrayList<Node> al = new ArrayList<>() ; // get all address with x key

            if(tmap.containsKey(x)){
                al = tmap.get(x) ;
            }
            else{
                tmap.put(x, al) ;
            }
            al.add(add) ; // adding new node address in it.
    
        }
    
        public int pop() {
            Node topNode = getTop() ; // getting address of top element

            ArrayList<Node> al = tmap.get(topNode.val) ;
            al.remove(al.size() - 1) ; // removing last node from tmap.(as this top node address will be stored at last.)
            remove(topNode);// removing from ll also.

            if(al.size() == 0){ // tmap with topnode.val key becomes empty then remove this set.
                tmap.remove(topNode.val) ;
            }

          return topNode.val ;
        }
    
        public int top() {

          return getTop().val; // returning value of it
        }
    
        public int peekMax() {
            
          return tmap.lastKey() ; // this will return the last key of tmap as tmap store data in a sorted fashion from smaller to larger so lastkey element will also be largest.
        }
    
        public int popMax() {

            int x = tmap.lastKey() ; // getting value of max element
            ArrayList<Node> al =  tmap.get(x) ;
            Node maxNode = al.remove(al.size() - 1 ) ; // removing address from tmap and storing it in a variable
            remove(maxNode); // now removing from ll.
            if (al.size() == 0 ) { // tmap with x key becomes empty then remove this set.
                tmap.remove(x) ;
            }

          return x;
        }
    
      }
    
}

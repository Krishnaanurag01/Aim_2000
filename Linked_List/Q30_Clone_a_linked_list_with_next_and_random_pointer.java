package Linked_List;

import java.util.HashMap;


public class Q30_Clone_a_linked_list_with_next_and_random_pointer {

    static class Node{

        int data;
        Node next;
        Node arb ;
                                                  /// arb is random pointer.
        public Node(int i){
            data = i ;
            next = null ;
            arb = null ;
        }
    }



    /// using hashing : time comp is: o(n) and space is o(n).
    public static Node clone_the_ll(Node listHead) {
        HashMap<Node,Node> map = new HashMap<>();

        Node current = listHead ;

        // creating a new hear of the clone.
        Node nHead = new Node(-1) ;
        Node prev = nHead ;


        // traverse the original list and create node in new list with same data.
        while (current != null) {
            prev.next = new Node(current.data);
            map.put(current, prev.next);  // now saving the address of both orignal and new nodes.

            current = current.next;
            prev = prev.next;

        }

        nHead = nHead.next ;  /// this is the head of our new list.
        Node c1 = nHead ; // for traversing.
        Node c2 = listHead ;

        while (c1 != null) { 
            Node randomNode = c2.arb != null ? map.get(c2.arb) : null ; // now look into the map for nodes random address and return the address of new node where same data is present.
            c1.arb = randomNode ;

            c1 = c1.next; //move forward.
            c2 = c2.next; 
        }


        return nHead ; // returning the new head.
    }












    public static void main(String[] args) {
        
    }



    // method 2 :

    /// cloning the linked list without the extra space. 
    // time comp ; o(n) and space is constant.

    public static Node clone_the_list(Node head) {
        copyList(head); // first copy the node and attach it to the next.    this takes :-  o(1) space & o(n) time
        copyRandomPointers(head); // now copy the random pointers             this takes :-  o(1) space & o(n) time
        return extraTheList(head); // now simply extract the cloned list.      this takes :-  o(1) space & o(n) time
    }






    
    private static void copyList(Node head) {

        Node current = head;

        while (current != null) {
            Node forward = current.next ; /// backup the next original node.

            Node cloneNode =  new Node(current.data); // now create a clone of current node.

            current.next = cloneNode ; // and attach it to its next .

            cloneNode.next = forward; // and now clone next will have the next orignal node.

            current = forward ; // moving forward.
        }
    }


    private static void copyRandomPointers(Node head) {

        Node current = head ;

        while(current != null){
            Node randomNode = current.arb ; // now copy the random node of original node , because its next location will have the clone of it.

            if (randomNode != null) { // when the random node is not null then perform this.
                
                current.next.arb = randomNode.next ; // current.next.arb means the random pointer of current.next ( which is the clonned node) will have randomNodes clone which is randomNode.next( we did this in copy list function.)
            }

            current = current.next.next; // now move to the next original node.
        }
    }



    private static Node extraTheList(Node head) {
       
        Node cloneHead = new Node(-1); // create a new node which would be our clonned list head.
        Node prev = cloneHead ;

        Node current = head ;

        while (current != null) {
            prev.next = current.next ; // add the cloned node to prev.

            current.next = current.next.next ; //now current removed the clonned node and pointing to the next original node.

            prev = prev.next ; // moving forwrd.

            current = current.next ; // moving forward ( here current.next is next original node becuase we already make it on the 2nd line of loop.)
            
        }

        return cloneHead.next; // retuning clonned list head.
    }
}

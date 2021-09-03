package Linked_List;




public class Q1_Reverse_Linked_List {

       Node head ;
      static class Node{
 
         int data ;
         Node next ;
 
       public Node(int d){
 
             data = d ;
             next = null;
 
         }
     }

     Node reverse(Node head){

        Node current = head;
        Node forward = null ;
        Node previous = null ;

        while(current != null){

            forward = current.next;

            current.next = previous ;

            previous = current ;

            current = forward ;
        }
        return previous ;
    }

    // recursivly reverse the Linked List.

    Node reverseRecursivly(Node head){

        if( head == null || head.next == null){
            return head ;   /// when we hit the last node we simply return it. we don't have to do anything there.
        }

        Node newHead = reverseRecursivly(head.next); // making this newhead so that we can have our new head by the end of the recursion, this will be the point from where our linked list start. this points towards our nodes.

        head.next.next = head; // making next node address point to us.

        head.next = null; // with this last node will point to the null




        return newHead ; // returning new head.
    }

    public void printLinkedList(Node head) {

        Node printIt = head;
        while(printIt != null){
            System.out.print(printIt.data + " -> ");
            printIt = printIt.next;
        }

        System.out.println();
        
    }

    public static void main(String[] args) {
        Q1_Reverse_Linked_List list = new Q1_Reverse_Linked_List();

      list.head = new Node(85) ;
      list.head.next = new Node(55);
      list.head.next.next = new Node(45);
      list.head.next.next.next = new Node(35);
      list.head.next.next.next.next = new Node(25);

      list.printLinkedList(list.head);

    //   head = list.reverse(head);
    //   list.printLinkedList(head);

      Node head = list.reverseRecursivly(list.head);
      list.printLinkedList(head);

    }
}

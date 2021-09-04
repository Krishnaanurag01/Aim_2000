package Linked_List;

public class Q36_Segregate_even_and_odd_nodes_in_a_Link_List {

    Node head ;
    public static class Node {

        int data ;
        Node next; 

        public Node(int d){
            data = d ;
            next = null ;
        }        
    }


    public void printLinkedList(Node head) {

        Node printIt = head;
        while(printIt != null){
            System.out.print(printIt.data + " -> ");
            printIt = printIt.next;
        }

        System.out.println();
    }

    public  void insertNode(int d) {
        Node newNode = new Node(d);
        if(head == null){
            head = newNode ;
            return;
        }

        Node temp = head;

        while (temp.next != null) {
            temp = temp.next;            
        }

        temp.next = newNode;
        
    }


    // time and space comp : o(n) time & o(1) space.

    public static Node segregate_over_odd_even(Node listHead) {
        
        if(listHead == null || listHead.next == null){
            return listHead;
        }

        Node evenHead = new Node(-1);
        Node ptr1 = evenHead ;

        Node oddHead = new Node(-1);
        Node ptr2 = oddHead ;

        Node curr = listHead;

        while (curr != null) {
            if(curr.data%2 == 0){  // when the data is even add it to the even poiinter. o\w add to odd pointer.
                ptr1.next = curr ;
                ptr1 = ptr1.next ;
            }
            else{
                ptr2.next = curr;
                ptr2 = ptr2.next;
            }
            curr = curr.next ;
        }

        if(evenHead.next != null){ // when even pointer is not empty then add with the odd pointer.
            evenHead = evenHead.next ;   // this handle the cases when : both odd and even present or only even present.
            ptr1.next = oddHead.next;
            ptr2.next = null ;
            return evenHead;
        }
        else{
            oddHead = oddHead.next ;  // this handle this cases when only odd presents.
            return oddHead ;

        }

    }




    public static void main(String[] args) {

        Q36_Segregate_even_and_odd_nodes_in_a_Link_List ll = new Q36_Segregate_even_and_odd_nodes_in_a_Link_List() ;

        ll.insertNode(2);
        ll.insertNode(3);
        ll.insertNode(4);
        ll.insertNode(5);
        ll.insertNode(6);
        ll.insertNode(7);
        ll.insertNode(8);

        Node n = segregate_over_odd_even(ll.head);
        
        ll.printLinkedList(n);
        ll.printLinkedList(ll.head);
    }
    
}

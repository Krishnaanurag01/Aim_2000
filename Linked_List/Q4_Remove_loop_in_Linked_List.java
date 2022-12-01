package Linked_List;


public class Q4_Remove_loop_in_Linked_List {

    node head ;
    public static class node {

        int data ;
        node next; 

        public node(int d){
            data = d ;
            next = null ;
        }        
    }
    public void printLinkedList(node head) {

        node printIt = head;
        while(printIt != null){
            System.out.print(printIt.data + " -> ");
            printIt = printIt.next;
        }

        System.out.println();
    }
    public  void insertNode(int d) {
        node newNode = new node(d);
        if(head == null){
            head = newNode ;
            return;
        }

        node temp = head;

        while (temp.next != null) {
            temp = temp.next;            
        }

        temp.next = newNode;
        
    }
    public static void main(String[] args) {

        Q4_Remove_loop_in_Linked_List ll = new Q4_Remove_loop_in_Linked_List();

    node first = new node(5);
       node second = new node(6);

       node third = new node(7);

       node fourth = new node(8);

       node fifth = new node(9);

      

       ll.head = first ;
       ll.head.next = second;
       ll.head.next.next = third;
       ll.head.next.next.next =fourth ;
       ll.head.next.next.next.next = fifth ;

       ll.head.next.next.next.next.next = first ;

    //    ll.printLinkedList(ll.head);

        removeLoop(ll.head);

       ll.printLinkedList(ll.head);

        
    }

    private static void removeLoop(node head2) {

        node hare = head2 ;
        node tortoise = head2 ;

        while (hare != null && hare.next != null) { // here adding hare.next != null condition because in the loop we are trying to access the hare.next.next which gives null pointer exceptions without this condition.
            tortoise = tortoise.next ;
            hare = hare.next.next;
            if( hare == tortoise){
                break;
            }
        }
        
        // this is the case when our loop starts from head. if we don't do this then we'll lose our rest of the nodes.
        // check copy for better understanding.
        if(tortoise == head2){
            while (hare.next != tortoise) {
                hare = hare.next;
            }

            hare.next = null ;
        }/// o\w do this.
        else if(hare == tortoise){
            hare = head2 ;
            while (hare.next != tortoise.next) {
                hare = hare.next;
                tortoise = tortoise.next;
            }
            tortoise.next = null ;
        }
    }
    
}

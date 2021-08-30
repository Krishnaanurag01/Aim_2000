package Linked_List;


public class Q6_Remove_duplicate_element_from_sorted_Linked_List {

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


    // solution function.

    public void removeDuplicate(node head2) {
        if(head2 == null || head2.next == null){
            return;
        }

        node current = head2;
    
        while (current.next!= null) {
            if(current.data == current.next.data){
                // node forward = current.next.next;
                current.next= current.next.next;
                // current = forward;
            }
            else{

                current = current.next;
            }
        }
    }




















    public static void main(String[] args) {

        Q6_Remove_duplicate_element_from_sorted_Linked_List ll = new Q6_Remove_duplicate_element_from_sorted_Linked_List();

        ll.insertNode(2);
        ll.insertNode(2);
        ll.insertNode(2);
        ll.insertNode(3);
        ll.insertNode(3);
        ll.insertNode(4);
        ll.insertNode(25);
        ll.insertNode(25);

        ll.printLinkedList(ll.head);

        ll.removeDuplicate(ll.head);

        ll.printLinkedList(ll.head);

        
    }
    
}

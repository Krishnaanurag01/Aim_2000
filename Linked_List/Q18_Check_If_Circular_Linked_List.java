package Linked_List;

public class Q18_Check_If_Circular_Linked_List {
    
    node head ;
    public static class node {

        int data ;
        node next; 

        public node(int d){
            data = d ;
            next = null ;
        }        
    }


    public static void printLinkedList(node head) {

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

    public static boolean isCircular(node head) {

        if(head == null || head.next == null){
            return false;
        }

        node dummy = head;

        while (dummy != null ) {
            dummy = dummy.next ; // just moving forward and checking if dummy node is equals to head,if yes then it is circular.
            if( dummy == head){
                return true;
            }
        }

        return false;
    }


    public static void main(String[] args) {

        Q18_Check_If_Circular_Linked_List ll = new Q18_Check_If_Circular_Linked_List();

        ll.head = new node(1);
        ll.head.next = ll.head;
        // ll.head.next = new node(2);
        // ll.head.next.next = new node(3);
        // ll.head.next.next.next = new node(4);
        // ll.head.next.next.next.next = new node(5);
        // ll.head.next.next.next.next.next = ll.head ;

       System.out.println(isCircular(ll.head)) ;

        
    }
}

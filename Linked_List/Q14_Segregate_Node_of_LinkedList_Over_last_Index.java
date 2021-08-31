package Linked_List;

public class Q14_Segregate_Node_of_LinkedList_Over_last_Index {
    
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




    // solution starts :-

    public static node getTail(node head) {
        if(head == null || head.next == null ){
            return head;
        }

        node tail = head;

        while (tail.next != null) {
            tail = tail.next ;
        }

        return tail;
    }

    public static node segregate_list_over_last_index(node head) {
        if(head == null || head.next == null){
            return head;
        }

        node tail = getTail(head) ;  // for segregating over last index. first find the last node of the linked list.

        node previous_smaller_head = new node(-1);             /// this will help in linking the  smaller or equal nodes .
        node previous_smaller = previous_smaller_head ;        // and this will be the pointer for smaller head.

        node previous_larger_head = new node(-1);              // this is for larger parts.
        node previous_larger = previous_larger_head ;

        node current = head;  // now taking dummy and traversing through list.

        while (current != null) {
            if(current.data <= tail.data ){
                previous_smaller.next = current;   // if data is smaller than tail data or equals then add it to smaller ll. and same for larger ll.
                previous_smaller = previous_smaller.next;
            }
            else{
                previous_larger.next = current;
                previous_larger = previous_larger.next;
            }

            current = current.next;
        }

        previous_smaller.next = previous_larger_head.next; /// here connecting the smaller parts and larger parts.
        previous_larger.next = null; // if we do not do this then it will take dummy data of last node which is not even larger



        return previous_smaller_head.next; // then sending the starting of smaller ll.
    }













    public static void main(String[] args) {

        Q14_Segregate_Node_of_LinkedList_Over_last_Index ll =new Q14_Segregate_Node_of_LinkedList_Over_last_Index();

        ll.insertNode(4);
        ll.insertNode(2);
        ll.insertNode(6);
        ll.insertNode(5);
        ll.insertNode(9);
        ll.insertNode(1);
        ll.insertNode(-3);
        ll.insertNode(-5);
        ll.insertNode(3);

        node pivort = segregate_list_over_last_index(ll.head);
        // System.out.println(pivort.data);

        printLinkedList(pivort);
    }
}

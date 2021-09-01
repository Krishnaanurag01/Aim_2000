package Linked_List;


public class Q21_Deletion_from_a_Circular_Linked_List {

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
            if(printIt == head) break;
        }

        System.out.println();
    }

    public  void insertNode(int d) {
        node newNode = new node(d);
        if(head == null){
            head = newNode ;
            head.next = newNode;
            return;
        }

        node temp = head;

        while (temp.next !=  head) {
            temp = temp.next;            
        }
        
        temp.next = newNode;
        newNode.next = head ;
        
    }


    public static void deleteNode(node head , int data) {
        if( head == null ){
            return;
        }

        node dummy = head ;
        node prev = null;

        while (dummy.data != data) {
           
            if(dummy.next == head){ // when not present.
                System.out.println("not found");
                break;
            }
            prev = dummy ; 
            dummy = dummy.next ;

            
        }

        if( dummy == head && dummy.next == head){  // when data is in head and only one node present.
            head = null ; // make it null and return.
            return ;
        }

        if( dummy == head ){ // if it is the first node and more than one node present.
            prev = head ;
            while(prev.next != head){
                prev = prev.next ;
            }
            // then we come to last node and link it with the 2nd node.
            head = dummy.next ; // head becomes 2nd node
            prev.next = head ; // last node is connected with 2nd node.
        }
        else if( dummy.next == head ){ // when node is the last node.
            prev.next = head ; // then connect previous with head.
        }
        else{ // when node found in middle then make prev node connected with next node.
            prev.next = dummy.next ;
        }
        return;

    }


    public static void main(String[] args) {

        Q21_Deletion_from_a_Circular_Linked_List ll = new Q21_Deletion_from_a_Circular_Linked_List();

        ll.insertNode(5);
        ll.insertNode(6);
        ll.insertNode(7);
        ll.insertNode(8);

    deleteNode(ll.head, 7);


        printLinkedList(ll.head);
    }


    
}

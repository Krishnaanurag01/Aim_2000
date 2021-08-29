package Linked_List;

public class Q3_Detect_Loop_in_linked_list {

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


    // main function.

    public static void main(String args[]) {

        Q3_Detect_Loop_in_linked_list ll = new Q3_Detect_Loop_in_linked_list();

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

       ll.head.next.next.next.next.next = third ;

       
        
       System.out.println(detect_loop_LL(ll.head)) ;
    }

    // ********* This algorithm is known as Floyd's Cycle detection algorithm and (hare and tortoise algorithm) ,also this algorithm is import from interview point of view.

    private static boolean detect_loop_LL(node head2) {
        if(head2 == null){
            return false;
        }

        node tortoise = head2;
        node hare = head2;

        while (hare != null && hare.next != null) { // here adding hare.next != null condition because in the loop we are trying to access the hare.next.next which gives null pointer exceptions without this condition.
            tortoise = tortoise.next ;
            hare = hare.next.next;

            if( hare == tortoise){
                return true;
            }
        }


        return false;

    }






























    
}

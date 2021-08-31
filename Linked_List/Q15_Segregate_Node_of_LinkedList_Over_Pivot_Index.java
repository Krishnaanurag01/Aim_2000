package Linked_List;



/**
 * Q15_Segregate_Node_of_LinkedList_Over_Pivot_Index
 */
public class Q15_Segregate_Node_of_LinkedList_Over_Pivot_Index {

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

    public static node segregate_node_over_pivot_index(node head , int pivotIndex) {

        if(head == null || head.next == null ){
            return head;
        }
 
        node pivotNode = head; 

        while (pivotIndex-- > 0) {   // this loop will find the  pivot node.
            pivotNode = pivotNode.next;
        }
         
        // now just simply make the smaller and larger list adn their pointers.
        node previous_smaller_head = new node(-1);
        node previous_smaller = previous_smaller_head;

        node previous_larger_head = new node(-1);
        node previous_larger = previous_larger_head;


        node current = head; // now  traverse through the head and partition it.
        

        while(current != null){
            if(current != pivotNode){
                if( current.data <= pivotNode.data){
                    previous_smaller.next = current;
                    previous_smaller = previous_smaller.next ;
                }
                else {
    
                    previous_larger.next = current ;
                    previous_larger = previous_larger.next ;
                }
            }
            
            
            current = current.next ;
        }

        previous_smaller.next= pivotNode;  // smalller list + pivot node + larger node.
        pivotNode.next = previous_larger_head.next;
        previous_larger.next = null; 












        return previous_smaller_head.next;
    }


    public static void main(String[] args) {

        Q15_Segregate_Node_of_LinkedList_Over_Pivot_Index ll = new Q15_Segregate_Node_of_LinkedList_Over_Pivot_Index();

        ll.insertNode(4);
        ll.insertNode(3);
        ll.insertNode(1);
        ll.insertNode(-5);
        ll.insertNode(3);
        ll.insertNode(6);
        ll.insertNode(5);
        ll.insertNode(8);
        ll.insertNode(2);
        ll.insertNode(6);

        node newhead = segregate_node_over_pivot_index(ll.head, 4);

        printLinkedList(newhead);
        
    }
}
package Linked_List;

public class Q10_Add_two_numbers_represented_by_linked_lists {
    
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


    public static node add_two_list(node ll1_head , node ll2_head) {

        // when any of the list is empty then return it.

        if(ll1_head == null || ll2_head == null){
           return ll1_head==null?ll2_head:ll1_head ;
        }

        // reverse the both lists.
        node c1 = reverse_list(ll1_head);
        node c2 = reverse_list(ll2_head);

        int sum = 0 ;
        int carry = 0 ;

        // form a new node.
        node head = new node(-1);
        node itr = head; 

       while (c1 != null || c2 !=null || carry != 0 ) {
           // find sum .
           sum = carry + (c1!= null? c1.data : 0 ) + (c2!= null? c2.data : 0 );
           int lastDigit = sum%10 ;
           carry = sum/10 ;


           // make a node of the last digit and connect it with the new list and send carry ahead.

           itr.next = new node(lastDigit);
           itr = itr.next;

           if(c1 != null) c1 = c1.next; // finding next node here
           if(c2 != null) c2 = c2.next;

       }

       /// here reversing from the second node becuase the first node we made is dummy and have value of -1 which is of no use.
       return reverse_list(head.next);
        
    }

    public static node reverse_list(node head) {
        
        if(head == null){
            return null;
        }

        node current = head;
        node forward = null;
        node prev = null;

        while(current != null){
            forward = current.next;
            current.next = prev ;
            prev = current;
            current = forward;
        }

        return prev;
    }








    public static void main(String[] args) {
        Q10_Add_two_numbers_represented_by_linked_lists ll1 = new Q10_Add_two_numbers_represented_by_linked_lists();
        Q10_Add_two_numbers_represented_by_linked_lists ll2 = new Q10_Add_two_numbers_represented_by_linked_lists();


        ll1.insertNode(5);
        ll1.insertNode(9);

        ll2.insertNode(9);
        ll2.insertNode(5);

        // algorithm will be :
        // 1. reverse both list
        // 2. start adding data of both list node and find carry and last digit of sum.
        // 3. last digit will formed a node and add it to the new list. and send carry ahead.


       node newnode =  add_two_list(ll1.head, ll2.head);

       printLinkedList(newnode);
    }
}

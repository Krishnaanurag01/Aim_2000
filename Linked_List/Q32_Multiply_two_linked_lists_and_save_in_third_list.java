package Linked_List;


public class Q32_Multiply_two_linked_lists_and_save_in_third_list {

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

    // method - 01  but not actual the code we have asked to.

    // public static long multiple_two_ll(Node l1 , Node l2) {

    //     if( l1== null || l2 == null){
    //         return 0;
    //     }
    
    //     StringBuilder sb1 = new StringBuilder();
    //     StringBuilder sb2 = new StringBuilder();

    //     Node c1 = l1;
    //     Node c2 = l2 ;

    //     while (c1 != null) {
    //         sb1.append(c1.data);
    //         c1 = c1.next ;
    //     }

    //     while (c2 != null) {
    //         sb2.append(c2.data);
    //         c2 = c2.next ;
    //     }



    //     long res = Integer.parseInt(sb1.toString()) * Integer.parseInt(sb2.toString());


    //     return res ;
    // }

    
    public static void main(String[] args) {

        Q32_Multiply_two_linked_lists_and_save_in_third_list ll =new Q32_Multiply_two_linked_lists_and_save_in_third_list();

        ll.insertNode(1);
        ll.insertNode(3);

        Q32_Multiply_two_linked_lists_and_save_in_third_list ll2 = new Q32_Multiply_two_linked_lists_and_save_in_third_list();

        ll2.insertNode(2);
        ll2.insertNode(2);
     


      Node res = multiplyNumbers(ll.head, ll2.head);

      ll.printLinkedList(res);
        
    }


    public static Node reveseList(Node tempHead) {
        
        if(tempHead == null || tempHead.next == null){
            return tempHead;
        }

        Node current = tempHead;
        Node prev = null;

        while (current != null) {
            Node forward = current.next ;
            current.next = prev ;
            prev = current;
            current = forward ;

        }

        return prev;
    }


    public static Node multiplyList_with_digit(Node listHead , int digit) {
        

        Node dummy = new Node(-1) ;  // this will be the head of the new list after multiplication.
        Node ptr = dummy ; 

        Node curr = listHead ;

        int carry = 0 ;

        while (curr != null || carry != 0) {
            int sum = carry + ( curr != null ? curr.data * digit : 0 );  // we multiply with logic of : carry + current number * multiplier.

            int lastDigit = sum % 10 ;
            carry =  sum/10 ;

            ptr.next = new Node(lastDigit);
            ptr = ptr.next ;

            if(curr != null) curr = curr.next ;

        }
        return dummy.next  ;
    }




    public static Node multiplyNumbers(Node listHead1 , Node listHead2) {
        // if(listHead1 == null || listHead2 == null){
        //     return null ;
        // }

        Node ll1_reversed = reveseList(listHead1);   // first reverse both list so that we can access prev node.
        Node ll2_reversed = reveseList(listHead2);


        Node newHead = new Node(-1) ;   // making dummy node for answer.
        Node prev =  newHead ;

        Node curr = ll2_reversed ;

        while (curr != null ) {
            Node product = multiplyList_with_digit(ll1_reversed, curr.data); // now take the first list and multiply with each node of list 2.

            addTwoList(product, prev); // now add with answer which we stored in newhead .
            prev = prev.next; // here doing this because when we add in multiplication we skip the right most number every time. ( think of it as new head is prev sum and you have to add new sum which we got from multiplying new value.)

            curr = curr.next ; // move to next node.
        }


        return reveseList(newHead.next) ;
    }

    private static void addTwoList(Node product, Node ptr) {
        Node c1 = ptr ;
        Node c2 = product ;

        int carry = 0;

        while(  c2 != null || carry != 0){  // loop will also run if any carry left ,
            int sum = carry + (c1.next != null ? c1.next.data : 0 )+ (c2 != null ? c2.data : 0) ;   // here we are adding next of ptr with current product node beause we skip the last number every  time in summation.

            int digit = sum%10 ;
            carry = sum/10 ;

            if(c1.next !=null) c1.next.data = digit; // now if ptr next already has some value then exchange with new value o\w create a newnode.
            else{
                c1.next = new Node(digit);
            }

            c1 = c1.next ; // moving to next place of ptr.
            if(c2 != null) c2 = c2.next; // if product list becomes null then don't point ahead o\w you'll get exception.
        }
    }
}

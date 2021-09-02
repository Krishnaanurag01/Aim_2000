package Linked_List;

/**
 * Q29Given_a_linked_list_of_0s_1s_and_2s_sort_it
 */
public class Q29Given_a_linked_list_of_0s_1s_and_2s_sort_it {

    static Node head ;
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


    public static Node sort_it(Node tempHead) {
        if(tempHead == null || tempHead.next == null){
            return tempHead;
        }

        Node zeros_head = new Node(-1);
        Node ptr1 = zeros_head;

        Node ones_head = new Node(-1);
        Node ptr2 = ones_head;

        Node twos_head = new Node(-1);
        Node ptr3 = twos_head;


        Node temp = tempHead;

        while (temp != null ) {
            if(temp.data == 0){
                ptr1.next = temp;
                ptr1 = ptr1.next;
            }
            else if(temp.data == 1){
                ptr2.next = temp ;
                ptr2 = ptr2.next;
            }
            else{
                ptr3.next = temp;
                ptr3 = ptr3.next;
            }

            temp = temp.next;
        }

        if(zeros_head.next !=null && ones_head.next != null&& twos_head.next !=null){

        tempHead = zeros_head.next;
        ptr1.next = ones_head.next;
        ptr2.next = twos_head.next;
        ptr3.next=null;

        }else if(ones_head.next != null&& twos_head.next !=null){
            tempHead = ones_head.next;
            ptr2.next = twos_head.next;
            ptr3.next=null;
        }else if(zeros_head.next !=null && ones_head.next != null){
            tempHead = zeros_head.next;
            ptr1.next = ones_head.next;
            ptr2.next=null;
        }
        else{
        tempHead = zeros_head.next;
        ptr1.next = twos_head.next;
        ptr2.next=null;
        }
        



        return tempHead;
    }


    // better and optimized version : o(n) time and o(1) space.

    public static Node sortIt(Node tempHead) {
        if(tempHead == null || tempHead.next == null){
            return tempHead;
        }

        int count[] = {0,0,0}; // this will count the total 0s, 1s, 2s .

        Node dummy = tempHead ;
        while (dummy != null) {
            count[dummy.data]++; // if data is 0 then count[0] will increase.
            dummy = dummy.next;
        }

         dummy = tempHead ; // now taking a dummy node;
        int i = 0;

        while ( dummy != null) {
            if(count[i] == 0){
                i++;
            }
            else{
                dummy.data = i;
                --count[i];
                dummy = dummy.next;
            }
        }



        return tempHead;

    }



    public static void main(String[] args) {

        Q29Given_a_linked_list_of_0s_1s_and_2s_sort_it ll = new Q29Given_a_linked_list_of_0s_1s_and_2s_sort_it();

        ll.insertNode(1);
        ll.insertNode(2);
        ll.insertNode(0);
        ll.insertNode(0);
        ll.insertNode(1);
        ll.insertNode(2);
        ll.insertNode(0);
        ll.insertNode(1);
        ll.insertNode(2);

       Node temp =  sortIt(ll.head);

        ll.printLinkedList(temp);
        
    }
}

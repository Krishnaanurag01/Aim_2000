package Linked_List;


public class Q33_multiply_two_linked_list {
    
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

    public static long multiply_two_list(Node l1 , Node l2) {
        
        long num1 = 0 ;
        long num2 = 0 ;
        long mod = 1000000007 ;  // as number  could be very large so it is given in questio to use modulo of this number so that we won't get any error.


        Node cur1 = l1 ;
        Node cur2 = l2 ;

        while (cur1 != null) {   /// this is nothing but join all the number and store it in num1 and num 2 . for ex : assume ll is : 
            //                         // 1->2 -> 3 so it will store 123 in num1 and same for num2
             num1 = (num1*10 + cur1.data)%mod ;
            cur1 = cur1.next;
        }

        while (cur2 != null) {
            num2 = (num2*10 + cur2.data)%mod ;
            cur2 = cur2.next;
        }


        return (num1 * num2)%mod ;
    }





    public static void main(String[] args) {

        Q33_multiply_two_linked_list ll1 = new Q33_multiply_two_linked_list();
        Q33_multiply_two_linked_list ll2 = new Q33_multiply_two_linked_list();

        ll1.insertNode(3);
        ll1.insertNode(3);
        ll1.insertNode(3);
        ll1.insertNode(3);
        ll1.insertNode(3);

        ll2.insertNode(2);
        ll2.insertNode(2);
        ll2.insertNode(2);

       System.out.println( multiply_two_list(ll1.head, ll2.head ));
        
    }
}

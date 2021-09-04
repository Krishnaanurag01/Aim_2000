package Linked_List;

public class Q37_Nth_node_from_end_of_linked_list {

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


    public static Node reverse_it(Node listHead) {
        if(listHead == null || listHead.next == null ){
            return listHead ;
        }

        Node curr = listHead ;
        Node forward = null ;
        Node prev = null ;

        while (curr != null) {
            forward = curr.next ;
            curr.next = prev ;
            prev = curr ;
            curr = forward ;
        }

        return prev;
    }

    public static int get_Nth_number_from_last(Node listHead , int N) {
        
        if(listHead == null){
            return 0 ;
        }

        listHead = reverse_it(listHead);
        Node curr = listHead ; // we simply reversed the list and moved to the nth node.

        int ans = 0 ;


        while (--N > 0 && curr != null) {  // when N has value greater than -1 then it means we didn't reached the specific node then return -1 o\w return ans.
            ans = curr.data ;
            curr = curr.next ;

        }

        // if(N > 0){
        //     return -1;
        // }


        return N > -1 ? -1 : ans ;
    }


    // single traversal method:

    public static int nth_node_from_end(Node head ,int N) {
        if(head == null){
            return -1;
        }

        Node slow= head;
        Node fast = head ;
 // in this method ; first move fast pointer to N times and then move both pointers 1 step.
        for (int i = 0; i < N; i++) {  // we are using two loops but stills its count one traversal becuase the conditon of fast pointer. // In the fast loop fast pointer already traverse some distance and we are traversing the next distance from current in 2nd loop so we only traverse every node once .
            fast = fast.next;
        }

        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }

        return slow.data;
    }









    public static void main(String[] args) {

        Q37_Nth_node_from_end_of_linked_list ll = new Q37_Nth_node_from_end_of_linked_list();

        ll.insertNode(2);
        ll.insertNode(3);
        ll.insertNode(4);
        ll.insertNode(5);
        ll.insertNode(6);
        ll.insertNode(7);
        ll.insertNode(8);
        ll.insertNode(12);
        ll.insertNode(19);

        // System.out.println(get_Nth_number_from_last(ll.head, 10));

        System.out.println(nth_node_from_end(ll.head, 2));
        
    }
    
}

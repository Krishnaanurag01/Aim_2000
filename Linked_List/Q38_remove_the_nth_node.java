package Linked_List;

public class Q38_remove_the_nth_node {
    
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



    public static Node remove_the_nth_node(Node listHead,int N) {

       Node newHead = new Node(-1);
       newHead.next = listHead;

       Node slow = newHead; // In start they will point to dummy node.
       Node fast = newHead;

       for (int i = 0; i < N; i++) { // first move fast pointer to K steps
           fast = fast.next;
       }

       while (fast.next != null) { // now continue moving 1 step for both slow and fast.
           fast = fast.next;
           slow = slow.next;
       }

       slow.next = slow.next.next ;

        return newHead ;
    }



    public static void main(String[] args) {

        Q38_remove_the_nth_node ll = new Q38_remove_the_nth_node();

        ll.insertNode(2);
        ll.insertNode(3);
        ll.insertNode(4);
        ll.insertNode(5);
        ll.insertNode(6);
        ll.insertNode(7);
        ll.insertNode(8);
        ll.insertNode(12);
        ll.insertNode(19);

        Node head = remove_the_nth_node(ll.head, 1);

        ll.printLinkedList(head);

        
    }
}

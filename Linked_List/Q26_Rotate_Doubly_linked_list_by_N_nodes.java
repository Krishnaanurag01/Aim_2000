package Linked_List;

public class Q26_Rotate_Doubly_linked_list_by_N_nodes {
    
    static class Node{

        char data;
        Node next;
        Node prev ;

        public Node(char d){
            data = d ;
            next = null ;
            prev = null ;
        }
    }

   static Node head ;

    public static void insertNode(char data) {
        Node newNode = new Node(data);

        if(head == null){
            head = newNode ;
            return;
        }

        Node current = head;

        while (current.next != null) {
            current = current.next ;
        }

        current.next = newNode;
        newNode.prev = current ;
    }


    public static void print_Doubly_List(Node head) {
        if(head == null){
            System.out.println("Empty list!");
            return;
        }

        Node current = head ;
        while (current != null ) {
            System.out.print(current.data+" -> ");
            current = current.next;
        }

    }


    // same logic as Q26 for both singly and doubly ll.
    // time comp : o(n) {finding length} + o(n-(n-N%n)) => overall would be o(n).
    // and space is : o(1)
    public static Node rotate_list_by_N(Node listHead , int N) {
        
        if(listHead == null || listHead.next == null || N==0){
            return listHead;
        }

        // first finding the length.
        Node current = listHead;
        int length = 1 ;

        while (current.next != null) {
            length++;
            current = current.next;
        }

        current.next = listHead;

        int final_rotation = N % length ;
        // N = length - final_rotation ; as we have to rotate left so don't have to do this.

        while (final_rotation -- > 0) {
            current = current.next ;
        }

        listHead = current.next;
        current.next = null;


        return listHead;
    }
















    public static void main(String[] args) {

        insertNode('a');
        insertNode('b');
        insertNode('c');
        insertNode('d');
        insertNode('e');

      Node newHead = rotate_list_by_N(head, 2);

      print_Doubly_List(newHead);

        
    }
}

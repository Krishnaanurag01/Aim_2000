package Linked_List;


public class Q23_Find_pairs_with_given_sum_in_doubly_linked_list {

    static class Node{

        int data;
        Node next;
        Node prev ;

        public Node(int d){
            data = d ;
            next = null ;
            prev = null ;
        }
    }

   static Node head ;

    public static void insertNode(int data) {
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

    public static void pairs_with_Given_sum(Node head , int k) {
        if(head == null || head.next == null){
            System.out.print("You're Broke man.");
        }

        Node lastNode = head ;
        Node startNode = head;

        while (lastNode.next != null) {
            lastNode = lastNode.next;
        }


        // while ( startNode != lastNode  && lastNode.next != startNode)  {

            while(startNode != null && lastNode != null && startNode != lastNode){
            int sum = startNode.data + lastNode.data;
            if( sum == k){
                System.out.println("Pair : ( "+startNode.data+","+lastNode.data+" )");
                startNode = startNode.next;
                lastNode = lastNode.prev;
            }
            else if( startNode.data + lastNode.data < k ){
                startNode = startNode.next;
            }
            else{
                lastNode = lastNode.prev;
            }
        }
    }
















    public static void main(String[] args) {

        insertNode(1);
        insertNode(2);
        insertNode(4);
        insertNode(5);
        insertNode(6);
        insertNode(8);
        insertNode(9);
     

        // print_Doubly_List(head);

        pairs_with_Given_sum(head, 7);
        
    }
}

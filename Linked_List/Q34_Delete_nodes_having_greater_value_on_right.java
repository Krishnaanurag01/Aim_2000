package Linked_List;


public class Q34_Delete_nodes_having_greater_value_on_right {

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

    public static Node delete_Node_whose_right_is_larger(Node listHead) {
        if(listHead == null || listHead.next == null){
            return listHead;
        }

        Node curr = listHead ;
        Node newHead = new Node(-1);
        Node ptr = newHead;

        while (curr.next != null) {
            Node forward = curr.next ;
            if(curr.data < curr.next.data){
                ptr.next = curr.next;
                ptr = ptr.next ;
            }
            
                curr = forward ;
            
        }

        return newHead.next;

        
    }
    public static void main(String[] args) {

        Q34_Delete_nodes_having_greater_value_on_right ll =new Q34_Delete_nodes_having_greater_value_on_right() ;
        

        ll.insertNode(12);
        ll.insertNode(15);
        ll.insertNode(10);
        ll.insertNode(11);
        ll.insertNode(5);
        ll.insertNode(6);
        ll.insertNode(2);
        ll.insertNode(3);

        Node node = delete_Node_whose_right_is_larger(ll.head);

        ll.printLinkedList(node);


        
    }
    
}

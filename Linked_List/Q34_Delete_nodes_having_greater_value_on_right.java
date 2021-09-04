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


    public static Node reverse(Node head) {
        if(head == null || head.next == null){
            return head ;
        }

        Node current = head ;
        Node prev = null;

        while (current != null) {
            Node forwaNode = current.next;
            current.next = prev ; 
            prev = current ;
            current = forwaNode ;
        }

        return prev ;

    }



    // if you search from left side then it will give wrong answer becuase we have to find the largest number in whole right side.
    // so we reverse the list and keep track of largest number, whenever we found any larger number than current larger then we will add it to the anser list.
    
    
    // time comp : o(n) and o(1) space.


    public static Node delete_Node_whose_right_is_larger(Node listHead) {
        if(listHead == null || listHead.next == null){
            return listHead;
        }

        Node curr = reverse(listHead) ;
        int max = 0 ;

        Node newHead = new Node(-1);
        Node ptr = newHead;
        

        while (curr != null) {
            if(curr.data > max){
                max = curr.data ;
                ptr.next = curr ;
                ptr = ptr.next;
            }

            curr = curr.next ;
            
        }
    ptr.next = null ;

        return reverse(newHead.next);

        
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

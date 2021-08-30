package Linked_List;

public class Q8_Move_last_element_to_front_of_a_given_Linked_List {
    
    node head ;
    public static class node {

        int data ;
        node next; 

        public node(int d){
            data = d ;
            next = null ;
        }        
    }


    public void printLinkedList(node head) {

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







    public static void main(String[] args) {
        
        Q8_Move_last_element_to_front_of_a_given_Linked_List ll = new Q8_Move_last_element_to_front_of_a_given_Linked_List();

        ll.insertNode(1);
        ll.insertNode(2);
        ll.insertNode(3);
        ll.insertNode(4);
        ll.insertNode(5);
        




       node head2 = moveLastNode_To_First(ll.head);
        ll.printLinkedList(head2);
    }

    private static node moveLastNode_To_First(node head2) {

        if(head2 == null || head2.next == null){
            return head2;
        }

        node current = head2 ;

        while (current.next.next!= null) {
            current = current.next;
        }

        node lastNode = current.next ;
        current.next = null;

        lastNode.next =  head2 ;
        head2 = lastNode ;

        return head2 ;
    }
}

package Problem_Of_The_day;

public class Q253_MoveLast_Element_to_Front_of_a_Linked_List {

    public static Node moveToFront(Node head) {
       
        if(head == null || head.next == null) return head ;
        
        Node temp = head ;
        Node curr = head ;
        
        while(curr.next.next != null){
            curr = curr.next ;
        }
        
        head = curr.next ;
        curr.next = null ;
        head.next = temp ;
        return head ;
    }

     class Node{
        int data ;
        Node next ;
     }
}

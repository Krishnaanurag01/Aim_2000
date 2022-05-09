package Linked_List;

public class Q41_Merge_two_sorted_linked_lists {

    class Node
    {
        int data;
        Node next;
        Node(int d) {data = d; next = null; }
    }

    Node sortedMerge(Node head1, Node head2) {
     
        Node newHead = new Node(-1) ;
        Node ptr = newHead ;
        
        Node curr1 = head1 ;
        Node curr2 = head2 ;
        
        while(curr1 != null && curr2 != null){
            
            if(curr1.data < curr2.data){
                ptr.next = curr1 ;
                ptr = ptr.next ;
                curr1 = curr1.next ;
            }
            else{
                ptr.next = curr2 ;
                ptr = ptr.next ;
                curr2 = curr2.next ;
            }
        }
        
        if(curr1 != null)
        ptr.next = curr1 ;
        
        if(curr2 != null)
        ptr.next = curr2 ;
        
        
        return newHead.next ;
      }
}

package Problem_Of_The_day;

public class Q152_Remove_Linked_List_Elements {

    class ListNode{
        int val ;
        ListNode next ;

        ListNode(int x){
            val = x ;
        }
    }

    public ListNode removeElements(ListNode head, int val) {
        
        ListNode nhead = new ListNode(-1) ;
        ListNode ptr = nhead ;
        
        ListNode curr = head ;
        while(curr != null){
            if(curr.val != val){
                ptr.next = curr ;
                ptr = ptr.next ;
            }
            curr = curr.next ;
        }
        
        ptr.next = null ;
     
        return nhead.next;
    }
}

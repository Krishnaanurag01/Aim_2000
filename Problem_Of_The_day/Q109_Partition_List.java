package Problem_Of_The_day;

public class Q109_Partition_List {

    class ListNode{
        int val ;
        ListNode next ;
        ListNode(int x){
            val = x ;
        }
    }

    public ListNode partition(ListNode head, int x) {
        
        ListNode smaller = new ListNode(-1) ; // taking smaller element in one side
        ListNode ptr1 = smaller ;
        
        ListNode larger = new ListNode(-1) ; // andd larger side in this side
        ListNode ptr2 = larger ;
        
        ListNode curr = head ;
        
        while(curr != null){
            if(curr.val < x){
                ptr1.next = curr;
                ptr1 = ptr1.next ;
            }
            else{
                 ptr2.next = curr;
                ptr2 = ptr2.next ;
            }
            curr = curr.next ;
        }

        // now connecting smaller with larger.
        
        if(smaller.next == null) return larger.next ;
        ptr1.next = larger.next != null ? larger.next : null ;
        ptr2.next = null ;
        return smaller.next ;
    }
}

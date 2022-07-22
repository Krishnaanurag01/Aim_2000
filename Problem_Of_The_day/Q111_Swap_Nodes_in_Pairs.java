package Problem_Of_The_day;
public class Q111_Swap_Nodes_in_Pairs {

    class ListNode{
        int val ;
        ListNode next ;
        ListNode(int x){
            val = x ;
        }
    }

    // Approch 01 : Iterative.
    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null) return head ;
        
        ListNode prev = null ; // holds previous node
        ListNode sprev = null ; // second previos node
        ListNode nhead = new ListNode(-1) ;
        ListNode bkp = nhead ; // pointer for last location of pair
        ListNode curr = head ; 
        int pos = 1 ;
        
        while(curr != null){
            if(pos == 3){ // means previous two nodes are present.
                sprev.next = curr ; // second prev next becomes curr
                prev.next = sprev; // and connecting prev next with second prev
                bkp.next = prev ;  // assign this swapped pair to next of last pair
                bkp = sprev ; // backing up the last node of swapped pair
                pos = 1 ;
            }
            
            sprev = prev ;
            prev = curr ;
            curr = curr.next ;
            pos++ ;
        }
        
        // same as above under the loop
        if(pos == 3){
           sprev.next = curr ;
           prev.next = sprev;
           bkp.next = prev ;
           bkp = sprev ;
           pos = 1 ;
         }   
        // else if pos not become 3 then still our linkedlist contains the left out element at corrent position
        
         return nhead.next;
    }



    //Approch 2 : Recursive

    public ListNode swapPairs2(ListNode head) {
        if(head == null || head.next == null) return head ;
        
         return helper(head);
    }
    
    ListNode helper(ListNode head){
        if(head == null || head.next == null) return head ;
        
        ListNode curr = head ;
        ListNode next = head.next ;
        
        curr.next = helper(next.next); // assigning next's next to curr next
        next.next = curr ; // and making next first node and it's next node to curr
        return next ;
    }
}

package Problem_Of_The_day ;

public class Q176_Add_Two_Numbers_II {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        
        // just reverse the LL and then add it.
        ListNode curr1 = getReverse(l1) ;
        ListNode curr2 = getReverse(l2) ;
        ListNode newHead = new ListNode(-1) ;
        ListNode ptr = newHead ;

        int carry = 0 ;

        while (curr1 != null || curr2 != null || carry != 0 ) {
            
            int sum =  carry + ( curr1 != null ? curr1.val : 0  ) + ( curr2 != null ? curr2.val : 0 ) ;
            
            if(sum < 10){
                ptr.next = new ListNode(sum) ;
                carry = 0 ;
            }
            else{
                ptr.next = new ListNode(sum%10) ;
                carry = sum/10  ;
            }

            ptr = ptr.next ;


            curr1 = curr1 != null ? curr1.next : curr1 ;
            curr2 = curr2 != null ? curr2.next : curr2 ;
        }

        // also now return the reverse of LL
        return getReverse(newHead.next);
    }
    
    ListNode getReverse(ListNode node){
        if(node == null || node.next == null) return node ;
        
        ListNode prev = null ;
        
        ListNode curr = node;
        while(curr != null){
            ListNode bkp = curr.next;
            curr.next = prev ;
            prev = curr ;
            curr = bkp ;
        }
        
        return prev;
    }
}
 class ListNode {
     int val;
     ListNode next;
     ListNode() {}
     ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }

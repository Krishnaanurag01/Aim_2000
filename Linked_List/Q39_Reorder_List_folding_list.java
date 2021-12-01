package Linked_List;

public class Q39_Reorder_List_folding_list {

    static class ListNode {
        int val ; 
        ListNode next ;

        ListNode(int val){
            this.val = val ;
            next = null ;
        }
        
    }

    public static ListNode getMid(ListNode head) {
        
        if(head == null || head.next == null) return head ;

        ListNode slow = head ;
        ListNode fast = head ;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next ;
            fast = fast.next.next ;
        }

        return slow ;
    }

    public static ListNode reverseList(ListNode head) {

        if(head == null || head.next == null) return head ;

        ListNode current  = head ;
        ListNode prev = null ;
        ListNode forward = null ;

        while (current != null) {
            forward = current.next ;
            current.next = prev ;
            prev = current ;
            current = forward ;
        }

        return prev ;
        
    }



    static ListNode reorderlist(ListNode head) {
        // Your code here

        if(head == null || head.next == null) return head ;
        
        ListNode mid = getMid(head) ;// finding mid
        ListNode secondHead = reverseList(mid.next) ; // partitioning into second list from mid next and making it reverse
        mid.next = null ;


        ListNode c1 = head ; 
        ListNode c2 = secondHead ;
        ListNode f1 = null ;
        ListNode f2 = null ;

        // if we have even length list then both list one and list two will be of same size but if the list is of odd length then list one will be bigger and list two will be smaller.

        while (c2 != null) {
            
            // backing up.
            f1 = c1.next ;
            f2 = c2.next ;

            // folding the list

            c1.next = c2 ;
            c2.next = f1 ;

            // now updating current.

            c1 = f1 ;
            c2 = f2 ;
        }



        return head ;

    }
}

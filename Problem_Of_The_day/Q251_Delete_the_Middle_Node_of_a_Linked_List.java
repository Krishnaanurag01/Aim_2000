package Problem_Of_The_day;

/**
 * Q251_Delete_the_Middle_Node_of_a_Linked_List
 */
public class Q251_Delete_the_Middle_Node_of_a_Linked_List {

    public ListNode deleteMiddle(ListNode head) {
        
        if(head == null || head.next == null) return null ; // base condition when ll is of only 1 length
        
        ListNode prev = head ; // keeping prev in order to eliminate the slow( that is mid after loop)
        ListNode slow = head ;
        ListNode fast = head ;
        
        while(fast != null && fast.next != null){
            prev = slow ;
            slow = slow.next ;
            fast = fast.next.next ;
        }
        
        if(slow == fast){ // if both are same means loop didn't run so it means it is of 2 length as we have already managed the 1 length.
            slow.next = null ;
            return slow;
        }
        
        prev.next = slow.next ;
     
        return head ;
    }
}
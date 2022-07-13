package Linked_List;

public class Q42_Remove_Duplicates_from_Sorted_List_II {

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    
    public ListNode deleteDuplicates(ListNode head){
        if(head == null || head.next == null) return head ;
        
        ListNode dummy = new ListNode(-1) ;
        ListNode itr = dummy ;
        itr.next = head ; // potential next node
        
        ListNode curr = head.next ;
        while(curr != null){
            boolean flag = false ;
            while(curr != null && itr.next.val == curr.val){
                flag = true ;
                curr = curr.next ;
            }
            
            if(flag) itr.next = curr ; // means potential node is duplicate so now try curr as new potential node
            else itr = itr.next ; // else add current node and try next for duplicacy
            if(curr != null) curr = curr.next ;
        }
        
        return dummy.next ;
    }
}

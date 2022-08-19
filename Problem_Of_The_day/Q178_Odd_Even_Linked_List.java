package Problem_Of_The_day;

public class Q178_Odd_Even_Linked_List {

    
    public ListNode oddEvenList(ListNode head) {
        return segregate_over_odd_even(head);
    }
    public static ListNode segregate_over_odd_even(ListNode listHead) {
        
        if(listHead == null || listHead.next == null){
            return listHead;
        }

        ListNode evenHead = new ListNode(-1);
        ListNode ptr1 = evenHead ;

        ListNode oddHead = new ListNode(-1);
        ListNode ptr2 = oddHead ;

        ListNode curr = listHead;
        
        int i = 0 ;
        while (curr != null) {
            if(i % 2 == 0){
                ptr1.next = curr ;
                ptr1 = ptr1.next ;
            }
            else{
                ptr2.next = curr;
                ptr2 = ptr2.next;
            }
            curr = curr.next ;
            i++ ;
        }
        
        oddHead = oddHead.next ;
        evenHead = evenHead.next ;
        
        if(evenHead == null) return oddHead ;
        if(oddHead == null) return evenHead ;
        
        
       
           
        ptr1.next = oddHead;
        ptr2.next = null;
        return evenHead ;
    }
}

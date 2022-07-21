package Problem_Of_The_day;

public class Q105_Reverse_Linked_List_II {


  public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }


    public ListNode reverseBetween(ListNode head, int left, int right) {
        
        if(head == null || head.next == null) return head ;
        
        ListNode curr = head ;
        ListNode rightNext= null ; // rightnext pointer.
        ListNode leftPrev = null ; // left's previous pointer.
        ListNode leftNode = null ; //  // left and right node.
        ListNode rightNode = null ;
        int pos = 1 ;
        
        while(curr != null){
            if(pos == right){ // if pos is equal to right then update the right and its next pointer.
                rightNext = curr.next ;
                rightNode = curr ;
            }
            
            if(pos == left){ // updating left pointer
                leftNode = curr ;
            }
            
            if(leftNode == null){ // this is lefts previous poiniter, this will be updated until left node is found.
                leftPrev = curr ;
            }
            
            curr = curr.next ;
            pos++;
        }
        
        
        
        // now extracting the linkedlist from left pos to right pos.
        
        if(leftPrev != null){
            leftPrev.next = null ;
        }
        rightNode.next = null ;
        
        // getting the extracted part's reverse.
        ListNode rev = reverseList(leftNode);
                 
        // and now assinging the rev part with left prev and right next.
        if(leftPrev != null){ 
            leftPrev.next = rev ;
        }
        else{
            head = rev ;
        }
        
        leftNode.next = rightNext ;
            
            
        return head; 
    }
    
    // function to reverse the linkedlist.
    
      public ListNode reverseList(ListNode head) {
        ListNode prev = null ;
        ListNode forward = null ;
        ListNode curr = head ;
        
        while(curr != null){
            forward = curr.next ;
            curr.next = prev ;
            prev = curr ;
            curr = forward ;
        }
        
        return prev ;
    }
}

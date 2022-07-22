package Problem_Of_The_day;

public class Q113_Design_Linked_List {

    class MyLinkedList {
    
        class ListNode{
            int val ;
            ListNode next, prev ;
            ListNode(int x){
                val = x ;
                next = null;
                prev = null;
            }
        }
    
        ListNode head ;
        ListNode tail ;
        int size ;
        
        public MyLinkedList() {
            head = new ListNode(-1) ;
            tail = new ListNode(-1) ;
            head.next = tail ;
            tail.prev = head;
            size = 0 ;
        }
        
        public int get(int index) {
            if(index >= size) return -1 ;
            
            ListNode curr = head.next ;
            int idx = 0 ;
            while(curr != null){
                if(idx == index){
                    return curr.val ;
                }
                
                curr = curr.next ;
                idx++ ;
            }
            
            return -1 ;
        }
        
        public void addAtHead(int val) {
            ListNode node = new ListNode(val) ;
            
            ListNode bkp = head.next ;
            head.next = node ;
            node.next = bkp ;
            node.prev = head ;
            bkp.prev = node ;
            size++ ;
            
        }
        
        public void addAtTail(int val) {
            ListNode node = new ListNode(val) ;
            
            ListNode bkp = tail.prev ; 
            bkp.next = node ;
            node.prev = bkp ;
            node.next = tail ;
            tail.prev = node ;
            size++ ;
        }
        
        public void addAtIndex(int index, int val) {
            if(size < index) return ;
            if(size == index){
                addAtTail(val);
                return ;
            }
                    size++ ;
    
            ListNode node = new ListNode(val) ;
            ListNode curr = head.next ;
            int idx = 0 ;
            while(curr != null){
                if(idx == index){
                    ListNode bkp = curr.prev ;
                    bkp.next = node ;
                    node.prev = bkp;
                    node.next = curr;
                    curr.prev = node ;
                    return ;
                }
                
                idx++;
                curr = curr.next ;
            }
        }
        
        public void deleteAtIndex(int index) {
            
            if(size <= index) return ;
           
                    size-- ;
            ListNode curr = head.next ;
            int idx = 0 ;
            while(curr != null){
                if(idx == index){
                    ListNode prev = curr.prev ;
                    prev.next = curr.next ;
                    curr.next.prev = prev ;
                    return ;
                }
                
                idx++;
                curr = curr.next;
            }
    
        }
    }
    
}

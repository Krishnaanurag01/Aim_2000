package Linked_List;



public class Q13_Merge_Sort_for_Linked_List {

    node head ;
    public static class node {

        int data ;
        node next; 

        public node(int d){
            data = d ;
            next = null ;
        }        
    }

    // this function helps in finding the mid point.
    public static node mid_point(node ListHead) {
        if(ListHead == null || ListHead.next == null){  // if we don't apply listHead == null then we might get wrong answer. for example: 2,3 if we applied list.next != null over list.next.next then we'll get 3 as mid which is wrong.
            return ListHead;
        }

        node slow = ListHead;
        node fast = ListHead;

        while (fast.next!= null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        return slow;
    }

    public static node merge_two_lists(node ListNode1 , node ListNode2) {
        if(ListNode1 == null || ListNode2 == null){
            return ListNode1 != null? ListNode1 : ListNode2 ;
        }

        node c1 = ListNode1;
        node c2 = ListNode2;
        node dummy_node = new node(-1);
        node itr = dummy_node;

        while (c1 != null && c2 !=null) {
            if(c1.data < c2.data){
                itr.next = c1 ;
                c1 = c1.next;
            }
            else{
                itr.next = c2 ;
                c2 = c2.next;
            }

            itr = itr.next ;
        }

        itr.next = c1 != null ? c1 : c2 ;

        return dummy_node.next;
    }

    public static node merge_sort(node ListNode) {
        if(ListNode == null || ListNode.next == null){
            return ListNode;
        }

        node mid  = mid_point(ListNode);// this is the first half of original list.
        node nextNode_after_mid = mid.next; // this is another half of original list
        mid.next = null;

       node ListNode1 = merge_sort(ListNode) ; // breaking it to the smaller parts.
       node ListNode2 = merge_sort(nextNode_after_mid) ;

        return merge_two_lists(ListNode1, ListNode2); // now returning the merge list.
    }

}

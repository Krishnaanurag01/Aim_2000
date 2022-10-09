package Linked_List;
import java.util.*;

public class Q43_Convert_Sorted_List_to_Binary_Search_Tree {

    class ListNode{
        int val ;
        ListNode next ;
    }
    class TreeNode{
        int val ;
        TreeNode left, right ;

        TreeNode(int val){
            this.val = val ;
        }
    }

    public TreeNode sortedListToBST(ListNode head) {
        
        // storing all the values of ll in an array list.
        ArrayList<Integer> ll = new ArrayList<>();
        
        while(head != null){
            ll.add(head.val) ;
            head = head.next;
        }
        
        return helper(0,ll.size() - 1, ll) ;
    }
    
    public TreeNode helper(int si, int ei, ArrayList<Integer> ll){
        
        if(si > ei) return null ;
        
        // taking the mid pointer.
        int mid = si + ((ei-si+1)/2) ;
        int val = ll.get(mid) ; // taking the mid value.
        
        TreeNode node = new TreeNode(val) ;
        node.left = helper(si, mid - 1, ll) ; // assigning l
        node.right = helper(mid + 1, ei, ll) ;
        
        return node ;
    }
}

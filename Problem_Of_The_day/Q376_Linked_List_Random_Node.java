package Problem_Of_The_day;
import java.util.*;

public class Q376_Linked_List_Random_Node {

    class Solution {
        ArrayList<Integer> list ;
        public Solution(ListNode head) {
            list = new ArrayList<>() ;
            
            while(head != null){
                list.add(head.val) ;
                head = head.next ;
            }
        }
        
        public int getRandom() {
            return list.get(new Random().nextInt(list.size())) ; // getting random index from random class and return that index value
        }
    }

    class ListNode{
        int val ;
        ListNode next ;
    }
}

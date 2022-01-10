package Linked_List;

public class Q40_Add_Two_Numbers {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public static void main(String[] args) {

        ListNode root = new ListNode(5) ;
        root.next = new ListNode(6) ;
        root.next.next = new ListNode(4) ;

        
        ListNode root2 = new ListNode(7) ;
        root2.next = new ListNode(0) ;
        root2.next.next = new ListNode(8) ;


        printLL(root);
        printLL(root2);

        ListNode newRoot = addTwoNumbers(root, root2) ;
        printLL(newRoot);

    }



    public static void printLL(ListNode n) {

        if(n == null) return;

        while (n != null) {
            System.out.print( n.val + " -> " );
            n = n.next ;
        }
        System.out.println();
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode curr1 = l1 ;
        ListNode curr2 = l2 ;
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




        return newHead.next;

    }
}

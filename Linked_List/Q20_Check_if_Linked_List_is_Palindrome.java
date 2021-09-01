package Linked_List;


public class Q20_Check_if_Linked_List_is_Palindrome {

    node head ;
    public static class node {

        int data ;
        node next; 

        public node(int d){
            data = d ;
            next = null ;
        }        
    }


    public static void printLinkedList(node head) {

        node printIt = head;
        while(printIt != null){
            System.out.print(printIt.data + " -> ");
            printIt = printIt.next;
        }

        System.out.println();
    }

    public  void insertNode(int d) {
        node newNode = new node(d);
        if(head == null){
            head = newNode ;
            return;
        }

        node temp = head;

        while (temp.next != null) {
            temp = temp.next;            
        }
        
        temp.next = newNode;
        
    }

    // solution starts here.
    // time comp : o(n) and space is o(1)

    public static node midNode(node head) {
        
        if(head == null || head.next == null){
            return head;
        }

        node slow = head ;
        node fast = head ;

        while (fast.next != null && fast.next.next != null) {
            
            fast = fast.next.next;
            slow = slow.next;
        }

        return slow ;
    }

    public static node reverse(node n) {
        if(n == null || n.next == null){
            return n ;
        }

        node current  = n ;
        node forward = null ;
        node prev = null ;

        while (current != null) {
            forward = current.next;
            current.next = prev ;
            prev = current;
            current = forward ;
        }

        return prev;
    }

    public static boolean isPalindrome(node listhead) {
        if(listhead == null ){
            return false ;
        }

      

       node mid = midNode(listhead);
       node secondPart = mid.next;
       mid.next = null ;

       node firstPart = listhead;

       node reversed2ndPart = reverse(secondPart);

       while (firstPart != null && reversed2ndPart != null) {
           if(firstPart.data == reversed2ndPart.data ){
            firstPart = firstPart.next;
            reversed2ndPart = reversed2ndPart.next ;
           }else{
               return false;
           }
          
       }

       return true;
    }




    // just simply do these steps to solve it.
    // 1. split linked list into two parts 
    // 2. now reverse the 2nd part ( so that we can compare the first part element with 2nd part last element.)
    // 3. now compare the data if not equal then return false o\w check ahead.













    public static void main(String[] args) {
        
        Q20_Check_if_Linked_List_is_Palindrome ll =new Q20_Check_if_Linked_List_is_Palindrome() ; 

        ll.insertNode(5);
        ll.insertNode(6);
        ll.insertNode(7);
        ll.insertNode(5);
        ll.insertNode(6);
        ll.insertNode(5);
       
       

        // 
        
        System.out.println(isPalindrome(ll.head));

    }
    
}

package Problem_Of_The_day;

public class Q6_Check_if_Linked_List_is_Palindrome {

    static class Node{
        int data ; 
        Node next ;

        Node(int data , Node next){
            this.data = data ;
            this.next = next ;
        }
    }

    public static void main(String[] args) {
        
    }

    public Node getMid(Node head){

        Node slow = head ;
        Node fast = head ;

        while (fast.next != null || fast.next.next != null) {
            slow = slow.next ;
            fast = fast.next.next ;
        }


        return slow ;
    }

    public Node reverseList(Node head) {
        
        Node current = head ;
        Node prev = null ;
        Node forward = null ;

        while (current!= null) {
            forward = current.next ;
            current.next = prev ;
            prev = current ;
            current = forward ;
        }

        return prev ;
    }

    boolean isPalindrome(Node head) 
    {
        //Your code here
        if(head == null ){
            return false ;
        }

        Node midNode = getMid(head);
        Node secondList = midNode.next ;
        midNode.next = null ;

        secondList = reverseList(secondList) ;

        while (head != null && secondList != null) {
            if(head.data == secondList.data){
                head = head.next ;
                secondList = secondList.next ;
            }
            else{
                return false ;
            }
        }
        return true ;
    }   
    
}

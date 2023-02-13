package Problem_Of_The_day;

public class Q360_Find_length_of_Loop {

    static int countNodesinLoop(Node head)
    {
       int count = 0;
       Node slow = head ;
       Node fast = head ;
       Node st = null ;
       
       while(fast != null && fast.next != null ){
           fast = fast.next.next ;
           slow = slow.next ;
           if(fast == slow){
               count = 0 ;
               fast = head ;
               while(fast != slow){
                   fast = fast.next ;
                   slow = slow.next ;
                   count++ ;
               }
               st = fast ;
               break ;
           }
       }
       
       if(st != null){
           Node temp = st ;
           count = 1 ;
           temp = temp.next ;
           while(temp != st){
               temp = temp.next ;
               count++ ;
           }
       }
       
       
       
       return count ;
    }

    class Node{
        int data ;
        Node next ;
    }
}

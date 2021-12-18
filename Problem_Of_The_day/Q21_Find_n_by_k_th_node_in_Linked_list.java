package Problem_Of_The_day;

public class Q21_Find_n_by_k_th_node_in_Linked_list {

    public static void main(String[] args) {
        
        System.out.println( (int)Math.ceil(5/2));
    }
    

    static class Node {
        int data ;
        Node next ;

        Node( int val){
            data = val ;
            next = null ;
        }
    }

    public static int nknode(Node head, int k)
    {
       if(k <= 0 || head == null) return 0 ;

       Node moveNode = null ; // this will move when n % k == 0.
       Node parentNode = head ; // this will travers the list.
       int i = 0 ; // denotes size.

       while (parentNode != null) {
           
        if(i % k == 0){ // this denotes we have to move one step ahead. ex: if i (size) == 2 and k is 2 then the n/kth element will be 0th element so it will move .

            if(moveNode == null){ // for the first we have to store head as it had null previously.
                moveNode = head ;
            }
            else{
                moveNode = moveNode.next ; // moving next
            }
        }

        i++ ; // increasing size
        parentNode = parentNode.next ; // moving ahead
       }

       return moveNode.data ;
    }
}

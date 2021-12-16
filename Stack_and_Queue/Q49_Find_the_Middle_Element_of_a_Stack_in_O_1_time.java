package Stack_and_Queue;

public class Q49_Find_the_Middle_Element_of_a_Stack_in_O_1_time {
    
    static class Node{ // using dll for this operations.
        int data ;
        Node next ;
        Node prev ;

        Node(int val ){
            data = val ;
            next = null ;
            prev = null ;
        }
    }

    private static Node head = new Node(-1) ; // head
    private static Node mid  = null ; // mid pointer always point to mid element
    private static int count = 0; // size of dll


    public static void push(int x){
        count++ ; // increasing size

        Node newNode = new Node(x) ;
        newNode.next = head ;
        // System.out.println(head);
        head.prev = newNode ;
        head = newNode ;

        if(count == 1){ // if count is 1 then it means we have only one element so point to that element 
            mid = newNode ;
        }
        else if(count % 2 == 0){ // else if size is even then move to mid to its prev
            mid = mid.prev ;
        }

    }



    public static int pop() {
        count-- ;
        if(count == 0){
            mid = null ;
            return -1 ; // underflow
        }

        int x = head.data ;
        head = head.next ;
        head.prev = null ;

        if(count % 2 != 0){// if size is odd then move mid to its next.
            mid = mid.next ;
        }


        return x ; // popped element.
    }

    public static void getMid() {

        System.out.println( mid != null ? mid.data : null);
    }

    public static void main(String[] args) {

        push(5);
        push(6);
        pop();
        // pop();
        getMid();
        
    }
}

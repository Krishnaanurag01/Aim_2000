package Linked_List;


public class Q27_Rotate_a_Singly_LL {

    node head ;
    public static class node {

        int data ;
        node next; 

        public node(int d){
            data = d ;
            next = null ;
        }        
    }


    public void printLinkedList(node head) {

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


    public static node rotateIt(node head , int k ) {
        if(head == null || head.next == null || k == 0 ){
            return head;
        }

        // find the length of the ll first.

        node current = head ;
        int length = 1 ;  // here taking the length 1 by default because in the loop we are not counting the last node.
        while (current.next != null) {
            length++;
            current = current.next ;
        }

        current.next = head ; // now making circular ll by connecting the last node with the first.

        int final_rotation = k % length ; // this will help in rotating large numbers. for example : if we have to do 43 rotation then 
        // insted of doing 40 rotations we can simply rotate by 43 % 5 (assumed 5 is length of list) = 3 .
        // then it means 3rd nodes next will be our head . and on the 3rd node we have to break the circular list. 

        k = length - final_rotation ; // this is length where we have to make our head and break the loop. // just this one line is added here.

        while (k-- > 0) {
            current = current.next;
        }

        head = current.next ;
        current.next = null;



        return head;
    }













    public static void main(String[] args) {

        Q27_Rotate_a_Singly_LL ll = new Q27_Rotate_a_Singly_LL() ;

        ll.insertNode(1);
        ll.insertNode(2);
        ll.insertNode(3);
        ll.insertNode(4);
        ll.insertNode(5);
        ll.insertNode(6);



        node newHead = rotateIt(ll.head, 2);

        ll.printLinkedList(newHead);
        
    }
    
}

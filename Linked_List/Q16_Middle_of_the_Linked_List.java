package Linked_List;

public class Q16_Middle_of_the_Linked_List {

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



    // solution function.

    // public static int getLength(node head) {
    //     if(head==null){
    //         return 0;
    //     }
    //     node temp = head;
    //     int length = 0 ;
    //     while(temp != null){
    //         length++;
    //         temp = temp.next ;
    //     }
    //     return length;
    // }

    public static node getMiddleElement(node listHead) {
        if(listHead == null || listHead.next == null){
            return listHead;
        }

       
        node slow = listHead;
        node fast = listHead;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next ;
        }


        return slow;

    }
    public static void main(String[] args) {

        Q16_Middle_of_the_Linked_List ll =new Q16_Middle_of_the_Linked_List();

        ll.insertNode(1);
        ll.insertNode(2);
        ll.insertNode(3);
        ll.insertNode(4);
        ll.insertNode(5);
        ll.insertNode(6);
  
        

        node mid = getMiddleElement(ll.head);
        System.out.println(mid.data);


        
    }
}

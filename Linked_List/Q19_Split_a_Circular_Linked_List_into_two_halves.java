package Linked_List;

public class Q19_Split_a_Circular_Linked_List_into_two_halves {
    
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


    // Solutions starts here :

    public static node midNode(node listHead) {
        if(listHead == null ){
            return listHead;
        }

        node slow = listHead ;
        node fast = listHead ;

        while ( fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next ;
        }

        return slow;
    }

    public static void spllitIt(node head) {
        if(head == null){
            return ;
        }

        node midNode = midNode(head) ;
        node secondPart = midNode.next;

        midNode.next = null ;

        midNode.next = head ;
        

        node temp = secondPart;

        while(temp.next != null){
            temp = temp.next;
        }

        temp.next = secondPart ;
    }

    public static void main(String[] args) {
        
    }
}

package Linked_List;

public class Q22_Reverse_A_Double_Linked_List {
    
    node head ;
    public static class node {

        int data ;
        node next; 
        node prev;

        public node(int d){
            data = d ;
            next = null ;
            prev = null ;
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

        while (temp.next !=  null) {
            temp = temp.next;            
        }
        

        temp.next = newNode;
        newNode.prev = temp ;
        
    }


    public static node reverse_doubly_ll(node listHead) {
        if(listHead == null || listHead.next == null ){
            return listHead ;
        }

        node current = listHead ; // for traversing the list.
        node temp = null; // for backing up the previous node.

        while (current != null) {
            temp = current.prev; // backup 
            current.prev = current.next ; // swap with next .
            current.next = temp ;
            current = current.prev ; // now our next node becomes our previous node so we'll move backward.
        }

        // now by the end of this loop temp will have previous of last node. and that previous nodes's previous pointer will point to the last node. so we'll return temp.prev.

        return temp.prev  ;
    }


    
    public static void main(String[] args) {
        Q22_Reverse_A_Double_Linked_List ll = new Q22_Reverse_A_Double_Linked_List();

        ll.insertNode(5);
        ll.insertNode(6);
        ll.insertNode(7);
        ll.insertNode(8);
        ll.insertNode(9);
        ll.insertNode(50);

        node newHead = reverse_doubly_ll(ll.head);

        printLinkedList(newHead);

    }
}

package Linked_List;

public class Singly_LL {
    
  static node head ;
    public class node {

        int data ;
        node next; 

        public node(int d){
            data = d ;
            next = null ;
        }        
    }

    node reverse(node head){

        node current = head;
        node forward = null ;
        node previous = null ;

        while(current != null){

            forward = current.next;

            current.next = previous ;

            previous = current ;

            current = forward ;
        }
        return previous ;
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

    static node tempHead = null ;
    static node tempTail = null; 

    public void addFirst(node n) {
        if(head == null ){
            tempHead = n;
            tempTail = n ;
        }
        else{
            n.next = tempHead;
            tempHead = n ;
        }
    }

    public node reverseIt_using_addFirst(node n) {
        if(head == null){
            head = n ;
        }

        node temp = head ;
        while (temp != null) {
            node forward = temp.next ;
            temp.next = null;
            addFirst(temp);
            temp = forward;
            
        }

        return tempHead;
    }
    public static void main(String[] args) {
        Singly_LL ll = new Singly_LL();
        ll.insertNode(1);
        ll.insertNode(2);
        ll.insertNode(3);
        ll.insertNode(4);
        ll.insertNode(5);
        ll.insertNode(6);

        ll.reverseIt_using_addFirst(head);
        ll.printLinkedList(tempHead);

    }
    
}

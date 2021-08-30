package Linked_List;

public class Q5_Find_the_starting_point_of_the_loop {
    
    
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




    // time comp : o(n) and more elaboratly it is o(n+k) and o(1) space.
    public static node find_Start_Of_The_Loop(node head2) {

        node hare = head2 ;
        node tortoise = head2 ;
        
        while(hare != null && hare.next != null){

            hare = hare.next.next;
            tortoise = tortoise.next ;
            if(hare == tortoise){
                hare = head2;
                while(hare != tortoise){
                    hare = hare.next;
                    tortoise = tortoise.next;
                }
                return hare;
            }
        }

        return null ;
    }
















    public static void main(String[] args) {

        Q5_Find_the_starting_point_of_the_loop ll = new Q5_Find_the_starting_point_of_the_loop();

        node first = new node(5);
        node second = new node(6);
 
        node third = new node(7);
 
        node fourth = new node(8);
 
        node fifth = new node(9);
 
       
 
        ll.head = first ;
        ll.head.next = second;
        ll.head.next.next = third;
        ll.head.next.next.next =fourth ;
        ll.head.next.next.next.next = fifth ;
 
        ll.head.next.next.next.next.next = first ;

        node start = find_Start_Of_The_Loop(ll.head);
 
        System.out.println(start.data);
    }
}

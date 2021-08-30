package Linked_List;

import java.util.HashSet;

public class Q12_Intersection_Point_in_Y_Shapped_Linked_Lists {
    
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
    

    // time comp is : o(2m) {because we are getting element in 2nd time iteration from start.} and space is o(1)
    
    private static node find_Intersection_Point(node head2, node head3) {

        if(head2 == null || head3 == null)
        {
            return null;
        }

        node a = head2; // take a dummy node for both list and assign the head.
        node b = head3;

        while( a != b){  // keep iterating until they becomes equal.
            a = a == null? head3 : a.next; //when a completes traversing all nodes then give another list's head to it and same for the b. then we come to a point when they becomes equal.
            b = b == null? head2 : b.next;

        }
        return a; // they simply return the intersection point.
    }















    public static void main(String[] args) {

        Q12_Intersection_Point_in_Y_Shapped_Linked_Lists ll_1 = new Q12_Intersection_Point_in_Y_Shapped_Linked_Lists();
       
        ll_1.insertNode(3);
        ll_1.insertNode(6);
        ll_1.insertNode(9);
        ll_1.insertNode(12);
        ll_1.insertNode(15);

       node point =  find_Intersection_Point(ll_1.head , ll_1.head.next.next.next);
       node point2 = get_Intersection_point(ll_1.head , ll_1.head.next.next.next);
        

       System.out.println("1 > "+point.data);

       System.out.println("2 > "+ point2.data);
    }

    // intersection point using hashing.

    // TIME COMP : O(n+m) and SPACE COMP : O(n)   where n is list1 and m is list 2.
    
    public static node get_Intersection_point(node head1 , node head2 ) {
        
        HashSet<node> set = new HashSet<>();

        if(head1 == null || head2 == null){
            return null;
        }

        node current = head1 ;

        while (current != null) {
            set.add(current);
            current = current.next ;
        }

        node current2 = head2 ;

        while (current2 != null) {
            if(set.contains(current2)){
                return current2;
            }
            else{

                current2 = current2.next;
            }
        }


        return null;
    }

}

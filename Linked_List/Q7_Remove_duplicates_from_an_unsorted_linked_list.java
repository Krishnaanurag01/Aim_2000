package Linked_List;

import java.util.HashSet;

public class Q7_Remove_duplicates_from_an_unsorted_linked_list {
    
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
    
    
    
    private static void removeDuplicate_From_Unsorted_Arrays(node head2) {
        if(head2 == null || head2.next == null){
            return;
        }

        node current = head2;
        node prev = null ; // this will help in linking the linked list.

        HashSet<Integer> set = new HashSet<>();

        while (current != null) {
            
            if(set.contains(current.data)){
                prev.next = current.next; // adding the previous linked list with current.
            }
            else{

                set.add(current.data); // when set doesn't contains the value then simply add it to the set and give aur current linkedlist to prve.
                prev = current;
            }
            // then move to next node.
            current = current.next;
            
        }
    }







    public static void main(String[] args) {

        Q7_Remove_duplicates_from_an_unsorted_linked_list ll = new Q7_Remove_duplicates_from_an_unsorted_linked_list();

        ll.insertNode(2);
        ll.insertNode(4);
        ll.insertNode(4);
        ll.insertNode(2);
        ll.insertNode(8);
        ll.insertNode(4);



        removeDuplicate_From_Unsorted_Arrays(ll.head);
        ll.printLinkedList(ll.head);
    }

}

package Linked_List;

import java.util.Comparator;

import java.util.PriorityQueue;



public class Q25_Sort_a_k_sorted_doubly_linked_list {
    

    static class Node{

        int data;
        Node next;
        Node prev ;

        public Node(int d){
            data = d ;
            next = null ;
            prev = null ;
        }
    }

   static Node head ;

    public static void insertNode(int data) {
        Node newNode = new Node(data);

        if(head == null){
            head = newNode ;
            return;
        }

        Node current = head;

        while (current.next != null) {
            current = current.next ;
        }

        current.next = newNode;
        newNode.prev = current ;
    }


    public static void print_Doubly_List(Node head) {
        if(head == null){
            System.out.println("Empty list!");
            return;
        }

        Node current = head ;
        while (current != null ) {
            System.out.print(current.data+" -> ");
            current = current.next;
        }

    }





    class  compareNode implements Comparator<Node>{

        @Override
        public int compare(Node o1, Node o2) {
           return o1.data - o2.data ;
        }
        
    }




    // using priority queue :
    // time comp : o(n log k) where k is given in question and n is length of the linked list.
    // space comp : o(k) for storing values in priority queue.


    public Node sort_a_k_sorted_list(Node listHead , int k) {
        if(listHead == null || listHead.next == null ){
            return listHead ;
        }

        PriorityQueue<Node> pq = new PriorityQueue<>( new compareNode() );

        for (int i = 0; i < k+1 ; i++) {
            pq.add(listHead) ;

            listHead = listHead.next ;
        }

        Node newHead = null ; 
        Node lastNode = null ;

        while ( !pq.isEmpty() ) {
            if (newHead == null) {
                newHead = pq.remove();
                newHead.prev = null ;

                lastNode = newHead ;
            }
            else{
                lastNode.next = pq.remove();
                lastNode.next.prev = lastNode ;

                lastNode = lastNode.next ;
            }

            if( head != null){
                pq.add(head);
                head = head.next ;
            }
        }

        lastNode.next = null ;

        return newHead ;
    }



    // // using insertion sort : 
    // //time comp : o(n*k)
    // // space comp : o(1)


    // public static Node sort_k_sorted_ll(Node listHead , int k ) {
        
    //     if(listHead == null || listHead.next == null){
    //         return listHead ;
    //     }

    //     Node newHead = null ;
    //     Node current = head ;

    //     for (int i = k+1 ; current != null ; i++) {
    //         while( k-- > 0){
                
    //         }
    //     }
















    //     return null;
    // }



















    public static void main(String[] args) {

        Q25_Sort_a_k_sorted_doubly_linked_list ll =new Q25_Sort_a_k_sorted_doubly_linked_list();

        insertNode(2);
        insertNode(3);
        insertNode(6);
        insertNode(12);
        insertNode(56);
        insertNode(8);

        // print_Doubly_List(head);

       Node newHead = ll.sort_a_k_sorted_list(head, 2) ;;

        print_Doubly_List(newHead);
        
    }
}

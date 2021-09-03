package Linked_List;

import java.util.PriorityQueue;


public class Q31_Merge_K_sorted_linked_lists {
    
    Node head ;
    public static class Node {

        int data ;
        Node next; 

        public Node(int d){
            data = d ;
            next = null ;
        }        
    }


    public void printLinkedList(Node head) {

        Node printIt = head;
        while(printIt != null){
            System.out.print(printIt.data + " -> ");
            printIt = printIt.next;
        }

        System.out.println();
    }

    public  void insertNode(int d) {
        Node newNode = new Node(d);
        if(head == null){
            head = newNode ;
            return;
        }

        Node temp = head;

        while (temp.next != null) {
            temp = temp.next;            
        }

        temp.next = newNode;
        
    }


    // solutions start here :

    // merging two list. same logic like we did before.

    public static Node merge_two_list(Node l1 , Node l2) {
        if( l1 == null || l2 == null){
            return l1 != null ? l1 : l2 ;
        }

        Node newNode = new Node(-1);
        Node ptr = newNode ;

        Node c1 = l1 , c2 = l2 ;

        while (c1 != null && c2 != null) {
            if( c1.data < c2.data){
                ptr.next = c1;
                c1 = c1.next ;
            }
            else{
                ptr.next = c2;
                c2 = c2.next ;
            }

            ptr = ptr.next ;
        }

        ptr.next = c1 != null ? c1 : c2 ;
        

        return newNode.next;


    }


    public static Node merge_k_list(Node[] list , int start, int end) {

        if(start > end) return null; // return when start becomes greater than end.

        if(start == end) return list[start];  // when we reach the point where start == end then return it.

        int mid = (start+end)/2 ; // this will the mid point of the array so that we can break it into two equal halfs.

        Node ll1 = merge_k_list(list, start, mid); // this is left side.
        Node ll2 = merge_k_list(list, mid+1, end) ; // this is right side.

        return merge_two_list(ll1, ll2) ; // merge both the halfs.

    }


    public static Node merge_k_list(Node[] list) {
        if(list.length == 0) return null;        // when list array length is zero return null.

        return merge_k_list(list, 0 , list.length-1);  // sending the list array for result.
    }




    // method 2 : with same time comp : o(nklogk) and o(k) space.

    public static Node merge_list(Node[] list) {
        PriorityQueue<Node> pq = new PriorityQueue<>( (a,b)-> {
             return a.data - b.data;         // this is the default behaviour and if you want reverse of it then subtract a from b.
            } );


        for (Node node : list ) {  // as list[] array has head of different linked list. so we'll insert all the head of linked list into priority queue if it is not null.
            if(node != null){
                pq.add(node);            // this is o(k log k) opertion.
            }
        }

        Node newHead = new Node(-1); // for creating a head of sorted array.
        Node prev = newHead;


        while (!pq.isEmpty()) { // this will take o( kn log k)
            
            Node node = pq.remove() ; // now remove the node from queue. as we are using min priority queue so it will return the node which has the smallest data.

            prev.next = node ; // now we add the removed node into our result list.

            prev = prev.next ; // for further operations.

            node = node.next ; // now whichever node we removed from queue , if it has next node then it will insert into the queue.
            if(node != null){
                pq.add(node);
            }
        }

        return newHead.next ;
    }

















    public static void main(String[] args) {
        
    }
}

package Linked_List;

public class Q17_Quick_sort_for_Linked_list {
    
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



    // solution.

    public static int getLength(node head) {
        if(head==null){
            return 0;
        }
        node temp = head;
        int length = 0 ;
        while(temp != null){
            length++;
            temp = temp.next ;
        }
        return length;
    }

    // you already know its working.
    public static node[] segregate(node head , int pivotIndex) {
        if( head == null || head.next == null){
            return null;
        }

        node pivotNode = head ;

        while (pivotIndex-- > 0) {
            pivotNode = pivotNode.next;
        }

        node smaller_head = new node(-1);
        node smaller_ptr = smaller_head;

        node larger_head = new node(-1);
        node larger_ptr = larger_head;

        node current = head;

        while (current != null) {
            if(current != pivotNode){
                if(current.data <= pivotNode.data){
                    smaller_ptr.next = current;
                    smaller_ptr = smaller_ptr.next;
                }
                else{
                    larger_ptr.next = current ;
                    larger_ptr = larger_ptr.next;
                }
            }

            current = current.next;
        }

        smaller_ptr.next = null; // by making next these three become seperate and we'll return them seperatly.
        larger_ptr.next = null;
        pivotNode.next=null;

        return new node[]{smaller_head.next , pivotNode , larger_head.next};

    }
    
    public static node[] merge_two_list(node[] leftSortedList , node pivot , node[] rightSortedList) {
        
        node head = null , tail = null;

        if(leftSortedList[0] != null && rightSortedList[0] != null){ // when heads of both are present then perform this.

            leftSortedList[1].next = pivot; // connecting the tail with pivot and pivot with head of right side.
            pivot.next = rightSortedList[0];
            head = leftSortedList[0]; // and then head of left side becomes original head and tail of right becomes orignal tail.
            tail = rightSortedList[1];

        }
        else if( leftSortedList[0]  != null ){ // when right side is not present.
            leftSortedList[1].next = pivot; // make left side tail connected with pivot.
            head = leftSortedList[0]; // head of left list becomes orignal head.
            tail = pivot; // as the last node is pivot so pivot becomes tail.

        }
        else if( rightSortedList[0] != null){
            pivot.next = rightSortedList[0]; // now left side is not present so pivot becomes the first and oorignal head and gets connectdwith with right head.
            head = pivot;
            tail = rightSortedList[1]; // right tail becomes original tail.
        }
        else{

            head = tail = pivot ; // as only pivort available so pivot becomes our orignal head and tail.
        }

        return new node[]{head , tail}; // send back head and tail in an array.
    }


    // we have to return head and tail by end of this function.
    public static node[] quick_sort(node head) {
        // solution starts from here.
        if(head == null || head.next == null){
            return new node[]{head,head};  // when null or only 1 node then return head and tail == head.
        }

        int length = getLength(head); // this helps in finding the pivot element .
        int pivotIndex = length/2 ; // segregate list from middle node every time.

        node[] segregated_list = segregate(head, pivotIndex) ; // we'll get the smaller nodes from pivot node at index 0 , pivot node at index 1 and bigger nodes at index .

        node[] left_sorted_list = quick_sort(segregated_list[0]); // now again sort the left side of the list.
        node[] righ_sorted_list = quick_sort(segregated_list[2]); // sorting right side of the nodes.

        return merge_two_list(left_sorted_list , segregated_list[1], righ_sorted_list); // and then merge it and return head and tail.
    }
    
      
    
    
    
    public static void main(String[] args) {

        Q17_Quick_sort_for_Linked_list ll = new Q17_Quick_sort_for_Linked_list();

        ll.insertNode(3);
        ll.insertNode(13);
        ll.insertNode(-3);
        ll.insertNode(1);
        ll.insertNode(5);
        ll.insertNode(-14);
        ll.insertNode(0);

        node newHead = quick_sort(ll.head)[0];

        printLinkedList(newHead);

        
    }
}

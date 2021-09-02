package Linked_List;

public class Q24_Count_triplets_in_a_sorted_doubly_linked_list_whose_sum_is_equal_to_a_given_value_x {
 
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


    // Time Complexity: O(n2) 
// Auxiliary Space: O(1)

// same logic which we used in array.

    public static int getTripletSum(Node listHead , int sum) {
        if( listHead == null || listHead.next == null ){
            return 0 ;
        }

        int count = 0 ;
        Node firstIteration = listHead;

        while( firstIteration.next.next != null ){
            
            count +=findTwoSum(firstIteration.next, sum - firstIteration.data);
            firstIteration = firstIteration.next;
                
            
        }

        return count ;
    }



    private static int findTwoSum(Node startPointer, int sum) {

        if(startPointer == null || startPointer.next == null){
            return 0 ;
        }

        Node lastPointer = startPointer ;

        while (lastPointer.next != null ) {
            lastPointer = lastPointer.next;
        }

        int count = 0;


        while (startPointer != lastPointer) {
            int s = startPointer.data + lastPointer.data;
            if(s == sum){
                count++;
                startPointer = startPointer.next;
                lastPointer = lastPointer.prev;
            }
            else{
                if(s < sum){
                    startPointer = startPointer.next;
                }
                else{
                    lastPointer = lastPointer.prev;
                }
            }
        }

        return count;
    }


    public static void main(String[] args) {

        insertNode(1);
        insertNode(2);
        insertNode(4);
        insertNode(5);
        insertNode(6);
        insertNode(8);
        insertNode(9);

        System.out.println(getTripletSum(head, 17));
        
    }
}

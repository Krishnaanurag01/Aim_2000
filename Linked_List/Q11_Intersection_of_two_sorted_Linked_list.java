package Linked_List;


public class Q11_Intersection_of_two_sorted_Linked_list {

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


    private static node intersection_of_two_List(node head2, node head3) {
        if(head2 == null || head3 == null){
            return null;
        }

        node first = head2;
        node second = head3 ;

        node resultHead = new node(-1) ;
        node itr = resultHead;

        while ( first!= null && second != null) {
            if(first.data == second.data){
                itr.next = new node(first.data);
                itr = itr.next;
                first = first.next ;
                second = second.next ;
            }
            else if(first.data < second.data){             // 1 2 3 4 6   -> 2 4 6 8
                first = first.next;
            }
            else{
                second = second.next ;
            }
        }

        return resultHead.next ;
    }






















    public static void main(String[] args) {

        Q11_Intersection_of_two_sorted_Linked_list ll_1 = new Q11_Intersection_of_two_sorted_Linked_list();
        Q11_Intersection_of_two_sorted_Linked_list ll_2 = new Q11_Intersection_of_two_sorted_Linked_list();

        ll_1.insertNode(1);
        ll_1.insertNode(2);
        ll_1.insertNode(3);
        ll_1.insertNode(4);
        ll_1.insertNode(6);

        ll_2.insertNode(2);
        ll_2.insertNode(4);
        ll_2.insertNode(6);
        ll_2.insertNode(8);

        node intersectionHead =intersection_of_two_List(ll_1.head , ll_2.head);

        printLinkedList(intersectionHead);



        
    }

    
}

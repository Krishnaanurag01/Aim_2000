package Linked_List;



public class Q9_Add_1_to_a_number_represented_as_linked_list {

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
    
    
    
    

    private static node Add_one_to_LL(node head) {
        
        if(head == null){
            return null ;
        }

        // first reverse the list.

       node head2 = reverse(head);



       
       node temp = head2;
 // this is the main steps.
       while(temp!= null){
           // this condtion runs when for ex : 99999 comes.
        if(temp.data == 9 && temp.next == null){
            temp.data = 10;
            break;
        }else if(temp.data == 9){ /// this runs when ex: 899 comes.
            temp.data = 0;
            temp = temp.next ;
        }
        else{// this when element is less than 9 .
            temp.data = temp.data + 1;
            break;
           }

       }

       // again reverse the list and return it.

       node reverseNode = reverse(head2);
       
       return reverseNode;

    }




    

    public static node reverse(node head2) {
        
        node current = head2;
        node forward = null;
        node prev = null;
        while (current != null) {
            forward = current.next ;
            current.next = prev;
            prev = current;
            current = forward;
        }





        return prev;
    }





















    public static void main(String[] args) {

        Q9_Add_1_to_a_number_represented_as_linked_list ll = new Q9_Add_1_to_a_number_represented_as_linked_list();


        // for this just do these 3 steps :
        // 1). reverse the ll
        // 2). perform the addition operation.
        // 3). again reverse it and return modified head.

        ll.insertNode(9);
        ll.insertNode(9);
        ll.insertNode(9);
        ll.insertNode(9);
       
      node newHead = Add_one_to_LL(ll.head);

       printLinkedList(newHead);

    }

}

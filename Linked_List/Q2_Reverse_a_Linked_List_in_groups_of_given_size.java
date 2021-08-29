package Linked_List;



public class Q2_Reverse_a_Linked_List_in_groups_of_given_size {


   static node head ;

   Q2_Reverse_a_Linked_List_in_groups_of_given_size(){
       head = null;
   }

    public class node {

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






    // solutions part.


    // this will return length .

    public static int length(node head){

        int len = 0 ;

        node temp = head ;

        while (temp != null) {
            temp = temp.next ;
            len++;
        }


        return len ;
    }

    static node tempHead = null ;
    static node tempTail = null ;

    // this function add nodes in the start.

    public static void addFirst(node d) {
        if(tempHead == null){
            tempHead = d ;
            tempTail = d ;
        }
        else{
            d.next = tempHead; // this will connect previous list with our new nodes next.
            tempHead = d; // and then our new node will become temp head.
        }
    }

    // time complexcity is : o(n) and space is o(1). here we used two while  together but still complexcity is o(n) becuase first while loop runs for very less time and by the end we only access all the n node only.
    public static node reverseIt_in_K_Group(node head , int k){

        if( head == null || head.next == null || k == 0){
            return head; // when empty or k is zero then we don't have to do anything.
        }

        node originalHead = null , originalTail = null ; // this will be our original head pointer which we return in the end.

        int length = length(head); // first finding the length of ll. 

        node current = head; // now creating a temp node and copying the linked list.

        while(length >= k){  // while length is greater or equal to k perform it.
            int tempK = k; // taking k in a temp variable becoz we have to perform k times loop for every group. 

            while (tempK-- > 0) {
                node forward = current.next;  // this will link the next nodes.
                current.next = null; 
                addFirst(current);  // adding it to the start of tempHead.
                current = forward ; // now we get the rest nodes here.
            }

            if(originalHead == null){ // intitally work this , when we first get our temp head,tail it will become our original data.
                originalHead = tempHead ;
                originalTail = tempTail ;
            }
            else{
                originalTail.next = tempHead ; // when we already have orignal head and next then we don't have to touch head we just upate the original temp. this will link the new temp head with original tail.
                originalTail = tempTail ;  // and then we make our new temp head to original tail.
            }

            tempHead = null ; // noe after  assigning to orignal head and tail we have to create new temp head and temp tail thats why intializing it everytime. 
            tempTail = null ;

            length -= k ;
        }

        // now as questions says , we have to reverse rest of the nodes which are lesser than k. so we again do the same thing till we reach the end.
        while (current != null) {
            node forward = current.next;
            current.next = null;
            addFirst(current);
            current = forward ;
        }
        if(originalHead == null){
            originalHead = tempHead ;
            originalTail = tempTail ;
        }
        else{
            originalTail.next = tempHead ;
            originalTail = tempTail ;
        }

        // if you don't want to reverse rest nodes then simply remove above loop and do this

        // originalTail.next = current ;

        // and then we'll return original head.
        return originalHead;

    }










    public static void main(String[] args) {

        Q2_Reverse_a_Linked_List_in_groups_of_given_size ll = new Q2_Reverse_a_Linked_List_in_groups_of_given_size();


        ll.insertNode(3);
        ll.insertNode(2);
        ll.insertNode(7);




        // ll.printLinkedList(head);

        /// for this you have to make 3 function and 2 static varibale i.e 
        // length function , add to first function , and reversein in k group function.
        // temphead and temptail node.

      node ansHead =  reverseIt_in_K_Group(head , 3);
      ll.printLinkedList(ansHead);
    }


    
}

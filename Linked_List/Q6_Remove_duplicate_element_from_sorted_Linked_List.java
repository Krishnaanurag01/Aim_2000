package Linked_List;


public class Q6_Remove_duplicate_element_from_sorted_Linked_List {

    node head ;
    public static class node {
        int data ;
        node next; 

        public node(int d){
            data = d ;
            next = null ;
        }        
    }

    // solution function.
    static node removeDuplicates(node head)
    {
        node nhead = new node(-1) ;
        node ptr = nhead ;
        node curr = head ;
        
        while(curr != null){
            if(ptr.data == curr.data){
                curr = curr.next ;
            }
            else{
                ptr.next = curr ;
                ptr = ptr.next ;
                curr = curr.next ;
            }
        }
        
        ptr.next = null ;
        return nhead.next ;
    } 
}

package Linked_List;


public class Q28_Flattening_a_Linked_List {
    
    static class Node{

        int data;
        Node next;
        Node bottom ;

        public Node(int d){
            data = d ;
            next = null ;
            bottom = null ;
        }
    }

   static Node head ;


   // overall time comp is : o(n*m) and space is o(1).

   // simply merge it.
   public static Node mergeTwoSorted_list(Node a, Node b) {
      
    Node result = new Node(-1);
    Node temp = result;

    while (a != null && b!= null) {
        if(a.data < b.data){   // here we add it to the bottom.
            temp.bottom = a;
            temp = temp.bottom;
            a = a.bottom;
        }
        else{
            temp.bottom = b;
            temp = temp.bottom;
            b = b.bottom;
        }
    }

    if( a != null){
        temp.bottom = a ;
    }
    else{
        temp.bottom = b ;
    }

    return result.bottom;
   }

   public static Node flatning(Node root) {
       if(root == null || root.next == null){
           return root;
       }

       root.next = flatning(root.next);

       root = mergeTwoSorted_list(root, root.next); // here returning one merge linked list.



    return root;
   }




    public static void main(String[] args) {
        
    }
}

package Problem_Of_The_day ;

public class Q37_Add_1_to_a_number_represented_as_linked_list {

    static class Node {
        int data ; 
        Node next ; 

        Node(int x ){
            data = x ;
            next = null ;
        }
    }


    public static void main(String[] args) {
        
        Node root = new Node(9) ;
        root.next = new Node(9) ;
        root.next.next = new Node(9) ;
        root.next.next.next = new Node(9) ;

        printLL(root);

        // Node newRoot = reverseLL(root) ;

        // printLL(newRoot);

        Node newRoot = addOne(root) ;

        printLL(newRoot);

    }

    public static void printLL(Node n) {

        if(n == null) return;

        while (n != null) {
            System.out.print( n.data + " -> " );
            n = n.next ;
        }
        System.out.println();
    }

    public static Node reverseLL(Node node){

        if(node == null || node.next == null) return node ;

        Node curr = node ;
        Node prev = null ;

        while (curr != null) {
            Node temp = curr.next ;
            curr.next = prev ;
            prev = curr ;
            curr = temp ;
        }

        return prev ;
    }


    public static Node addOne(Node head) 
    { 

        Node reversed = reverseLL(head) ;

        Node cNode = reversed ;
       
        while (cNode != null) {
            
            if(cNode.data < 9){
                cNode.data = cNode.data + 1 ;
                break ;
            }
            else if(cNode.data == 9 && cNode.next != null ){
                cNode.data = 0 ;
            }
            else if(cNode.data == 9 && cNode.next == null){
                cNode.data = 0 ;
                cNode.next = new Node(1) ;
                break ;
            }

            cNode = cNode.next ;
        }

        head = reverseLL(reversed) ;

        return head ;
    }

}
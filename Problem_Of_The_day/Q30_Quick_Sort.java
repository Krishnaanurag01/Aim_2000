package Problem_Of_The_day;


public class Q30_Quick_Sort {

    static class Node
{
    int data;
    Node next;
    Node(int key)
    {
        data = key;
        next = null;
    }
    
}

    public static void printLL(Node root) {
        
        if (root == null) {
            System.out.println("Empty!");
            return ;
        }

        Node temp = root ;

        while (temp != null) {
            System.out.println(temp.data);
            temp = temp.next ;
        }
    }

    static Node head ;

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


    public static int getLength(Node node ) {
    
        Node temp = node ;
        int len = 0 ;

        while (temp != null) {
            len++ ;
            temp = temp.next ;
        }

        return len ;

    }

    public static Node[] quickSort(Node node)
    {
        
        if (node == null || node.next == null) {
            return new Node[]{node , node } ;
        }

        int length = getLength(node) ;
        int pivotIndex = length/2 ;

        Node[] segrNodes = segregateList(node,pivotIndex) ;

        Node[] left = quickSort(segrNodes[0]) ;
        Node[] right = quickSort(segrNodes[2]) ;

        return merge_two_ll(left,segrNodes[1],right) ;
    }

    private static Node[] merge_two_ll(Node[] left, Node Pivot, Node[] right) {

        Node head = null ;
        Node tail = null ;

        if(left[0] != null && right[0] != null){
            head = left[0] ;
            left[1].next = Pivot ;
            Pivot.next = right[0] ;
            tail = right[1] ;
        }
        else if(left[0] != null){
            head = left[0] ;
            left[1].next = Pivot ;
            tail = Pivot ;
        }
        else if(right[0] != null){
            Pivot.next = right[0] ;
            head = Pivot ;
            tail = Pivot ;
        }
        else{
            head = tail = Pivot ;
        }


        return new Node[]{head,tail};
    }

    private static Node[] segregateList(Node node, int pivotIndex) {
        if(node == null || node.next == null){
            return null ;
        }


        Node pivotNode = node ;

        while (pivotIndex-- > 0) {
            pivotNode = pivotNode.next ;
        }


        Node left_smaller = new Node(-1) ;
        Node sp = left_smaller ;

        Node right_larger = new Node(-1) ;
        Node lp = right_larger ;

        Node temp = node ;

        while (temp != null) {
            if(temp != pivotNode){
                int data = temp.data ;

                if (data <= pivotNode.data) {
                    sp.next = temp ;
                    sp = sp.next ;
                }
                else{
                    lp.next = temp ;
                    lp = lp.next ;
                }
            }

            temp = temp.next ;
        }

        left_smaller = left_smaller.next ;
        right_larger = right_larger.next ;

        sp.next = null ;
        lp.next = null ;

        pivotNode.next = null ;


        return new Node[]{left_smaller,pivotNode,right_larger};
    }


    public static void main(String[] args) {
        
        Q30_Quick_Sort ll = new Q30_Quick_Sort() ;

        ll.insertNode(3);
        ll.insertNode(13);
        ll.insertNode(-3);
        ll.insertNode(1);
        ll.insertNode(5);
        ll.insertNode(-14);
        ll.insertNode(0);

        // Node newHead = quickSort(ll.head)[0];

        // printLL(newHead);

    }
    
    
}

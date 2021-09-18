package Binary_Search_Tree;

public class Q17_kth_smallest_element_in_BST_taking_constant_space {

    Node root;

    public static class Node {

        int data;
        Node left, right;
        public Node(int d) {
            this.data = d;
        }

    }

    
    public void insert_node(int data) {
        root = insert_node(root, data);
    }

    public static Node insert_node(Node root, int data) {
        if (root == null) {
            root = new Node(data);
            return root;
        }

        if (root.data > data) {
            root.left = insert_node(root.left, data);
        } else {
            root.right = insert_node(root.right, data);
        }

        return root;
    }



//     Expected Time Complexity: O(N).
// Expected Auxiliary Space: O(1).


/// everything is same as Q17 , we just printing the data and increamenting the count variable. 
    public static int get_kth_element(Node root , int k ) {
        
        if(root == null) return -1 ;

        int count = 0 ;
        Node current = root ;

        while (current != null) {
        Node left = current.left ;

        if(left == null){
            // this is left .
            count++ ;
            if(count == k) return current.data ;
            current = current.right ;
        }
        else{
            Node rightmost_node = getRightMostNode(left,current) ;

            if(rightmost_node.right == null){
               rightmost_node.right = current ;
               current = current.left ;
            }
            else{
                // this is right.
                rightmost_node.right = null ;
                count++ ;
                if(count == k) return current.data ;
                current = current.right ;
            }
        }
            
        }

        return -1 ;
    }








    private static Node getRightMostNode(Node node, Node root) {

        while(node.right != null && node.right != root){
            node= node.right ;
        }
        return node;
    }





    public static void main(String[] args) {
        
    }
    
}

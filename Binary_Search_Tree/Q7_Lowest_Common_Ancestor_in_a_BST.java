package Binary_Search_Tree;

public class Q7_Lowest_Common_Ancestor_in_a_BST {

    
    Node root;

    public static class Node {

        int data;
        Node left, right;
        Node next ;
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

    // Expected Time Complexity: O(Height of the BST).
// Expected Auxiliary Space: O(Height of the BST).  

// same logic which we applied in the binary tree.

    public static Node getLCS(Node root , int n1 , int n2) {
        if(root == null || root.data == n1 || root.data == n2){
            return root;
        }

        Node left = getLCS(root.left, n1, n2);
        Node right = getLCS(root.right, n1, n2) ;

        if(left == null){
            return right ;
        }
        else if(right == null){
            return left ;
        }

        return root ;
    }
    





    public static void main(String[] args) {

        Q7_Lowest_Common_Ancestor_in_a_BST tree = new Q7_Lowest_Common_Ancestor_in_a_BST() ;

        
        tree.insert_node(50);
        tree.insert_node(30);
        tree.insert_node(20);
        tree.insert_node(40);
        tree.insert_node(70);
        tree.insert_node(60);
        tree.insert_node(80);

        System.out.println( getLCS(tree.root, 20, 30).data );
        
    }
}

package Binary_Search_Tree;

public class Q2_Delete_Node_in_a_BST {

    Node root;

    /**
     * Node
     */
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

    public static void inorder(Node root) {

        if (root != null) {
            inorder(root.left);
            System.out.print(root.data + " ");
            inorder(root.right);
        }

    }

    public static Node delete_node_in_bst(Node root, int key) {
        if (root == null)
            return null;

        if (root.data == key) {  // when root is the node to delete then directly send to the delete_next function and return its output.
            return delete_next(root, key);
        }

        Node dummy = root; // backup

        while (root != null) { // otherwise run a loop

            if (root.data > key ) { // check if data lies in left side.
                if ( root.left != null && root.left.data == key) { // when left not null and mathes then perform this otwerise go to the left

                   root.left =  delete_next(root.left, key);
                } else {
                    root = root.left;
                }
            } else if (root.data < key ) { // or in right side
                if (root.right != null && root.right.data == key) { //when right not null and mathes then perform this otwerise go to the right

                   root.right =  delete_next(root.right, key);

                } else {
                    root = root.right;
                }
            }

        }
        return dummy;

    }

    private static Node delete_next(Node root, int key) {

        if (root.left == null) { // when left is null then directly add right part and vice versa
            return root.right;
        } else if (root.right == null) {
            return root.left;
        }

        Node root_right = root.right; // took right part backup.

        Node left_greatest = find_lefts_greatest(root.left); // find the lefts greatest element. and adding root_right to its right becuase right part contains only larger only than root.
        left_greatest.right = root_right;

        root = root.left; // then simply return the root.

        return root;

    }

    private static Node find_lefts_greatest(Node root) {
        if (root.right == null) { // this will be our largest value.
            return root;
        }
        return find_lefts_greatest(root.right);
    }

    public static void main(String[] args) {

        Q2_Delete_Node_in_a_BST tree = new Q2_Delete_Node_in_a_BST() ;

        tree.insert_node(50);
        tree.insert_node(30);
        tree.insert_node(20);
        tree.insert_node(40);
        tree.insert_node(70);
        tree.insert_node(60);
        tree.insert_node(80);

        inorder(tree.root);

       Node root = delete_node_in_bst(tree.root, 20);

        inorder(root);

    }
}

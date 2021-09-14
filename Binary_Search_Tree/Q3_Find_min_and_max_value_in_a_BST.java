package Binary_Search_Tree;


public class Q3_Find_min_and_max_value_in_a_BST {

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


    public static int minimum_element_in_bst(Node root ) {

        if(root.left ==  null){
            return root.data;
        }
        
        return minimum_element_in_bst(root.left);
    }


    public static int largest_element_in_bst(Node root) {
        if(root.right ==  null){
            return root.data;
        }

        return largest_element_in_bst(root.right) ;
    }










    public static void main(String[] args) {

        Q3_Find_min_and_max_value_in_a_BST tree = new Q3_Find_min_and_max_value_in_a_BST();

        tree.insert_node(50);
        tree.insert_node(30);
        tree.insert_node(20);
        tree.insert_node(40);
        tree.insert_node(70);
        tree.insert_node(60);
        tree.insert_node(80);

        System.out.println(minimum_element_in_bst(tree.root));
        System.out.println(largest_element_in_bst(tree.root));
        
    }
    
}

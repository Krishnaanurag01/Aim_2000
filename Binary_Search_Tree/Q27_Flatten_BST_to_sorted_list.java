package Binary_Search_Tree;

public class Q27_Flatten_BST_to_sorted_list {
    
    
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


    public static void flattening_bst_to_list(Node root,Node prev) {
        if(root == null ) return ;

        flattening_bst_to_list(root.left, prev);

        prev.right = root;
        root.left = null;
        prev = root ;

        flattening_bst_to_list(root.right, prev);

    }







    public static void main(String[] args) {
        
    }
}

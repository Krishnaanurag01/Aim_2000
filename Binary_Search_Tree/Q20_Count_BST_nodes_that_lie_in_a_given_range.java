package Binary_Search_Tree;

public class Q20_Count_BST_nodes_that_lie_in_a_given_range {
    

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

    static int count = 0 ;

    public static void Inorder(Node root , int low , int high) {
        if(root == null) return ;

        Inorder(root.left, low, high);

        if(root.data >= low && root.data <= high ){
            count++;
        }

        Inorder(root.right, low, high);
    }



    public static void main(String[] args) {

        Q20_Count_BST_nodes_that_lie_in_a_given_range tree = new Q20_Count_BST_nodes_that_lie_in_a_given_range() ;

        // tree.insert_node(5);
        // tree.insert_node(3);
        // tree.insert_node(2);
        // tree.insert_node(4);
        tree.insert_node(1);

        tree.insert_node(5);
        // tree.insert_node(6);
        // tree.insert_node(8);
        tree.insert_node(4);

        Inorder(tree.root, 7, 9);

        System.out.print(count);
        
    }
}

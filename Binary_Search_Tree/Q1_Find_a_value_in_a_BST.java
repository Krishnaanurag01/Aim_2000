package Binary_Search_Tree;

public class Q1_Find_a_value_in_a_BST {

    Node root ;
    /**
     * Node
     */
    public static class Node {

        int data ;
        Node left , right ;


       public Node(int d){
            this.data = d ;
        }
        
    }

    public void insert_node(int data) {
       root = insert_node(root, data) ;
    }


    public static Node insert_node(Node root ,int data) {
        if(root == null){
            root = new Node(data);
            return root ;
        }

        if(root.data > data){
            root.left = insert_node(root.left ,data);
        }
        else{
            root.right = insert_node(root.right ,data) ;
        }

        return root ;
    }

    public static void inorder(Node root) {

        if(root != null){
            inorder(root.left);
            System.out.print(root.data+" ");
            inorder(root.right);
        }
        
    }



    public static Node search_key(Node root , int key) {
        if(root == null || root.data == key){ // when root is null then return , otherwise if data is equal then return as well
            return root ;
        }

        if(root.data < key){ // otherwise loook at the right side and return the node.
            return search_key(root.right, key);
        }

        return search_key(root.left, key); // looking left side.
    }







    public static void main(String[] args) {

        Q1_Find_a_value_in_a_BST tree = new Q1_Find_a_value_in_a_BST() ;

        tree.insert_node(50);
        tree.insert_node(30);
        tree.insert_node(20);
        tree.insert_node(40);
        tree.insert_node(70);
        tree.insert_node(60);
        tree.insert_node(80);

        System.out.println(search_key(tree.root,40));

        
    }
    
}

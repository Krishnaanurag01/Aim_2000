package Binary_Search_Tree ;



/**
 * BST
 */
public class BST {


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
        if(root == null){ // when root is null then make a new node of given data and return
            root = new Node(data);
            return root ;
        }

        if(root.data > data){ // when root data is greater than we have to insert new node on left side.
            root.left = insert_node(root.left ,data);
        }
        else{// otherwise insert on the right side.
            root.right = insert_node(root.right ,data) ;
        }

        return root ; // return root;
    }

    public static void inorder(Node root) {

        if(root != null){
            inorder(root.left);
            System.out.print(root.data+" ");
            inorder(root.right);
        }
        
    }

















    public static void main(String[] args) {

        BST tree = new BST() ;

        tree.insert_node(50);
        tree.insert_node(30);
        tree.insert_node(20);
        tree.insert_node(40);
        tree.insert_node(70);
        tree.insert_node(60);
        tree.insert_node(80);

        inorder(tree.root);
        
    }
}
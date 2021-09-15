package Binary_Search_Tree;


public class Q6_Populate_Inorder_Successor_for_all_nodes {

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



    static Node prev  ; // by default null.
    
    
    public static void pointSucc(Node root ){
        if(root == null){
            return ; // when reach null return
        }
        
        pointSucc(root.left) ;  // inorder traversal
        
        if(prev != null){ // when not null then point previous.next to root // means point previous node successor to current node.
            prev.next= root ;
        }
        
        prev = root ; // updating the root.
        
        pointSucc(root.right) ; // going right
    }







    public static void main(String[] args) {
        
    }
    
}

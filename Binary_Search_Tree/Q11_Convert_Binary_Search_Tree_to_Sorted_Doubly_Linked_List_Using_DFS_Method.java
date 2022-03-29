package Binary_Search_Tree;

public class Q11_Convert_Binary_Search_Tree_to_Sorted_Doubly_Linked_List_Using_DFS_Method {

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





    // time is : o(n) and space is o(height of tree) [using recursive space].


    public static Node convert_BST_To_DLL(Node root) {

        if(root == null){
            return root ;
        }

        Node dummy = new Node(-1) ;  /// creating a dummy node.
        prev = dummy ;

        convert_BST_To_DLL_(root);  // now sending the given root .

        Node head = dummy.right ;  // copying the head of dll .

        dummy.right = head.left = null ; // making dummy null and  head.left which is -1 to null. 


        // do this when want to return doubly linked list.

        // head.left = prev ;
        // prev.right = head ;



        return head ;
    }

    static Node prev  ;

    public static void convert_BST_To_DLL_(Node root) {
        if(root == null) return ;
         
        // doing inorder traversal : it will give sorted ll.

        convert_BST_To_DLL_(root.left) ;

        // left is previous and right is next.

        root.left = prev ;  // root left will point to previous element 
        prev.right = root ; // previous right (means previous next) will point current node.
        prev = root ; // previous come to current node.


        convert_BST_To_DLL_(root.right);
    }












    public static void main(String[] args) {
        Q11_Convert_Binary_Search_Tree_to_Sorted_Doubly_Linked_List_Using_DFS_Method tree = new Q11_Convert_Binary_Search_Tree_to_Sorted_Doubly_Linked_List_Using_DFS_Method() ;


        tree.insert_node(50);
        tree.insert_node(30);
        tree.insert_node(20);
        tree.insert_node(40);
        tree.insert_node(70);
        tree.insert_node(60);
        tree.insert_node(80);

    }
    
}

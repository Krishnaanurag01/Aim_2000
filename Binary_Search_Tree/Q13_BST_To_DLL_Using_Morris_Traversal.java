package Binary_Search_Tree;


public class Q13_BST_To_DLL_Using_Morris_Traversal {
    
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




    // taking only : o(n) time with o(1) space.

    public static Node BST_To_Dll(Node root) {
        if(root == null) return null;

        Node dummy = new Node(-1) ;
        Node prev = dummy ;

        Node current  = root ;

        while (current != null) { // run untill now null.
            
            if(current.left == null){ // if left is null then add it to the prev.

                prev.right = current ;  
                current.left = prev ;
                prev = current ;

                current = current.right ;
            }
            else{

                Node RightMostNode = getRightMostNode(current.left,current) ; // look for the right most node.

                if(RightMostNode.right == null){
                    // means it is the right most node and there's no thread with root.
                    RightMostNode.right = current ; 

                    // now go to current left and do all the operations.
                    current = current.left ;
                }
                else{
                    // means we already have a thread with root.
                    // here we are adding thr right node to out linked list.

                    RightMostNode.right = null ;

                    prev.right = current ;
                    current.left = prev ;

                    prev = current ;

                    // now we traversed the left side of current so we'll move to the right side.
                    current = current.right ;
                }
            }
        }

        Node head = dummy.right ;

        dummy.right = head.left = null  ;

        // when want to return circular dll then do this.

        // head.left = prev ;
        // prev.right = head ;

        return head ;
    }



    private static Node getRightMostNode(Node root2, Node current) {

        while (root2.right != null && root2.right != current) { // finding the right most node. when next node is null or equal to root (current ) then return it.
            root2 = root2.right ;
        }
        return root2;
    }




    public static void main(String[] args) {
        
    }
}

package Binary_Search_Tree;

import java.util.LinkedList;


public class Q12_BST_to_DLL {

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


    
    public static void preOrder(Node root) {  // this will not work here as we convert it to the dll.
        if(root == null) return ;

        System.out.print(root.data +" ");
        preOrder(root.left);
        preOrder(root.right);
    }


    // same logic as before with o(n) time and space. 
    // Iterative way.


    public static Node convert_BST_To_DLL(Node root) {
        if(root == null) return null ;

        Node newHead = new Node(-1) ; // making a new dummy head.
        Node prev = newHead ;

        LinkedList<Node> stack = new LinkedList<>() ; // and using a stack

        addAllTheLeftNodes(root, stack); // first adding all the node of left side.

        while (stack.size() != 0) {
            Node current = stack.removeFirst() ; // now removing stack top node and connecting with prev.right(next) 
            // and current left is prev and then updating the prev. after that checking if node right has any left child then adding it.

            prev.right = current ;
            current.left = prev ;
            prev = current ;

            addAllTheLeftNodes(current.right, stack);
        }

        /// now  removing the -1 node.

       Node head = newHead.right ;

        head.left = newHead.right = null ;

        return head ;

    }




    public static void addAllTheLeftNodes(Node root,LinkedList<Node> stack) {

        while (root != null) {
            stack.addFirst(root);
            root = root.left ;
        }
    }













    public static void main(String[] args) {

        Q12_BST_to_DLL tree = new Q12_BST_to_DLL();

        tree.insert_node(50);
        tree.insert_node(30);
        tree.insert_node(20);
        tree.insert_node(40);
        tree.insert_node(70);
        tree.insert_node(60);
        tree.insert_node(80);


        // Node root = convert_BST_To_DLL(tree.root) ;

    

        
    }
    
}

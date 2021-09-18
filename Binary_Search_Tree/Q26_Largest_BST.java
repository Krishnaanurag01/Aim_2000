package Binary_Search_Tree;

public class Q26_Largest_BST {

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


    // Expected Time Complexity: O(N).
// Expected Auxiliary Space: O(Height of the BST).

// making a custom pair class.

     static class Pair{
        boolean isBst ;  // this will store wheather the current node is bst or not.
        int min ;  // will store min value from current bst.
        int max ;   // will store max value from current bst.
        Node root ;  // this will store the root which is bst and will keep updating itself when bst node with larger size comes.
        int size ; // this will store the size of bst.

    }

    public static Pair Largest_BST(Node root) {
        if(root == null){ // when null then return a pair.
            Pair pair = new Pair() ;
            pair.min = Integer.MAX_VALUE ;  // this is identity of min value.
            pair.max = Integer.MIN_VALUE ; // this is indentity of max value.
            pair.isBst = true ; // null pair is bst.
            pair.root = null ; // and root is null for null.
            pair.size = 0 ;  // null have size 0
            
            return pair ;
        }
        // doing post order.

        Pair left_pair = Largest_BST(root.left);
        Pair right_pair = Largest_BST(root.right);

        Pair mp = new Pair() ; // making a pair.

        mp.isBst = left_pair.isBst && right_pair.isBst &&(left_pair.max < root.data && right_pair.min > root.data); // this will true when both left and right is bst and left max is smaller than root and right min is larger than root.
        mp.min = Math.min( root.data, Math.min(left_pair.min, right_pair.min)) ;  // will store the min value from left , root, right.
        mp.max = Math.max( root.data, Math.max(left_pair.max, right_pair.max)) ;  // will store the max value from left , root, right.

        if(mp.isBst){  /// when our pair is bst then
            mp.root = root ; // root will be our current node.
            mp.size = left_pair.size + right_pair.size + 1 ; // and storing size.
        }
        else if(left_pair.size > right_pair.size){  // o\w if left part is larger then it will store left data.
            mp.root = left_pair.root ;
            mp.size = left_pair.size ;
        }
        else{  // else store right data
            mp.root = right_pair.root ;
            mp.size = right_pair.size ;
        }

        /// and then return the pair.
        return mp;
    }











    public static void main(String[] args) {

        Q26_Largest_BST tree = new Q26_Largest_BST() ;

        tree.insert_node(8);
        tree.insert_node(5);
        tree.insert_node(2);
        tree.insert_node(3);
        tree.insert_node(7);
        tree.insert_node(11);
        tree.insert_node(4);

        System.out.println( Largest_BST(tree.root).size );
    }
    
}

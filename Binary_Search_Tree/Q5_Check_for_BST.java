package Binary_Search_Tree;

public class Q5_Check_for_BST {

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



    public static void check_if_bst(Node root,Node prev, int[] f) {
      if(root == null) return ;

      check_if_bst(root.left, prev, f) ;

      if(prev != null && root.data <= prev.data){
          f[0] = 0;
          return ;
      }

      check_if_bst(root.right, prev, f) ;
    }





    public static void main(String[] args) {

        Q5_Check_for_BST tree = new Q5_Check_for_BST() ;

        tree.insert_node(50);
        tree.insert_node(30);
        tree.insert_node(20);
        tree.insert_node(40);
        tree.insert_node(70);
        tree.insert_node(60);
        tree.insert_node(80);

      int[] f = new int[1] ;
      f[0] = 1 ;

      Node prev = null ;
      check_if_bst(tree.root, prev, f);

      System.out.println(f[0]);
        
    }
    
}

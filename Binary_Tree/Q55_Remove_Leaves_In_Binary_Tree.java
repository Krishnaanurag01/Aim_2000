package Binary_Tree;

public class Q55_Remove_Leaves_In_Binary_Tree {

    public static class Node {
        int data;
        Node left;
        Node right;
    
        Node(int data, Node left, Node right) {
          this.data = data;
          this.left = left;
          this.right = right;
        }
      }

    
      public static Node removeLeaves(Node node){
        
        if(node == null ){
          return node ;
        }
        if(node.left == null && node.right == null){
          return null ;
        }
        node.left = removeLeaves(node.left) ;
        node.right = removeLeaves(node.right) ;
    
        return node;
      }    
}

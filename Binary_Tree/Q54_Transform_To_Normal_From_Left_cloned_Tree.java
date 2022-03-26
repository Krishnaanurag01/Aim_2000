package Binary_Tree;

public class Q54_Transform_To_Normal_From_Left_cloned_Tree {
    
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
    
      public static Node transBackFromLeftClonedTree(Node node){
        // write your code here
    
        if(node == null){
          return node ;
        }
    
        if(node.left != null) 
        node.left = node.left.left ; // removing left by assigning current left to it's lefts left.
    
        transBackFromLeftClonedTree(node.left) ;
        transBackFromLeftClonedTree(node.right) ;
    
        return node ;
      }
}

package Binary_Tree;

public class Q53_Transform_To_Left_cloned_Tree {

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

      public static Node createLeftCloneTree(Node node){
        
        if(node == null){
          return  node ;
        }
    
        createLeftCloneTree(node.left) ;
        createLeftCloneTree(node.right) ;
    
        if(node.left != null ){
    
          Node lchild = node.left ; // creating a new node with value same as current node and also giving current node child to new node left child.
          Node nNode = new Node(node.data, lchild,null) ;
          node.left = nNode ; // now attaching in left side of current node.
        }
        else if(node.left == null){
          Node nNode = new Node(node.data,null,null) ; // just simply create a duplicate node and attach to nodes left 
          node.left = nNode ;
        }
    
        return node ;
      }
    
}

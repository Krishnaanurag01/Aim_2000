package Binary_Tree;

public class Q69_Convert_Sorted_Doubly_Linked_List_To_Binary_Search_Tree {


    public static class Node
    {
      int val = 0;
      Node left = null;
      Node right = null;
  
      Node(int val) {
        this.val = val;
      }
    }
  
    static Node getMid(Node node) { // slow and fast pointer approch for finding the mid node
        
        if(node ==  null || node.right == null) return node ;
        
        Node slow = node ;
        Node fast = node ;
        
        while(fast.right != null && fast.right.right != null){
            fast = fast.right.right ;
            slow = slow.right ;
        }
        
        return slow ;
    }
  
    // left : prev, right : next
    public static Node SortedDLLToBST(Node head) {
        
        if(head == null || head.right == null) return head ;
        
        Node midNode = getMid(head) ; // getting the mid node
        Node prev = midNode.left ; // getting mids left
        Node forw = midNode.right ; // mids right
        
        if(prev != null) prev.right = null ; // now breaking the connections from prev to mid
        if(forw != null) forw.left = null ;  // from forw to mid
        midNode.left = midNode.right = null ; // from mid to both prev and next.
        
        midNode.left = SortedDLLToBST(prev) ; // now assing mids left with prevs root
        midNode.right = SortedDLLToBST(forw) ; // and same for right
        
      return midNode;
    }
    
}

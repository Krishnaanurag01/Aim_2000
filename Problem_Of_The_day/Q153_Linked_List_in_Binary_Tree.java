package Problem_Of_The_day;
import java.util.*;

public class Q153_Linked_List_in_Binary_Tree {


    // BFS + DFS : faster

    public boolean isSubPath(ListNode head, TreeNode root) {
        
        LinkedList<TreeNode> q = new LinkedList<>() ;
        q.add(root) ;
        
        while(q.size() > 0){
            int size = q.size() ;
            while(size-- > 0){
                TreeNode rn = q.removeFirst() ;
                if(rn.val == head.val){ // if found current treenode with same node as linkedlist head then this node could lead us to complete ll so check it with dfs and if its true then return directly
                    if(helper(rn,head)) return true ;
                }
                
                if(rn.left != null){
                    q.add(rn.left) ;
                }
                
                if(rn.right != null){
                    q.add(rn.right) ;
                }
            }
        }
    
        return false ;
    }
    
    
    
    boolean helper(TreeNode root, ListNode node){
        if(node == null) return true ;
        if(root == null) return false;
        
        
        if(root.val != node.val) return false;
            
            if(node.next== null) return true ;
            
            if(root.left != null && root.left.val == node.next.val){
                if(helper(root.left,node.next)) return true ;
            }
            
            if(root.right != null && root.right.val == node.next.val){
                if(helper(root.right,node.next)) return true ;
            }
        
        return false;
    }





    
    // DFS : gives TLE
    public boolean isSubPath2(ListNode head, TreeNode root) {
     
        return helper(root,head,head) ;
    }
    
    boolean helper(TreeNode root, ListNode head, ListNode ohead){
        if(head == null) return true;
        if(root == null) return false;
        
        if(root.val == head.val){
            if(head.next== null) return true ;
            
            if(root.left != null && root.left.val == head.next.val){
                if(helper(root.left,head.next,ohead)) return true ;
            }
            
            if(root.right != null && root.right.val == head.next.val){
                if(helper(root.right,head.next,ohead)) return true ;
            }
        }
        
        if( helper(root.left, ohead, ohead) ) return true ;
        if( helper(root.right, ohead, ohead) ) return true ;

        return false;
    }



    

  public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
 

  public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }
 
}

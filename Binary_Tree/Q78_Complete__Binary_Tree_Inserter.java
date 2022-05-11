package Binary_Tree;
import java.util.*;

public class Q78_Complete__Binary_Tree_Inserter {
    
}

class TreeNode {
     int val;
     TreeNode left,right;
     TreeNode() {}
     TreeNode(int val) { this.val = val; }
     TreeNode(int val, TreeNode left, TreeNode right) {
         this.val = val;
         this.left = left;
         this.right = right;
     }
 }


 // brute force.

 /*

class CBTInserter {
    
    TreeNode root ;
    TreeNode curr ;
    

    public CBTInserter(TreeNode root) {
        this.root = root ;
        this.curr = root ;
    }
    
    public int insert(int val) { // using inorder traversal for insertion.
        TreeNode node = new TreeNode(val) ;
        
        LinkedList<TreeNode> q = new LinkedList<>() ;      
        q.add(curr) ;

        while(q.size() > 0){
            int size = q.size() ;
            while(size-- > 0){
                TreeNode rn = q.removeFirst() ;
                
                if(rn.left == null){
                    rn.left = node ;
                    // curr = rn ;
                    return rn.val ;
                }
                else{ q.add(rn.left) ;}
                
                if(rn.right == null){
                    rn.right = node ;
                    // curr = rn ;
                    return rn.val ;
                }
                else{ q.add(rn.right) ; }
            }
        }
        
        return curr.val ;
    }
    
    public TreeNode get_root() {
        return root ;
    }
}
*/


// optimal solution : 100% faster.

class CBTInserter {
    
    TreeNode root ;
    // this q will be derived from level order traversal.
     LinkedList<TreeNode> q;   // here we will pre store nodes which are capable of storing new childs.

    public CBTInserter(TreeNode root) {
        this.root = root ;

        // doing pre processing on given data.
        q = new LinkedList<>() ;
        // doing level order traversal.
        q.add(root) ;
        
        while(q.size() > 0){
            int size = q.size() ;
            boolean stop = false ;
            while(size-- > 0){
                TreeNode rn = q.getFirst() ; // get first element, we are not removing it because it could be potential to store one or two child.
                
                if(rn.left == null){ // if left child is null then rn is potential so just break it . all the rest nodes including the current node is potential to store more childrens.
                    stop = true ;
                    break ;
                }
                else{  // else if it has left child then add
                    q.add(rn.left)
                ;}
                
                // same as left child
                if(rn.right == null){
                    stop = true ;
                    break ;
                }
                else{ 
                    q.add(rn.right) ;
                }
                // if come here then current rn is not potential to store anymore child as it is full with two childs already.
                // so just remove it.
                q.removeFirst();
            }
            // we break we find first node with null childs.
            if(stop) break ;
        }
        
    }
    
    public int insert(int val) {
        TreeNode node = new TreeNode(val) ;
        
        if(q.getFirst().left == null){ // if first node of queue has no left child then add new node to as it's left
            q.getFirst().left = node ;
            q.add(node); // also add new child in the queue. becuase it has also potential to store childs in it.
            return q.getFirst().val ; // returning parents val
        }
        else{
            TreeNode rn = q.removeFirst() ; // else right child must be null because q contains nodes that has potential to store atleast one child
            rn.right = node ; // addiing to right
            q.add(node ); // also adding to q.
            return rn.val ;
        }    
    }
    
    public TreeNode get_root() {
        return root ;
    }
}






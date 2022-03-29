package Binary_Tree;
import java.util.*;

public class Q64_Binary_Search_Tree_Iterator {

    class TreeNode{
        int val ;
        TreeNode left,right ;
    }


    // using stack.

    class BSTIterator {
    
        // this stack will takes O(log n) space on avg case but when tree is queuetree then it will take o(n) space
        Stack<TreeNode> stack  ; // using stack becuase recursion also does use it and work in it.
    
        public BSTIterator(TreeNode root) {
            stack = new Stack<>() ;
            helper(root) ; // adding the root
        }
        
        void helper(TreeNode node){
            if(node == null) return ;
            
            // this will add node and all of its left childs.
            while(node != null) {
                stack.push(node) ;
                node = node.left ;
            }
        }
        
        public int next() { // just remove the top node and add its right
            TreeNode temp = stack.pop() ;
            helper(temp.right) ;
            return temp.val ;
        }
        
        public boolean hasNext() { // check whther the stack is empty or not.
            return stack.size() != 0 ;
        }
    }
    

    // using morris traversal : O(1) space.
    class BSTIterator2 {
    
        TreeNode curr ; // saving curr of marris traversal as static
    
        public BSTIterator2(TreeNode root) {
            this.curr = root ;
        }
        
        public TreeNode getRightMostNode(TreeNode rmd ){ // getting right most node.
            
            while(rmd.right != null && rmd.right != this.curr) rmd = rmd.right ;
            
            return rmd ;
        }
        
        // doing traversal technique and breaking everytime when we get one node.
        public TreeNode morrisTraversal(){
            TreeNode res = null ;
            
            while(curr != null){
                TreeNode left = this.curr.left ;
                
                if(left == null){
                    res = this.curr ; // got answer 
                    this.curr = this.curr.right ;
                    break ; // so break
                }
                else{
                    TreeNode rmd = getRightMostNode(left);
                
                    if(rmd.right == null){
                        rmd.right = this.curr ;
                        this.curr = this.curr.left ;
                    }
                    else{
                        res = this.curr; // got answer
                        rmd.right = null;
                        this.curr = this.curr.right ;
                        break ; // so break
                    }
                 }
            }
            
            return res;
        }
        
        public int next() {
            TreeNode ans = morrisTraversal() ;
            return ans.val ;
        }
        
        public boolean hasNext() {
            return curr != null ;
        }
    }
}

package Binary_Tree;

public class Q60_Construct_Binary_Tree_from_Preorder_and_Postorder_Traversal {

    public static class TreeNode {
        int data;
        TreeNode left,right ;    
        TreeNode(int data) {this.data = data ;}
      }
    

      // same as pre  - In , IN - post e.t.c just look for the pattern.

    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        
        // sending both orders with ranges.
        return helper(preorder,0,preorder.length - 1, postorder,0, postorder.length -1 ) ;
    }
    
    TreeNode helper( int[] pre, int pStart, int pEnd, int[] post, int poStart, int poEnd ){
        
        if(pStart > pEnd || poStart > poEnd) return null ; 

        
        TreeNode root = new TreeNode(pre[pStart]) ; // as preorder first val always root so making a root node and give it the first val of preorder.

        if(pStart == pEnd) return root ; // when preorder is of 1 length then return node o/w it will give out of bound due to 29th line condition.
        
        int rootsLeft = pre[pStart+1] ; // now picking the left child of root from preorder.
        int leftsIdx = poStart ; // and finding it's index in post order.
        while(post[leftsIdx] != rootsLeft) leftsIdx++ ;
        
        int totalLeftChild = leftsIdx - poStart + 1 ; // calculating total childs that are present in left side.
        
        // as used first idx of pre fo going with start+1, just draw a image and fingure out this ranges in copy and you'll get this.
        root.left = helper(pre, pStart+1 , pStart + totalLeftChild , post, poStart, leftsIdx ) ;
        root.right = helper(pre, pStart + totalLeftChild + 1  , pEnd , post, leftsIdx+1, poEnd - 1 ) ;
        
        return root ;
    }
}

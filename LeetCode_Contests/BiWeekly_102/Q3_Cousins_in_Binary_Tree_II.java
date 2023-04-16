package LeetCode_Contests.BiWeekly_102;

public class Q3_Cousins_in_Binary_Tree_II {
    
    public TreeNode replaceValueInTree(TreeNode root) {
        
        LinkedList<TreeNode> q = new LinkedList<>() ;
        HashMap<TreeNode,TreeNode> parent = new HashMap<>() ; // key is child and value is parent
        parent.put(root, null) ; // root parent is null
        
        HashMap<TreeNode,Integer> childSum = new HashMap<>() ; // key is parent and value is their child sum
        
        
        q.add(root) ;
        
        while(q.size() > 0){
            int size = q.size() ;
            int sum = 0; // find sum of all at current level 
            
            while(size-- > 0){
                TreeNode rn = q.removeFirst() ;
                sum += rn.val ;
                int childSUM = 0 ; // sum of both child of rn
                
                if(rn.left != null){
                    parent.put(rn.left, rn) ; // storing rn.lefts as key and parent is rn
                    childSUM += rn.left.val ;
                }
                
                if(rn.right != null){ // same as left part
                    parent.put(rn.right, rn) ;
                    childSUM += rn.right.val ;
                }
                
                childSum.put(rn, childSUM) ; // storing rn parents child sum
                q.add(rn) ; // adding back to q for storing answer in next loop
            }
            
            size = q.size() ;
            
            while(size-- > 0){
                TreeNode rn = q.removeFirst() ;
                
                if(parent.get(rn) == null){ // if node is root 
                    rn.val = 0 ;
                }
                else{
                    int temp = sum - childSum.get(parent.get(rn)) ; // get current node parent and then it's child sum and simply subtract from total sum
                    rn.val = temp ;
                }
                
                if(rn.left != null){
                    q.add(rn.left) ;
                }
                
                if(rn.right != null){
                    q.add(rn.right) ;
                }
            }
            
        }
        
        return root ;
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

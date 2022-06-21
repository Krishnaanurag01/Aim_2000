package Binary_Search_Tree;

public class Q35_Maximum_Sum_BST_in_Binary_Tree {

    class TreeNode{
        TreeNode left, right ;
        int val ;
    }
    
    public int maxSumBST(TreeNode root) {
     
        return helper(root)[3] ;
    }
    
     int[] helper(TreeNode root){
        if(root == null) return  new int[]{(int)1e9,(int)-1e9,0,0}; // min,max,currentSum,maxSumSoFar
        
        int[] left = helper(root.left) ;
        int[] right = helper(root.right) ;
        
        if(left[1] < root.val && root.val < right[0]){
            int sum = left[2] + right[2] + root.val ; // finding sum for current bst.
            int finalSum = Math.max(Math.max(left[3],right[3]),sum) ; // this is maxSumSoFar for current tree. comparing left and right maxssf and current sum.
             return new int[]{Math.min(root.val,left[0]),Math.max(right[1],root.val),sum,finalSum } ; 
        }
         ;
        
        return new int[]{(int)-1e9,(int)1e9,Math.max(left[2],right[2]) , Math.max(left[3],right[3]) } ; // returning with choosing the max sum and max sum so far.
    }
}

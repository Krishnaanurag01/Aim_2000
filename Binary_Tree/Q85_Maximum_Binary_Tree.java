package Binary_Tree;

public class Q85_Maximum_Binary_Tree {
    
    class TreeNode {
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

    TreeNode helper(int i, int j, int[] nums){  // i -> starting idx, j -> ending idx in array allowed.
        if(i > j) return null ;
        
        int max = -1;
        int idx = -1;
        // finding the max value and it's index.
        for(int k = i ; k <= j ; k++){
            if(nums[k] > max){
                max = nums[k] ;
                idx = k ;
            }
        }
        
        TreeNode node = new TreeNode(max); // making the root of current subtree
        node.left = helper(i,idx-1,nums); // assigning the left part
        node.right = helper(idx+1,j,nums); // assigning the right part
        return node;
    }


}

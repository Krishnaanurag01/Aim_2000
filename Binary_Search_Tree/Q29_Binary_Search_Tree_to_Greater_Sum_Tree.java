package Binary_Search_Tree;

public class Q29_Binary_Search_Tree_to_Greater_Sum_Tree {


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
    

    public TreeNode bstToGst(TreeNode root) {

        modify_(root) ;
           
           return root ;
       }
       
       int sum = 0 ;
       
        public void modify_(TreeNode root)
       {
           if(root == null) return  ;
           
           modify_(root.right) ; // first go to right.
           
           root.val += sum ; // now add previous sum with current val
           
           sum = root.val ; // now updating the new sum ( it includes the current val)
           
           modify_(root.left) ; // now going to left
           
       }
}

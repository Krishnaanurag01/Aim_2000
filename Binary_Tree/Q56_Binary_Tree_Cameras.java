package Binary_Tree ;

public class Q56_Binary_Tree_Cameras {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {}

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    // main function below : 

    /*
    -1 -> you need a camera
    0 -> you have a camera
    1 -> you are covered by some other nodes so you don't neeed cameras.
    */


    static int camera  ;
    public int minCameraCover(TreeNode root) {
        camera = 0 ;
        // if root needs a camera then buy one for it.
        return helper(root) == -1 ? camera + 1 : camera ;
    }
    
    public int helper(TreeNode node){
        
        if(node == null){
            return 1 ;
        }

        // start with bottom to top.
        
        int left = helper(node.left) ;
        int right = helper(node.right) ;
        
        if(left == -1 || right == -1){ // if any of my child need camera then i'll provide them covred by installing camera on ourselves
            camera++ ; // it will cover my parent and my child
            return 0 ; // means current node has camera
        }
        
        if(left == 0 || right == 0){ // if any of my node has camera so i;m getting covered by them
            return 1 ; // means current node is covered by the node who have camera
        }
        
        // when current node is not covered then it needs a camera.
        return -1 ; // else current node need camera
    }

}

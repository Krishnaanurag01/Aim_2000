package Binary_Tree;

public class Q82_Longest_Univalue_Path {


    class Pair{
        int data ;
        int height ;
        Pair(int data){
            this.data = data ; 
            this.height = 1; }  // assing height 1 by default
        Pair(int data, int h){
            this.data = data ;
            this.height = h ;
        }
        
    }
    
    static int max ;
    public int longestUnivaluePath(TreeNode root) {
        if(root == null) return  0 ;
        max = 0 ;
        helper(root) ;
        return max-1; // we got the max count of nodes so subtracting 1 will give us count of edges
    }
    
    Pair helper(TreeNode root){
        if(root == null) return new Pair(Integer.MAX_VALUE,0) ;
        
        
            Pair left = helper(root.left) ;
            Pair right = helper(root.right) ;
        
        Pair rootPair = new Pair(root.val) ;
     
        if(left.data == root.val && right.data == root.val){ // if both child has same data
            max = Math.max(max, left.height + right.height + 1) ; // update the max height(or count of data)
            rootPair.height =  Math.max(left.height, right.height )+1 ; // and also update the curren node height 
            return rootPair ; 
        }
        else if(left.data != root.val && right.data != root.val){ // if both are not equal
            max = Math.max(max , 1) ; // then just check the max 
            return rootPair ;  
        }
        else if(left.data == root.val){  // if left or right part is equal then find the max height
             max = Math.max(max, left.height + 1) ;
            rootPair.height += left.height  ; // and add left height in your height
            return rootPair ; 
        }
        else{
            max = Math.max(max, right.height + 1) ;
            rootPair.height += right.height ; // add right height in your height
            return rootPair ;
        }
       
        
    }
    
}

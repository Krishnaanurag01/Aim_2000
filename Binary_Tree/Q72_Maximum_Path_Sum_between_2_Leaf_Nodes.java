package Binary_Tree;

public class Q72_Maximum_Path_Sum_between_2_Leaf_Nodes {

    class Node{
        int data ;
        Node left,right ;
    }

    class Pair{
        int maxLtLpathSum = Integer.MIN_VALUE ;  // leaf to leaf max sum
        int maxNtLpathSum = Integer.MIN_VALUE ; // node to leaf max sum
    }
        
    int maxPathSum(Node root)
    {
       Pair ans = helper(root) ;
       return ans.maxLtLpathSum     ; // returning left to lead max sum
    } 
    
    Pair helper(Node root){
        
        if(root == null) return new Pair() ; // when null return empty pair
        
        if(root.left == null && root.right != null ){ // when it is leaf then create a node and assign node to leaf as current data . as this node cant make leaf to leaf combination.
            Pair p = new Pair() ;
            p.maxNtLpathSum = root.data ; //
            return p;
        }
        
        Pair lp = helper(root.left) ;
        Pair rp = helper(root.right);
        
        // making current node pair
        Pair rootPair = new Pair() ;
        rootPair.maxLtLpathSum = Math.max(lp.maxLtLpathSum, rp.maxLtLpathSum); // getting max leaf to leaf sum if any
        
        if(root.left != null && root.right != null ){ // and also creating our own leaf to leaf
            rootPair.maxLtLpathSum = Math.max(rootPair.maxLtLpathSum, lp.maxNtLpathSum + rp.maxNtLpathSum + root.data )  ;
        }
        
        /// updating the current node to leaf by choosing the max node to lead of children
        rootPair.maxNtLpathSum = Math.max(lp.maxNtLpathSum , rp.maxNtLpathSum) + root.data ;
        
        return rootPair ;
    }


    // heap hover method

    static int max ;
    int maxPathSum2(Node root)
    { 
        max = Integer.MIN_VALUE ;
        helper(root) ; 
        return max ;
    } 
    
    int helper2(Node node){
        if(node == null) return Integer.MAX_VALUE ;
        
        if(node.left == null && node.right == null) return node.data ;
        
        int ls = helper2(node.left) ;
        int rs = helper2(node.right) ;
        
        if(ls == Integer.MAX_VALUE && rs == Integer.MAX_VALUE)
        return node.data ;
        
        if(ls == Integer.MAX_VALUE)
        return rs + node.data ;
        
        if(rs == Integer.MAX_VALUE)
        return ls + node.data ;
        
        max = Math.max(max, ls + rs + node.data ) ; 
        
        return Math.max(ls,rs) + node.data ;
    }
    
}

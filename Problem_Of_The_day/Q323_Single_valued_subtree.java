package Problem_Of_The_day;

public class Q323_Single_valued_subtree {

    int count ; // using static var for counting single valued tree
    public int singlevalued(Node root)
    {
        count = 0 ;
        helper(root) ;
        return count ;
    }
    
    int helper(Node root){
        if(root == null) return 0 ; // when reach null return 0
        if(root.left == null && root.right == null){ // when leaf
            count++ ; // increase count as each leaf is itself a tree 
            return root.data ;
        } 
        
        int left = helper(root.left) ;
        int right = helper(root.right) ;
        
        if(left == -1 || right == -1) return -1; // when -1 comes either side means the tree already has more than 1 valu so directly return -1
    
    // when either of the side is null then it has value 0 so change it to root data
        if(left == 0){ 
            left = root.data ;
        }
        
        if(right == 0){
            right = root.data ;
        }
        
        // ans if all three value is same then increase the count and return
        if( left == right && right == root.data ){
            count++;
            return root.data ;
        }

// otherwise return -1 means no more tree is possibble
        return -1 ;
    }

    class Node{
        int data ;
        Node left,right ;
    }
}

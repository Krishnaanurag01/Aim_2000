package Problem_Of_The_day;

public class Q25_Maximum_difference_between_node_and_its_ancestor {

    static class Node {
    
        int data ;
        Node left , right ;

        Node(int val){
            data = val ;
            left = null ;
            right = null ;
        }
        
    }

    int ans  = Integer.MIN_VALUE ; // this will contain the answer.
    
    int maxDiff(Node root)
    {
       helper(root) ; /// using helper function.
       
       return ans ;
    }
    
    int helper(Node root){ 
        /// if node is null then return Max_value
        if(root == null ) return Integer.MAX_VALUE ;
        
        int left = helper(root.left) ;// getting min value from left and right
        int right = helper(root.right) ;
        
        ans = Math.max(ans , Math.max(root.data - left , root.data - right)) ; // updating answer.
        
        return Math.min(root.data , Math.min(left,right)) ; // and reuturning min value between current node , left min and right min.
    }
    
}

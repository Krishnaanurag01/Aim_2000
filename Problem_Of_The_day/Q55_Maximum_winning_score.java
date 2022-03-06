package Problem_Of_The_day;

public class Q55_Maximum_winning_score {

    static class Node {

        int data ;
        Node left ;
        Node right ;

        Node(int x ){
            data = x ;
            left = null ;
            right = null ;
        }
        
    }
    
    public static Long findMaxScore(Node root)
    {
        return helper(root) ;
    }
    
    static Long helper(Node node){
        
        if(node == null){
            return (long)1 ;
        }
        
        Long left = helper(node.left) ;
        Long right = helper(node.right) ;
        
        Long max  = Math.max(left,right) ;
        
        return max*node.data ;
    }

}

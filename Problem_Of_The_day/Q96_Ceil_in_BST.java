package Problem_Of_The_day;

public class Q96_Ceil_in_BST {

    class Node{
        int data ;
        Node left, right ;
    }
    
    int findCeil(Node root, int key) {
        if (root == null) return -1;
       
       int ans = helper(root,key) ;
       return ans == (int)1e9 ? -1 : ans ;
    }
    
    int helper(Node root, int key){
        if(root == null) return (int)1e9 ; // if reach null return max
        
        if(root.data == key) return root.data ; // if same val present then return 
        
        if(root.data < key ){ // if current value is lesser then go to right
            return helper(root.right,key) ; 
        }
        
        // otherwise choose the min between current and left value.
        return Math.min(root.data, helper(root.left,key)) ;
    }
}

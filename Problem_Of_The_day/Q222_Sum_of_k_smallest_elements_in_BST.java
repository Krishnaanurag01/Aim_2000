package Problem_Of_The_day;

public class Q222_Sum_of_k_smallest_elements_in_BST {

    int sum = 0;
    int m ;
    int sum(Node root, int k) { 
        m = k ;
        helper(root) ;
       return sum ;
    } 
    
    void helper(Node root){
        if(root == null) return ;
        if(m == 0) return;
        
        helper(root.left) ;
        if(m == 0) return ;
        sum += root.data ;
        m--;
        helper(root.right) ;
        
    }    

    class Node{
        int data ;
        Node left,right ;
    }
}


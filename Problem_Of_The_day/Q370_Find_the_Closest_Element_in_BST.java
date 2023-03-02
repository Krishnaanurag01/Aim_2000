package Problem_Of_The_day;

public class Q370_Find_the_Closest_Element_in_BST {

    static int ans ;
    static int minDiff(Node  root, int K) 
    { 
       ans = (int)1e9 ;
       helper(root,K);
       return ans ;
     } 
     
     // sare element is K ka difference nikal lo and return the least diff
    static void helper(Node root, int k){
        if(root == null) return  ;
         
        if(Math.abs(root.data - k ) < ans){
            ans =(int) Math.abs(root.data - k) ;
        }
         
         helper(root.left, k) ;
         helper(root.right, k) ;
     }

     class Node{
        int data ;
        Node left, right ;
     }
}

package Problem_Of_The_day;

public class Q338_Find_the_maximum_GCD_of_the_siblings_of_a_Binary_Tree {
    int maxGCD(Node root) {
        int[] ans = {0,0}; // idx 0 : root val and idx1 stores max GCD
        helper(root, ans) ;
        return ans[0] ;
   }
   
   void helper(Node root, int[] ans){
       if(root == null) return ;
       
       if(root.left != null && root.right != null){ // if have both child then check its gcd
           int temp = gcd(root.left.data, root.right.data) ;
           if(temp > ans[1]){
               ans[1] = temp ;
               ans[0] = root.data ;
           }
           else if(temp == ans[1]){
               ans[0] = Math.max(ans[0], root.data) ;
           }
       }
       
       helper(root.left, ans) ;
       helper(root.right, ans) ;
   }
   
   int gcd(int a, int b){
       if(b == 0) return a ;
       return gcd( b, a % b) ;
   }

   class Node{
    int data ;
    Node left, right ;
   }
}

package Problem_Of_The_day;

public class Q320_Largest_subtree_sum_in_a_tree {

    public static int findLargestSubtreeSum(Node root) {
        return helper(root)[1] ;
     }
     
     static int[] helper(Node root){
         if(root == null){
             return new int[2];
         }
         
         int[] left = helper(root.left) ; /// taking left sum  + ans so far
         int[] right = helper(root.right) ; // same from right
         
         int sum = left[0] + right[0] + root.data ; // now calculating current sum
         
         
         return new int[]{ sum , Math.max(Math.max(left[1],right[1]), sum) } ; // return sum with best of three answer sum.
     }

     class Node{
        int data ;
        Node left,right ;
     }
}

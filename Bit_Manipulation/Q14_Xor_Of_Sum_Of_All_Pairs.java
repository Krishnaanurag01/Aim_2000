package Bit_Manipulation;

import java.util.Scanner;

public class Q14_Xor_Of_Sum_Of_All_Pairs {

    public static int solution(int[] arr){
        //write your code here
 
        int res = 0  ;

        // if yor write all the pairs in paper and pen then you'll get to know every pair cancelling by doing xor with the same pair formed by another value.
        // only the arr[i] + arr[i] pair is not getting cancelled so can only consider 2*arr[i] as pair and do the xor operation.
 
        for(int val : arr){
            res = res ^ val ;
        }
        
        return 2*res;
     }
     public static void main(String[] args) {
         Scanner scn = new Scanner(System.in);
         int n = scn.nextInt();
         int[] arr = new int[n];
         for(int i = 0 ; i < n; i++){
             arr[i] = scn.nextInt();
         }
         System.out.println(solution(arr));
         scn.close();
     }
     
    
}

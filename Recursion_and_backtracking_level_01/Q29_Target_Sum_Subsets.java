package Recursion_and_backtracking_level_01;
import java.util.*;

public class Q29_Target_Sum_Subsets {

    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in) ;

        int n = sc.nextInt() ;

        int[] nums = new int[n] ;

        for(int i = 0 ; i < n ; i++){
            nums[i] = sc.nextInt() ;
        }

        int target = sc.nextInt() ;

        printTargetSumSubsets(nums,0,"",0,target) ;

        sc.close();

    }

    // set is the subset
    // sos is sum of subset
    // tar is target
    public static void printTargetSumSubsets(int[] arr, int idx, String set, int sos, int tar) {
        
        if(idx == arr.length){ // when all index is traversed
            if(sos == tar && set.length() != 0){ // when sum is equals to target then print subset path
                System.out.println(set+".") ;
            }
            return ;
        }

        printTargetSumSubsets(arr,idx+1, set + arr[idx] + ", " , sos + arr[idx] ,tar ); // including current number
        printTargetSumSubsets(arr,idx+1, set, sos ,tar ); // excluding current number

    }
    
}

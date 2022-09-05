package Problem_Of_The_day;

public class Q221_Smallest_sum_contiguous_subarray {

     // kadanes algorithm. (just change the max sum to min sum.)
     static int smallestSumSubarray(int a[], int size)
     {
         
         int bestSum = a[0] ;
         int currSum = a[0] ;
         
         for(int i = 1 ; i < a.length ; i++){
             int val = a[i] ;
             currSum += val ;
             
             if(currSum > val){
                 currSum = val ;
             }
             bestSum = Math.min(bestSum,currSum) ;
         }
         
         return bestSum ;
     }
}

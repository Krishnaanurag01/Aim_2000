package Problem_Of_The_day;
import java.util.*;

public class Q216_Range_Sum_of_Sorted_Subarray_Sums {

    public int rangeSum(int[] nums, int n, int left, int right) {
        
        // to find the sum of all continuous sub array, we are using gap strategy
        long[][] dp = new long[n][n] ;
        
        long[] newArr = new long[n*(n+1)/2] ;
        int k = 0 ;
        for(int g = 0 ; g < nums.length ; g++){
            for(int i = 0, j = g ; j < nums.length ; i++, j++){
                if(g == 0){
                   dp[i][j] = nums[i] ;
                   newArr[k++] = dp[i][j] ;
                }
                else if(g == 1){
                    dp[i][j] = add(nums[i] , nums[j]) ;
                    newArr[k++] = dp[i][j] ;
                }
                else{
                    dp[i][j] = add( add(nums[i] , nums[j]), dp[i+1][j-1]) ;
                    newArr[k++] = dp[i][j] ;
                }
            }
        }
        
        
        // now sorting the new Array. and summing up.
        Arrays.sort(newArr);
        long sum = 0 ;
            
        for(int i = left - 1 ; i < right ; i++){
            // System.out.println(newArr[i]) ;
            sum = add(sum,newArr[i]);
        }
            
        return (int)sum ;
    }
    
    
    // mod operations.
    int M = (int)1e9+7 ;
    
    long mod(long val){
        return ((val%M + M)%M);
    }
    
    long add(long a, long b){
        return mod(mod(a) + mod(b));
    }
}

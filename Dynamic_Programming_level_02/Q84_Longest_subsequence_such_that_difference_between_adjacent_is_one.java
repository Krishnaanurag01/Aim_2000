package Dynamic_Programming_level_02 ;

/**
 * Q84_Longest_subsequence_such_that_difference_between_adjacent_is_one
 */
public class Q84_Longest_subsequence_such_that_difference_between_adjacent_is_one {

    public static void main(String[] args) {
        

    }


    // Expected Time Complexity: O(N2)
    // Expected Auxiliary Space: O(N)

    static int longestSubsequence(int N, int A[]) /// same as LIS expect that In LIS we were finding the longest increasing suubsec and here we are finding the subseq with difference of 1 in adjecent.
    {
        int n = A.length ;
        
        if(n == 1){ // when array is of 1 length then simply return 1 as 1 element is of length 1.
            return 1 ;
        }
        
        int ans = 0 ;
        
        int[] dp = new int[n] ;
        
        for( int i = 0 ; i < n ; i++){
            
            int max = 0 ; /// this will have the max value .
            
            for( int j = 0 ; j < i ; j++){
                
                if(A[j] - A[i] == 1 || A[j] - A[i] == -1){ 
                    
                    max = Math.max(max,dp[j]) ;
                }
            }
            
            dp[i] = max + 1 ; // adding 1 for currrent value length + previous max suubsec length.
            
            ans = Math.max(ans,dp[i]) ; // also updating the ans concurrently.
        }
        
        return ans ;
    }
}

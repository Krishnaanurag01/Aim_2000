package Dynamic_Programming_level_02;

public class Q11_Longest_Increasing_Subsequence {

    public static void main(String[] args) {
        
    }


    // Expected Time Complexity : O( N*log(N) ) 
    // Expected Auxiliary Space: O(N)
    public static int get_LIS(int[] arr) {
        
        int n = arr.length ;
        if(n == 1){  // if array has only 1 element then it can make a sub sequence of 1 length only.
            return 1 ;
        }

        int[] dp = new int[n] ; // this will store for ith index, longest subsequence till ith element of array such that last number of sequence is arr[i] itself .

        int ans = 0 ; // this will contain the largest sub sequence

        for (int i = 0; i < dp.length; i++) {
            
            int max = 0 ; /// this will contain the max dp[0-(i-1)] value before current dp[i]

            for (int j = 0; j < i ; j++) {  // now check from 0 to i-1 index.
                if(arr[j] < arr[i]){ // if previous element of array is smaller than current element array then check for max.
                    // check if that element dp ( where longest subsequence till that element such that last number of sequence is arr[index] itself is stored) is l greater than max.
                    max = Math.max(max, dp[j]) ;
                }
            }

            dp[i] = max + 1 ; // now adding max with + 1 (as adding current element to the sequence.)
            ans = Math.max(ans,dp[i]) ; // updating answer.
        }

        return ans ;
        

    }
    
}

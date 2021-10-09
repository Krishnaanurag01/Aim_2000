package Dynamic_Programming_level_02;

public class Q56_Maximum_Sum_Of_MNon_Overlapping_Subarrays {

    public static void main(String[] args) {
        
    
    }


    public static int solution(int[] arr, int m, int k){
	
	
        int[] presum = new int[arr.length]; // making presum
        int sum = 0 ;
        for(int i = 0 ; i < k ; i++){ // finding the sum of k length
            sum += arr[i] ;
        }
        presum[0] = sum ; // storing it to the first index
        
        for(int i = k ,j = 0 ; i < arr.length ; i++,j++){ // now storing sum
            sum += arr[i] - arr[j]; // like sliding window
            presum[i-k+1] = sum ; 
        }
        
        
        int[][] dp = new int[arr.length][m+1];
            
            return get_max_sum(arr,0,m,k,presum,dp);

    }

    public static int get_max_sum(int[] arr , int index , int m , int k , int[] presum , int[][] dp ) {
        
        if(m == 0){ // when it becomes 0 then return
            return 0 ;
        }
        if(index >= arr.length){ // else if index becomes equal or greater then return
            return 0 ;
        }

        if(dp[index][m] != 0){ // if dp already has value then return
            return dp[index][m] ;
        }

        int exclude = 0 + get_max_sum(arr, index+1, m, k, presum , dp) ; /// when we exclude current value then call function with +1 index
        int include = presum[index] + get_max_sum(arr, index + k , m - 1 , k, presum, dp); // if we include current value then call function with m-1 and index + k (becuase index has sum of k length part)

        dp[index][m] =  Math.max(include, exclude ) ;  // storing to the array

        return Math.max(include, exclude ); // return max;

    }
    
}

package Dynamic_Programming_level_02;

public class Q95_Longest_alternating_subsequence {

    public static void main(String[] args) {
        
    }
    

    // time comp : O(n2)
    // space comp : O(n)
    public static int AlternatingaMaxLength(int[] arr)
    {
        // code here
        
        int n = arr.length  ;
        int[][] dp = new int[n][2] ; // making an dp of n length that have 2 columns.
        
        for(int i = 0 ; i < n ; i++){ /// storing 1 by default
            dp[i][0] = dp[i][1] = 1 ;
        }
        
        int ans = 0 ;
        
        for( int i = 0 ; i < n ; i++){
            
            for(int j = 0 ; j < i ; j++){  // like LIS
                
                // if current i value is larger and our dp[i][0] (it denotes rise ) is smaller than dp[j][1] (it denotes fall) then we add 1 with dp[j] fall value . this means theres now 2 alternate subseq number with low and high balance.
                if(arr[j] < arr[i] && dp[i][0] < dp[j][1] + 1){
                    dp[i][0] = dp[j][1] + 1 ;
                }// if current i value is smaller and our dp[i][1] (it denotes fall ) is smaller than dp[j][0] (it denotes rise) then we add 1 with dp[j] rise value . this means theres now 2 alternate subseq number with high and low balance.
                else if(arr[j] > arr[i] && dp[i][1] < dp[j][0] + 1){
                    dp[i][1] = dp[j][0] + 1 ;
                }
            }
            // updating answer everytime.
            ans = Math.max(ans, Math.max(dp[i][0],dp[i][1]));
        }
        
        return ans ;
    }

    // time comp  : O(n)
    // space comp : O(1)

    public int AlternatingaMaxLength2(int[] arr)
    {
      
        // took 1 by default for first element.
      int mr = 1 ; // this represents rise. 
      int mf = 1 ; // this represents fall.
      
      for( int i = 1 ; i < arr.length ;i++){
          if(arr[i] > arr[i-1]){ // if current element is greater than previous element then add 1 to the fall.
              mr = mf + 1  ;
          }
          else if(arr[i] < arr[i-1]){// if current element is smaller than previous element then add 1 to the rise.
              mf = mr + 1 ;
          }
      }
      
      return Math.max(mr,mf) ; // return max.
    }
}

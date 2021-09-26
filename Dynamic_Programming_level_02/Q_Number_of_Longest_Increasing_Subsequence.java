package Dynamic_Programming_level_02;

public class Q_Number_of_Longest_Increasing_Subsequence {

    public static void main(String[] args) {
        
        int[] nums = {1,3,5,4,7} ;

        System.out.println(findNumberOfLIS(nums));
    }
    
    public static int findNumberOfLIS(int[] arr) {
        
        int n = arr.length ;
        // this part is same as Q11.
        int[] dp = new int[n] ;

        int ans = 0 ;

        for (int i = 0; i < dp.length; i++) {
            
            int max = 0 ;

            for (int j = 0; j < i ; j++) {
                if(arr[j] < arr[i]){
                    max = Math.max(max, dp[j]) ;
                }
            }

            dp[i] = max + 1 ;
           if( dp[i] > ans){
               ans = dp[i] ;
           }
        }
        
        int total_ans = 0 ;
        
         for (int i = 0; i < dp.length; i++) {
            
            if(dp[i] == ans){

                total_ans++ ;
            }
        }
        
        return total_ans ;

    }
}

package Dynamic_Programming_level_02;

public class Q13_Maximum_sum_increasing_subsequence {
    

    public static void main(String[] args) {
        
    }


    // same concept as  LIS (Q11):
    public static void max_sum_lis(int[] arr,int n) {
        
        int[] dp = new int[n] ;
        int ans = 0 ;

        for(int i = 0 ; i < n ; i++){
            int max = 0 ;

            for(int j = 0 ; j < i ; j++){
                if(arr[j] < arr[i]){
                    max = Math.max(max, dp[j]) ;
                }
            }


            dp[i] = max + arr[i] ; // only difference from LIS is here. here we are adding arr[i] value.
            ans = Math.max(ans, dp[i]) ;
        }

        
    }
}

package Dynamic_Programming_level_02;

public class Q77_Knapsack_with_Duplicate_Items {
    
    public static void main(String[] args) {
        
    }

    public static int get_max_value(int[] val ,int[] wt , int n , int cap) {
        
        int[] dp = new int[cap+1] ;

        for(int i = 0 ; i < dp.length ; i++){ // it denotes bag capacity
            for (int j = 0; j < wt.length; j++) { // its the weight capacity
                if(i >= wt[j] && i - wt[j] >= 0 ){ // as we are checking in bag_capacity - wt[j] (this is remainning bag capacity)so made an checking .
                    // dp[i-wt[j]] = is remainning bag capacity + current value .
                    dp[i] = Math.max(dp[i], val[j] + dp[ i - wt[j] ] ) ;
                }
            }
        }

        return dp[cap] ;
    }
}

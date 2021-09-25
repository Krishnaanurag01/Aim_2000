package Dynamic_Programming_level_02;

public class Q_Knapsack_with_Duplicate_Items {
    
    public static void main(String[] args) {
        
    }

    public static int get_max_value(int[] val ,int[] wt , int n , int cap) {
        
        int[] dp = new int[cap+1] ;

        for(int i = 0 ; i < dp.length ; i++){
            for (int j = 0; j < wt.length; j++) {
                if(i >= wt[j] && i - wt[j] >= 0 ){
                    dp[i] = Math.max(dp[i], val[j] + dp[ i - wt[j] ]) ;
                }
            }
        }

        return dp[cap] ;
    }
}

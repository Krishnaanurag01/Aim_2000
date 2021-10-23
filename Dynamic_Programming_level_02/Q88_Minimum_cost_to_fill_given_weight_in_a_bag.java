package Dynamic_Programming_level_02;

public class Q88_Minimum_cost_to_fill_given_weight_in_a_bag {

    public static void main(String[] args) {
        int arr[] = {20, 10, 4, 50, 100} ;

        get_min_cost(arr, 5);
    }

    // need corrections.
    public static void get_min_cost(int[] cost , int w) {
        
        int[][] dp = new int[cost.length+1][w+1] ;

        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                
                if(i == 0 || j == 0){
                    dp[i][j] = 0 ;
                }
                else{
                    dp[i][j] = dp[i-1][j] ;
                    if(i <= j && j < dp[0].length-1){
                        int rem = j - i ;
                        int total = cost[i] + dp[i][rem] ;
                        dp[i][j] = Math.min(dp[i][j], total) ;
                    }
                }
            }
        }

        System.out.println(dp[cost.length][w]);
    }

    //

    public static int get_min_cost2(int[] cost , int w) {
        
        int[] dp = new int[w+1] ;
        dp[0] = 0 ;

        for (int i = 1; i < dp.length; i++) {

            int min = Integer.MAX_VALUE ;

            for (int j = 0; j < i; j++) {
                if(cost[j] != -1){
                    min = Math.min(min, cost[j] + dp[i-j-1]);
                }
            }
            dp[i] = min ;
            
        }
        return dp[w] ;
    }
    
}

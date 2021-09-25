package Dynamic_Programming_level_02;

public class Q2_KnapSack_Problem {

    public static void main(String[] args) {
        
    }

    public static int get_max_value(int[] val , int[] wt , int cap , int n) {
        
        int[][] dp = new int[n+1][cap+1] ;

        for (int i = 1 ; i < dp.length; i++) {  // here i represents players.
            for (int j = 1; j < dp.length; j++) { // this denotes weight.

                if(j >= wt[i-1]){  // if current weight is greater than or equal to current row weight of array.

                    int rem_balls = j - wt[i-1] ;  // this is the weight we need if we calculate with current val.

                    if(dp[i-1][rem_balls] + val[i-1] > dp[i-1][j]){  // here checking previous row at rem_ball weight + current val(score) if greater than previous player does with same ball (previous player means previous i and same ball means w.)
                        dp[i][j] = dp[i-1][rem_balls] + val[i-1] ; // then update it.
                    }
                    else{ // otherwise the score which previous player scored is greater then update it..
                        dp[i][j] = dp[i-1][j] ;
                    }
                }
                else{ //  otherwise the score which previous player scored is greater then update it..
                    dp[i][j] = dp[i-1][j] ;
                }
                
            }
        }

        return dp[n][cap] ;
    }
    
}

package Dynamic_Programming_level_02;

public class Q17_Perfect_Squares {


    public static void main(String[] args) {
        
    }

    public static int get_perfect_square_num(int n ) {
        
        int[] dp = new int[n+1] ;

        dp[0] = 0 ; // this denotes 0 can be made up with 0 number
        dp[1] = 1 ; // this denotes 1 can be made with 1^2 

        for (int i = 2 ; i < dp.length ; i++) { // now start from 2.

            int min = Integer.MAX_VALUE ; 
            for (int j = 1 ; j*j <= i ; j++) { // run from 1 to j*j <= i.
                int rem = i - j*j ; // this will be the remmaining number we need find. here subtracting j*j means we have find a numbers square and now check the i- j*j number square for its value.

                min = Math.min(min, dp[rem]) ; // find min.

            }

            dp[i] = min + 1 ; // adding 1 ( as we did  - j*j where j's square denotes we used one number already.)
        }

        return dp[n] ;
    }
    
}

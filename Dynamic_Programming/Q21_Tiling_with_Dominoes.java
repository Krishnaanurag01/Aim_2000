package Dynamic_Programming;

public class Q21_Tiling_with_Dominoes {

    public static void main(String[] args) {
        
    }

    public static int get_number_of_ways_floor_tiled(int n ) {

        if(n == 1){  // when n is 1 then return 1 becuase in 2*1 board we only stor 1 tile in one way
            return 1 ;
        }

        int[] dp = new int[n+1] ;
        dp[1] = 1 ; 
        dp[2] = 2 ; // and in 2*2 board we store tile in two either horizontally or vertically.

        for (int i = 3 ; i < dp.length ; i++) {
            dp[i] = dp[i-1] + dp[i-2] ; // now findinig . check in copy for better explanation or pep coding youtube.
        }

        return dp[n-1] ;
        
    }
    
}

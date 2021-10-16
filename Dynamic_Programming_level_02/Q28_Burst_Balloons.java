package Dynamic_Programming_level_02;
;

public class Q28_Burst_Balloons {

    public static void main(String[] args) {
        
    }

    public static int get_max_profit(int[] arr) {
        

        int[][] dp = new int[arr.length][arr.length] ;

        // gap strategy 2.0 : 
        for (int g = 0; g < arr.length; g++) {
            for (int i = 0, j = g ; j < arr.length; i++ , j++) {
                
                int max = Integer.MIN_VALUE ;
                for (int k = i ; k <= j ; k++) {
                    int left = k == i ? 0 : dp[i][k-1] ;
                    int right = k == j ? 0 : dp[k+1][j] ; 
                    int val = ( i == 0 ? 1 : arr[i-1] ) * arr[k] * ( j == arr.length-1 ? 1 : arr[j+1]) ;

                    int total = left + right + val ;

                    if( total > max) {
                        max = total ;
                    }
                }

                dp[i][j] = max ;
            }

        }

        return dp[0][arr.length-1] ;
    }
    
}

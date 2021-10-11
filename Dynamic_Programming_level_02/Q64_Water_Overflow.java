package Dynamic_Programming_level_02;

public class Q64_Water_Overflow {

    public static void main(String[] args) {
        
    }
  /*
(polygon) 
    x            x
   x x      ==   x x    (dp form)
  x x x          x x x



  */
    public static double get_water(int k , int r , int c) {

        double[][] dp = new double[k+1][k+1] ; // as value can be come in float. so made an double array

        dp[0][0] = k ; // stored at top most glass

        for (int i = 0; i <= r ; i++) { // we also don't need to traverse the whole dp we'll simply traverse till the r row
            for (int j = 0; j <= i ; j++) { // and j will is <= i
                
                if(dp[i][j] > 1.0){ // if glass has more water than its capacity(1) then perform this

                    double spare = dp[i][j] - 1.0 ; // find the extra water
 
                    dp[i][j] = 1.0 ; // store its capacity water
                    dp[i+1][j] += spare/2 ; // and add half water to left glass of bottom
                    dp[i+1][j+1] += spare/2 ; // and add half water to bottom right glass.
                }


            }
        }

        return dp[r-1][c-1] ; // now return simply
        
    }
    
}

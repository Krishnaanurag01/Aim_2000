package Dynamic_Programming_level_02;

public class Q23_Number_Of_Ways_Of_Triangulation {

    public static void main(String[] args) {
        
    }
    

    public static int get_total_ways(int n) {
        
        n = n - 2 ; // here subtracting by 2 . because  when n is 2 then it denotes catalan of 0 and when 3 (3 edges can have only 1 triangle) then denotes catalan of c1 and so on with 2 difference.

        // same catalan method.
        
        int[] dp = new int[n+1] ;
        dp[0] = 1 ;
        dp[1] = 1 ;

        for (int i = 2 ; i < dp.length ; i++) {
            
            int l = i-1 ;
            int r = 0 ;

            while (l >= 0) {
                
                dp[i] += dp[l]*dp[r] ;

                l-- ;
                r++ ;
            }
        }

        return dp[n-1] ;
    }
}

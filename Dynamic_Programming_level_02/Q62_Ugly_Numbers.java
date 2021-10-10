package Dynamic_Programming_level_02;

public class Q62_Ugly_Numbers {

    public static void main(String[] args) {
        
    }

    public static long get_ugly_number(int n ) {
        
        long[] dp = new long[n+1];
        dp[1] = 1;

        int p2 = 1;
        int p3 = 1;
        int p5 = 1 ;

        for (int i = 2 ; i <= n ; i++) {
            
            long val2 = 2 * dp[p2] ;
            long val3 = 3 * dp[p3] ;
            long val5 = 5 * dp[p5] ;

            long min = Math.min(val2, Math.min(val3, val5));

            dp[i] = min ;

            if(min == val2){
                p2++;
            }
            else if(min == val3){
                p3++;
            }
            else{
                p5++;
            }
        }




        return dp[n] ;
    }
    
}

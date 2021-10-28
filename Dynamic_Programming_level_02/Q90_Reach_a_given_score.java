package Dynamic_Programming_level_02;

public class Q90_Reach_a_given_score {
    
    public static void main(String[] args) {
     
        get_total_ways(13);
        get_count_comb(13);
    }

    // this will give answer in permuatation so it's doesn't care about the ordering. this is same as coin change permuation.
    public static void get_total_ways(int n) {

        long[] dp = new long[n+1] ;

        dp[0] = 1 ;

        for (int i = 1; i < dp.length; i++) {
            
            if(i >= 3 && dp[i-3] != 0){
                dp[i] += 1 ;
            }

            
            if(i >= 5 && dp[i-5] != 0){
                dp[i] += 1 ;
            }

            
            if(i >= 10 && dp[i-10] != 0){
                dp[i] += 1 ;
            }

        }


        System.out.println(dp[n]);
        
    }


    // combination answer. same as coin change combination check explanation in level 01 dp.

    public static void get_count_comb(int n) {
        
        long[] dp = new long[n+1] ;
        int[] steps = {3,5,10} ;
        dp[0] = 1 ;

        for (int i = 0; i < steps.length ; i++) {
            for (int j = 0; j < dp.length; j++) {
                if(j >= steps[i] && dp[j-steps[i]] != 0){
                    dp[j] += dp[j-steps[i]] ;
                }
            }
        }

        System.out.println(dp[n]);
    }
}

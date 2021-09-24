package Dynamic_Programming_level_01;

public class Q22_Domino_and_Tromino_Tiling {

    public static void main(String[] args) {
        System.out.println((get_total_ways(4) ));
    }

    public static int get_total_ways(int n) {

        if(n == 1){
            return 1 ;
        }

        if(n==2) return 2 ;

        if(n==3) return 5 ;

        int[] dp = new int[n+1] ;  // same logic as previous question.
        dp[1] = 1 ;
        dp[2] = 2 ;
        dp[3] = 5 ; // this is new only

        for (int i = 4; i < dp.length; i++) {
            dp[i] = 2*dp[i-1] + dp[i-3] ; // and this is new.
        }

        return dp[n] ;
        
    }
    
}

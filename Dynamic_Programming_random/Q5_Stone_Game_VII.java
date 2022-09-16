package Dynamic_Programming_random;

public class Q5_Stone_Game_VII {

    static Integer[][] dp ;
    public int stoneGameVII(int[] stones) {
        int sum = 0 ;
        for(int val : stones) sum += val ;
        
        dp = new Integer[stones.length][stones.length] ;
        return get_diff(stones,0,stones.length - 1, sum) ;
    }
    
    public static int get_diff(int[] stones , int si , int ei, int total_sum) {
        if(si >= ei) return 0 ;
        if(dp[si][ei] != null) return dp[si][ei] ;
        if(si+1 == ei) return Math.max(stones[si], stones[ei]) ; // when only twwo element left then return max.

        // taking max diff by working on both ith remove or jth remove
        int max_diff = Math.max(total_sum - stones[si] - get_diff(stones, si + 1, ei , total_sum - stones[si]),
                               total_sum - stones[ei] - get_diff(stones, si, ei - 1, total_sum - stones[ei])) ;

        return dp[si][ei] = max_diff ;
    }

}

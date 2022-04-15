package Dynamic_Programming_extras;

public class Q60_Last_Stone_2 {
    
    public int lastStoneWeightII(int[] stones) {
        
        // variation of 01 knapsack ;
        
        int sum = 0 ;
        for(int val : stones)
            sum += val ;
        
        int max = knapSack(sum/2,stones,stones.length) ; // max score it can make using stones array.
        return sum - max * 2 ; // multiplying max twice because we can make at most max in both subset. so rest are the stones that would not get distroyed.
    }
    
    // using knapsack function.
    static int knapSack(int W, int stone[], int n) 
    { 
        
        int[] dp = new int[W+1] ;
        int max = 0 ;
        
        for(int i = 1 ; i <= stone.length ; i++){
            int[] curr = new int[W+1] ;
            for(int j = 0 ; j <= W ; j++){
        
                int take = 0 ; 
                int notTake = dp[j];
        
                if(stone[i-1] <= j){
                     take = stone[i-1] + dp[j - stone[i-1]];
                }
                
                curr[j] = Math.max(take, notTake) ;
                max = Math.max(max,curr[j]) ;
            }
            dp = curr ;
        }

        return max;
    }
}

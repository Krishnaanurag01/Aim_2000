package LeetCode_Contests.Contest_309;

public class Q2_Number_of_Ways_to_Reach_a_Position_After_Exactly_k_Steps {

    Long[][] dp ;
    public int numberOfWays(int startPos, int endPos, int k) {
        dp = new Long[20000][k+1] ; // making dp of 20000 so that we can also add the negative sp in positive index
        return (int)helper(startPos,endPos,k) ;
    }
    
    long helper(int sp, int ep, int k){
        if(k == 0){
            if(sp == ep) return 1 ;
            return 0 ;
        }
        
        if(dp[sp+1000][k] != null) return dp[sp+1000][k] ; // storing sp in +1000 index. so that when sp becomes negative we store on positive index.
        
        long right = helper(sp+1,ep,k-1) ;
        long left = helper(sp-1,ep,k-1) ;
        return dp[sp + 1000][k] = add(right , left );
    }
    
    
    int M = (int)1e9+7 ;
    
    long mod(long a){
        return (((a%M) + M)%M);
    }
    
    long add(long a, long b){
        return mod(mod(a)+mod(b)) ;
    }
}

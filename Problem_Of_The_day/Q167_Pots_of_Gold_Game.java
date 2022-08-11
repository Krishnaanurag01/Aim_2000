package Problem_Of_The_day ;

public class Q167_Pots_of_Gold_Game {

    static Integer[][] dp;
	public static int maxCoins(int A[],int n)
	{
          dp = new Integer[n][n];
          
          return helper(0,n-1,A) ;
    }
    
    static int helper(int si, int ei, int[] A){
        
        if(si > ei) return 0 ;
        if(dp[si][ei] != null) return dp[si][ei] ;

        //  take max of si and sj val and take the min of next value it take after next player it plays
        
        return dp[si][ei] = Math.max(A[si] + Math.min(helper(si+2,ei,A), helper(si+1,ei-1,A)), /* now if taking jth element thn */ A[ei] + Math.min(helper(si+1,ei-1,A), helper(si,ei-2,A)));
    }
}

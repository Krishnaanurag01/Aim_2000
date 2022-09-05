package Dynamic_Programming_random;

public class Q2_Egg_Drop_With_2_Eggs_and_N_Floors {

    static Integer[][] dp ;
    public int twoEggDrop(int n) {
        dp = new Integer[3][n+1] ;
        return helper(2,n) ;
    }
    
    
    int helper(int eggs, int floors){
        
        if(eggs == 1) return floors ;
        if(floors == 0 || floors == 1) return 1 ;
        if(dp[eggs][floors] != null) return dp[eggs][floors] ;
        
        int ans = (int)1e9 ; 
        int low = 1, high = floors ;
        
        while(low <= high){
            int mid = (low+high)/2 ;
            int broke = dp[eggs-1][mid-1] != null ? dp[eggs-1][mid-1] : helper(eggs-1,mid-1) ;
            int notBroke = dp[eggs][floors-mid] != null ? dp[eggs][floors-mid] : helper(eggs,floors-mid) ;
            int worst = 1 + Math.max(broke,notBroke) ;
            if(broke < notBroke){
                low = mid + 1 ;
            }
            else{
                high = mid-1 ;
            }
         
            ans = Math.min(ans,worst) ;
        }
        
        return dp[eggs][floors] = ans ;
    }
}

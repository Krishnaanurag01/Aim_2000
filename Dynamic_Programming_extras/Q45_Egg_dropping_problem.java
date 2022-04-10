package Dynamic_Programming_extras;

public class Q45_Egg_dropping_problem {

    // using memoization.
    static Integer[][] dp ;
    public int superEggDrop(int k, int n) {
        
        dp = new Integer[k+1][n+1] ;
        return helper(k,n) ;
    }
    
    int helper(int eggs, int floors){
        
        if(eggs == 1){  // when only one egg left total move we need is count of floor
            return floors ;
        }
        
        if(floors == 0 || floors == 1){ // when floor is 0 or 1 then we need 1 move
            return 1 ;
        }
        
        if(dp[eggs][floors] != null) return dp[eggs][floors] ; // returning if solved already.
        
        int min = (int)1e9 ; 
        for(int k = 1 ; k <= floors ; k++){
            int score =  dp[eggs-1][k-1] != null ? dp[eggs-1][k-1] : helper(eggs-1,k-1) ;  // if break then find in lower floor with 1 less egg
            int nbroke = dp[eggs][floors-k] != null ? dp[eggs][floors-k] : helper(eggs,floors-k) ; // if not break then find in upper floors with same no of eggs 
            int worst = 1 + Math.max(score,nbroke) ; // choose the worst of both
            min = Math.min(min,worst) ; //chossing best of worst.
        }
        
        return dp[eggs][floors] = min ;
    }



    // using binary search in place of linear search of above code: 

    // static Integer[][] dp ;
    public int superEggDrop2(int k, int n) {
        
        dp = new Integer[k+1][n+1] ;
        return helper(k,n) ;
    }
    
    int helper2(int eggs, int floors){
        
        if(eggs == 1){
            return floors ;
        }
        
        if(floors == 0 || floors == 1){
            return 1 ;
        }
        
        if(dp[eggs][floors] != null) return dp[eggs][floors] ;
        
        int ans = (int)1e9 ; 
        int low = 1, high = floors ;
        
        while(low <= high){
            int mid = (low+high)/2 ; // finding k
            int broke = dp[eggs-1][mid-1] != null ? dp[eggs-1][mid-1] : helper(eggs-1,mid-1) ;  // going down if breaks
            int notBroke = dp[eggs][floors-mid] != null ? dp[eggs][floors-mid] : helper(eggs,floors-mid) ; // else going up
            int worst = 1 + Math.max(broke,notBroke) ; // getting the worst case.
            if(broke < notBroke){ // if is smaller then we want worst case so going to left.
                low = mid + 1 ;
            }
            else{ // else go to lower side
                high = mid-1 ;
            }
         
            ans = Math.min(ans,worst) ; // getting min of worse.
        }
        
        return dp[eggs][floors] = ans ;
    }
}

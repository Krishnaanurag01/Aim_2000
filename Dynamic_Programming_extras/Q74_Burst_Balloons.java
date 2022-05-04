package Dynamic_Programming_extras;

public class Q74_Burst_Balloons {
    
// method 01 : using memoization.
// we are selecting baloons that will pop last then second last.. and so on.

    static Integer[][] dp ;
    public int maxCoins(int[] nums) {
        
        dp = new Integer[nums.length][nums.length] ;
        return helper(0,nums.length-1, nums) ;
    }
    
    int helper(int i, int j, int[] nums){
        
        if( i > j ) return 0; 
        if(dp[i][j] != null) return dp[i][j] ;
        int max = 0 ;
        
        for(int k = i ; k <= j ; k++){  // if current k baloon would popped last then find it's cost + left range cost and right range cost.
            int temp = ( i > 0 ? nums[i-1] : 1) * ( j < nums.length - 1 ? nums[j+1] : 1)*nums[k] ;
            temp += helper(i,k-1,nums) + helper(k+1,j,nums) ; 
            max = Math.max(max,temp) ;
        }
        
        return dp[i][j] = max ;
    }

    // converting to tabulations : 

    public int maxCoins2(int[] nums) {

        int[][] dp ;
        dp = new int[nums.length][nums.length] ;
        
        for(int i = nums.length-1; i >= 0 ; i--){
            for(int j = 0 ; j < nums.length; j++){
                
                if( i > j ) continue ;
                int max = 0 ;
        
                 for(int k = i ; k <= j ; k++){
                        int temp = ( i > 0 ? nums[i-1] : 1) * ( j < nums.length - 1 ? nums[j+1] : 1)*nums[k] ;
                        temp += ( k - 1 >= 0 ? dp[i][k-1] : 0 ) + ( k+1 < nums.length ? dp[k+1][j] : 0 ); 
                        max = Math.max(max,temp) ;
                 }
        
             dp[i][j] = max ;
                
            }
        }
        
        return dp[0][nums.length-1]  ;
    }
}

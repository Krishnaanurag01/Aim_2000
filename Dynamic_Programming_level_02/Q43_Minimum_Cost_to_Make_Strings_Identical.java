package Dynamic_Programming_level_02;

public class Q43_Minimum_Cost_to_Make_Strings_Identical {
    
    public static void main(String[] args) {
        
    }


    // first find LCS (already explained above) then subtract from s1 and s2 length and multiply with their cost. now add both cost and return.

    public static int min_cost_making_identical(String s1 , String s2 , int cost1 , int cost2) {
        
        int[][] dp = new int[s1.length()+1][s2.length()+1] ;

        for (int i = dp.length - 1; i >= 0 ; i--) {
            for (int j = dp[0].length - 1; j >= 0 ; j--) {
                
                if(i == dp.length-1 || j == dp[0].length){
                    dp[i][j] = 0 ;
                }
                else{
                    if(s1.charAt(i) == s2.charAt(j)){
                        dp[i][j] = 1 + dp[i+1][j+1] ;
                    }
                    else{
                        dp[i][j] = Math.max(dp[i+1][j], dp[i][j+1]) ;
                    }
                }
            }
        }

        int lcs = dp[0][0] ;

        int cost_in_s1 = (s1.length() - lcs)*cost1 ;
        int cost_in_s2 = (s2.length() - lcs)*cost2 ;

        int ans = cost_in_s1 + cost_in_s2 ;

        return ans ;
    }
}
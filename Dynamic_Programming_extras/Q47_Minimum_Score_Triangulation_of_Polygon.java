package Dynamic_Programming_extras;

public class Q47_Minimum_Score_Triangulation_of_Polygon {

    // memoization.

    static Integer[][] dp ;
    public int minScoreTriangulation(int[] values) {
        
        dp = new Integer[values.length][values.length] ;
        return helper(0,values.length-1, values) ;
    }
    
    int helper(int si, int ei, int[] values){
        
        if(ei-si+1 <= 2) return  0 ; // as triangle is of 3 size so any input less than 3 is wrong/invalid.
        
        if(dp[si][ei] != null) return dp[si][ei] ;
        
        int min =(int)1e9 ;
        for(int k = si+1 ; k < ei ; k++){  // partitioning in between the start point and end point 
            int currentSum = values[si]*values[k]*values[ei] ; // current product sum of all three point
            int leftSum = helper(si,k,values) ; // left part product sum
            int rightSum = helper(k,ei,values) ; // right part profuct sum
            
            int total =currentSum + leftSum + rightSum ;
            min = Math.min(min,total) ;
        }
        
        return dp[si][ei] = min ;        
    }
}

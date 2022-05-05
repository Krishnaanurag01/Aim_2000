package Dynamic_Programming_extras ;

public class Q75_Palindrome_Partitioning_II {


    // using memoization.
    static Integer[][] dp ;
    public int minCut(String s) {
        dp = new Integer[s.length()+1][s.length()+1] ;
        return helper(0,s.length() ,s) - 1 ;
    }
    
    int helper(int si, int ei, String s){
        
        if(si == ei) return  0 ; // both start and end is same then return 0 that denotes 0 partition.
        if(dp[si][ei] != null) return dp[si][ei] ;
        
        int min = (int)1e9 ;
        
        for(int i = si ; i < ei; i++){
            if(isPalind(si,i,s)){  // we will partiton the dp only when the partition string is palindrome.
                int cost = 1 + helper(i+1,ei,s) ; // so finding the min cost.
                min = Math.min(min,cost) ;
            }
        }
        
        return dp[si][ei] = min ;
    }
    
    boolean isPalind(int si, int ei, String s){  // checks palindrome.
        
        while(si <= ei){
            if(s.charAt(si) != s.charAt(ei)) return false;
            si++ ;
            ei-- ;
        }
        return true ;
    }



    // converted to tabulations : 

    public int minCut2(String s) {

        int[] dp = new int[s.length()+1] ;
        int ei = s.length() ;
        
        for(int si = s.length() - 1 ; si >= 0 ; si--){
                if(si == ei) continue ;
                
                 int min = (int)1e9 ;
        
                 for(int i = si ; i < ei; i++){
                     if(isPalind(si,i,s)){
                     int cost = 1 + dp[i+1] ;
                     min = Math.min(min,cost) ;
                     }
                 }
                dp[si] = min ;
            }
        return dp[0] - 1 ;
    }
}

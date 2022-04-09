package Dynamic_Programming_extras;

public class Q39_Palindrome_Partitioning_II {


    // Recursive solution.

    public int minCut(String s) {
        // System.out.println(isPalin(s)) ;
        return helper(0,s.length()-1, s) ;
        
    }
    
    static int helper(int si, int ei, String s){
        
        if(si >= ei) return  0; /// when s is empty or of 1 length return 0 becuase it does not need any partition as it is already palindome
        if(isPalin(s,si,ei)) return  0 ;// or iff current s is already palindrome return  0.

        int min = (int)1e9 ;
        for(int k = si ; k < ei ; k++){ // else partition it from si to ei -1    
            int val = 1 + helper( si,k,s ) + helper(k+1,ei,s) ; // and find the min
            min = Math.min(min, val) ;
        }
        
        return min ;
    }

    // palindrome function.
    static boolean isPalin(String s,int si, int ei){
        while(si < ei){
            if(s.charAt(si) == s.charAt(ei)){
                si++ ;
                ei-- ;
            }
            else{
                return false;
            }
        }
        return true ;
    }








    // using memoization but it will still give you tle.

    public int minCut2(String s) {
        if(s.equals("")) return 0 ;
        Integer[][] dp = new Integer[s.length()][s.length()] ;
        return helper(0,s.length()-1, s,dp) ;
    }
    
    static int helper(int si, int ei, String s, Integer[][] dp){
        if(si >= ei) return  0;
        if(isPalin(s,si,ei)) return  0 ;
        
        if(dp[si][ei] !=null) { // returning if already solved.
            System.out.println("Yesss") ;
            return dp[si][ei] ;
        }
            
        int min = (int)1e9 ;
        for(int k = si ; k < ei ; k++){
            int val = 1 + helper(si,k,s,dp) + helper(k+1,ei,s,dp) ;
            min = Math.min(min, val) ;
        }
        
        return dp[si][ei] = min ;
    }


}



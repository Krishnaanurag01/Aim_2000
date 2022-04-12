package Dynamic_Programming_extras;

public class Q52_Number_of_Ways_to_Select_Buildings {

    // using memoization.

    static Long[][][] dp ;
    public long numberOfWays(String s) {
     
        dp = new Long[s.length()][3][4] ;
        return helper(0,2,s,0) ; // 2 denotes we have both option to select 0 or 1.
    }
    
    static long helper(int idx, int prev, String s, int csf){
        
        if(csf == 3) return 1 ; // when reached answer.
        if(idx == s.length()) return  0 ;  // return 0 when visited all the index.

        if(dp[idx][prev][csf] != null) return dp[idx][prev][csf] ; // return true if already solved.
        
        int ch = s.charAt(idx) - '0' ;
        // System.out.println(ch) ;
        
        long skip = helper(idx+1, prev, s, csf) ; // when not selecting current char.
        long cZero = 0 ; // count of total answer when current char is zero.
        long cOne = 0 ; // count of total answer when current char is one.
        
        if(ch == 0 && prev != 0 ){ // if current char is 0 and prev is not 0 then we can select current zero
            cZero = helper(idx+1, ch, s, csf+1) ;
        }
        
        if(ch == 1 && prev != 1 ){ // if current char is 1 and prev is not 1.
            cOne = helper(idx+1, ch , s, csf+1 ) ;
        }
        
        return dp[idx][prev][csf] = skip + cZero + cOne ; // returning total ways.
    }
    



    // using prefix count array.

    public long numberOfWays2(String s) {
     
        long ans = 0 ;
         int[] co = new int[s.length()] ; // count of one till i
         int[] cz = new int[s.length()] ; // count of zero till i
         
         // using prefix count array
         co[0] = s.charAt(0) == '1' ? 1 : 0 ;
         cz[0] = s.charAt(0) == '0' ? 1 : 0 ;
 
         for(int i = 1 ; i < s.length() ; i++ ){
             char ch = s.charAt(i) ;
             if(ch == '0'){
                 co[i] = co[i-1] ;
                 cz[i] = cz[i-1] + 1 ;
             }
             else{
                 cz[i] = cz[i-1] ;
                 co[i] = co[i-1] + 1 ;
             }
         }
 
         
         for(int i = 0 ; i < s.length() ; i++){
             char ch = s.charAt(i) ;   
             
             if(ch == '0'){ // if current char is '0' then count total one in both left and right
                 int lo = co[i];
                 int ro = co[co.length-1] - co[i] ;
                 ans += (lo*ro) ;
             }
             else{ // if current char is '1' then count total zero in both left and right.
                 
                 int lz = cz[i] ;
                 int rz = cz[cz.length-1] - cz[i] ;
                 ans += (lz*rz) ;
             }
         }
         
         return ans ;
     }
}

package Problem_Of_The_day;

public class Q396_Restore_The_Array {
    Long[] dp ;
    int mod = (int)1e9+7 ;
    public int numberOfArrays(String s, int k) {
     
        dp = new Long[s.length()] ;
        long result = helper(0, s, k);
        // System.out.println(result) ;
        
        return (int)result  ;
    }
    
    long helper(int idx, String s, int k){
        if(idx >= s.length()) return 1L ; // if idx of s is out of bound 
        if(s.charAt(idx) == '0') return 0L ; // if first char of current number has leading 0 then 0
        if(dp[idx] != null) return dp[idx] ;
        
        long temp = 0 ;
        long count = 0 ;
        int cidx = idx ; // current index backup
        
        while(idx < s.length() ){
            long digit = (long)(s.charAt(idx) - '0') ; // take current digit
            
            temp = temp * 10 + digit ; // and form the number
                    
            if(temp > k){ // 
                break ;
            }
            
            count = ((count + helper(idx+1, s, k)) % mod + mod ) %  mod ; // and check if idx+1 can make other number in range of not
            idx++ ;
         }
        
        // if(idx < s.length())
        // count += helper(idx, s, k) ;
        
        
        return dp[cidx] = count ;
    }    
}

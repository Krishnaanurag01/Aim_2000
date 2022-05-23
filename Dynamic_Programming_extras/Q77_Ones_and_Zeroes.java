package Dynamic_Programming_extras ;

public class Q77_Ones_and_Zeroes {

    static Integer[][][] dp ;
    public int findMaxForm(String[] strs, int m, int n) {
     dp = new Integer[strs.length][m+1][n+1] ;
        return helper(0,strs,m,n) ;   
    }
    
    int helper(int idx, String[] s, int zeros, int ones){
        if(idx == s.length) return  0 ;
        if(dp[idx][zeros][ones] != null) return dp[idx][zeros][ones] ;
        
        int nt = helper(idx+1,s,zeros,ones) ;
        
        int zins = 0 ;
        int oins = 0 ;
        
        for(char ch: s[idx].toCharArray()){
            if(ch == '0') zins++ ;
            else oins++ ;
        }
        
        int taken = 0 ;
        if(zins <= zeros && oins <= ones){
            taken = 1 + helper(idx+1,s,zeros - zins, ones - oins);
        }
        
        return dp[idx][zeros][ones] = Math.max(nt,taken) ;
    }
}

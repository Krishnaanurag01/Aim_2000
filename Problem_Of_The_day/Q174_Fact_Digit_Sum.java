package Problem_Of_The_day;
import java.util.*;

public class Q174_Fact_Digit_Sum {

    Long[] dp ;
    ArrayList<Integer> ans ;
    ArrayList<Integer> FactDigit(int N)
    {
 
       dp = new Long[10] ; // finding factorial of 1 to 10 first
       dp[0] = 1L ;
       dp[1] = 1L ;
       ans = new ArrayList<>() ;
       for(int i = 2 ; i < dp.length ; i++){
           dp[i] = i*dp[i-1] ;
        }

       helper(N) ;
       return  ans ;
    }
    
    boolean helper(long x){
        if(x == 0 ){
            return true;
        }
        if(x < 0 ) return false;
        
       for(int  i = dp.length - 1 ; i >= 0 ; i-- ){ // now running from last to first
           if(dp[i] > x) continue ;
           ans.add(0,i) ;
           boolean temp = helper(x-dp[i]) ;
           if(temp) return true;
           ans.remove(0) ;
       } 
       
       return false;
    }
}

package Problem_Of_The_day;
import java.util.*;

public class Q36_N_Digit_numbers_with_digits_in_increasing_order {
    
    static ArrayList<Integer> increasingNumbers(int N){
        // code here
        ArrayList<Integer> ans = new ArrayList<>() ;
        StringBuilder sb = new StringBuilder() ;
        if(N == 1){
            dfs(0,N,sb,ans) ;
            return ans ;
        }
        else{
            
            dfs(1,N,sb,ans) ;
            return ans ;
        }
    }
    
    public static void dfs(int s , int n , StringBuilder sb , ArrayList<Integer> ans){
        
        if(sb.length() >= n ){
            ans.add( Integer.parseInt( sb.toString())) ;
            return ;
        }
        
        for(int i = s ; i <= 9 ; i++){
            sb.append(i) ;
            dfs(i+1, n , sb , ans) ;
            sb.deleteCharAt( sb.length() - 1 ) ;
        }
        
        
        return ;
        
    }
}

package Problem_Of_The_day ;
public class Q291_Jumping_Numbers {
    
    static long ans ;
    static long jumpingNums(long X) {
        // code here
        
        ans = 0 ;
        String x = X +"" ;
        
        for(char c = 0 ; c <= 9 ; c++){
            helper(1, x , c , c) ;
        }
        
        return ans ;
    }
    
    
    static void helper(int idx, String x, long num, int prev){
        
        if(num > Long.parseLong(x)) return ;
        ans = Math.max(ans,num) ;

        if(prev + 1 <= 9) helper(idx+1, x, num * 10 + (prev + 1), prev+1) ;
        if(prev - 1 >= 0) helper(idx+1, x, num * 10 + (prev - 1), prev-1) ;
    }
}

package Problem_Of_The_day;

public class Q79_fibonacci_number {
    
    public int fib(int n) {
        
        if( n == 0 ) return 0 ;
        if( n <= 2) return 1 ;
        
        int fn = 1 ;
        int sn = 1 ;
        
        for(int i = 3 ; i <= n ; i++){
            int next = fn + sn ;
            sn = fn ;
            fn = next ;
        }
        
        return fn ;
    }
}

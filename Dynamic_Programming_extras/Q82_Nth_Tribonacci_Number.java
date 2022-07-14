package Dynamic_Programming_extras;

public class Q82_Nth_Tribonacci_Number {

    // same as fibonacci except for nth tribonacci the value is sum of previous three
    public int tribonacci(int n) {
        
        if( n == 0 ) return 0 ;
        if( n <= 2) return 1 ;
        
        int fn = 1 ;
        int sn = 1 ;
        int tn = 0 ;
        
        for(int i = 3 ; i <= n ; i++){
            int next = fn + sn + tn ;
            tn = sn ;
            sn = fn ;
            fn = next ;
        }
        
        return fn ;
    }
}

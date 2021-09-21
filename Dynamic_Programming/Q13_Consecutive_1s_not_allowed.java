package Dynamic_Programming;

public class Q13_Consecutive_1s_not_allowed {


    public static void main(String[] args) {
        
    }


    // distinct binary strings of length N such that there are no consecutive 1’s.

    // same logic as q12 , only difference is here we are not selecting consecutive 1s and In the 12th we were not  selecting consecutive 0s.
    public static long get_total_strings(int n ) {
        
        long a[] = new long [n];
        long b[] = new long [n];
        
        long mod = 1000000007 ;
        a[0] = b[0] = 1;
        for (int i = 1; i < n; i++)
        {
            a[i] = (a[i-1] + b[i-1])%mod ;
            b[i] = a[i-1];
        }
        return (a[n-1] + b[n-1])% mod;
    }
    
}

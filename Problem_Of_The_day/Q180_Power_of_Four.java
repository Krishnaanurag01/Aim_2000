package Problem_Of_The_day;

public class Q180_Power_of_Four {

    public boolean isPowerOfFour(int n) {
        if( n == 0) return false;
       
        // brute force (time : O(log n))
//         while(n % 4 == 0) n = n/4 ;
//         return n == 1;
        
        // using bit manipulation.
        
        int mask = 0b01010101010101010101010101010101 ;
        
        // n & (n-1) = checks whether n is power of 2 or not.
        // n & mask = checks power of 4.
        return n > 0 && (n &(n-1)) == 0 && (n&mask) > 0 ; 
    }
}

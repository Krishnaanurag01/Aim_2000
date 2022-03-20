package Bit_Manipulation;

public class Q23_is_power_of_4 {

    public boolean isPowerOfFour(int n) {
        
        int fac = 0b01010101010101010101010101010101 ; // this will help us in identifying whether the n is power of 4 or not.

        // the set bit in power of 4 always on the odd position so doing "AND" with fac will determine whether it is power of 4 or not.
        
        // and power of 4 is always power of 2 so checking both.
        return n > 0 && (n & (n - 1)) == 0 && ( fac & n ) > 0 ;
        
    }
    
}

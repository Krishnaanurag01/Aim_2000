package Bit_Manipulation;

public class Q29_Count_total_set_bits {

    public static int countSetBits(int n){
        
        if( n == 0 )
        return  0 ;
        
        int x = largestPowerOfTwo(n) ; // getting power of two
        
        // counting total bits till 2^x - 1
        int totalBits = x * ( 1 << ( x-1 )) ;

        // getting most significant bit from 2^x to n (inclusive)
        int restMsbBits = n - (1 << x) + 1 ;
        
        int resBitsAfterTwoPowerX = n - (1 << x ) ; // now getting next n for count rest(as we took msb so finding in rest) of the bits 2^x (including).
        
        int result = totalBits + restMsbBits + countSetBits( resBitsAfterTwoPowerX );
        
        return result ;
       
    }

    // getting highest power of two that is less than equal to n.
    static int largestPowerOfTwo(int n){
    
        int x = 0 ;
        while( ( 1 << x ) <= n ){
            x++ ;
        }
        
        return x - 1 ;
    }
    
}

package Bit_Manipulation ;

public class Q25_Swap_all_odd_and_even_bits {

    public static int swapBits(int n) 
    {
	    // Your code
	    
	    int em = 0xAAAAAAAA ; // even mask
	    int om = 0x55555555 ; // odd mask
	    
	    int odd = n & om ;
	    int even = n & em ;
	    
	    odd <<= 1; 
	    even >>= 1 ;
	    
	    return odd | even ;
	}
       
}
package Bit_Manipulation;

public class Q31_Reverse_Bits {


    public int reverseBits(int n) {
        
        int rev = 0 ;
        int j = 0 ; // denotes bit for reversed number
        
        for(int i = 31 ; i >= 0 ;i--){
            
            int mask = (1 << i ) ;
            
            if( (n & mask) == 0){
                // when 0 then you can skip as by default it will allocate zero
            }
            else{
            rev = rev | (1 << j) ;
            }
            j++ ;
        
        }
        
        
        return rev ;
    }
    
}

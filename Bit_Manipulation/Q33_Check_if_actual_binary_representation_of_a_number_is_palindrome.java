package Bit_Manipulation;

public class Q33_Check_if_actual_binary_representation_of_a_number_is_palindrome {

    int binaryPalin (long N)
    {
        // Your Code Here       
        long i = 63L ; // took i as last bit of 64 bit long N
        long j = 0L ; // it represents the right most bit (1st bit)
        
        boolean flag = false; // denotes whether leading zeros are over or not.
        
        while(i >= j ){
            
            long bit1 = (1 << i) ;
            
            if(flag == false){
                if( (N & bit1 ) == 0 ){
                    i-- ;
                    continue ;
                }
                else{
                    flag = true  ;
                }
            }
            else{
                
                long bit2 = (1 << j) ;
                
                long bv1 = ( N & (bit1) ) ;
                long bv2 = ( N & (bit2) ) ;
                
                if(bv1 == 0  && bv2 != 0){
                    return  0 ;
                }
                else if(bv1 !=0 && bv2 == 0){
                    return 0 ;
                }
                else{
                    i-- ;
                    j++ ;
                }
            }
        }
        
        return 1 ;
    }
    
}

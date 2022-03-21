package Bit_Manipulation;

public class Q36_Minimum_Flips_to_Make_a_OR_b_Equal_to_c {

    public int minFlips(int a, int b, int c) {
        
        int count = 0 ;
        
        // run a loop for 32 times and checking each time if ith bit of c is equal to OR of a and b.
        for(int i = 0 ; i < 32 ; i++){

            int mask1 = ( a & (1 << i) ) ; // mask of ith bit of a.
            int mask2 = ( b & (1 << i) ) ; // mask of ith bit of b.
            int mask3 = ( c & (1 << i) ) ; // mask of ith bit of c.

            if(mask3 == 0){ // if mask for c is 0 then check whehter both a and b mask are zero or not becuase we have to do the "OR" operation so both a and b, ith bit should also be zero
                
                if(mask1 != 0)
                    count++ ;
                
                if(mask2 != 0)
                    count++ ;
                
            }else{ // when mask for c is 1 then check for "OR" operation whether both a and b are containing atleast one set bit or not. if not then increament the count by 1. 
                if(mask1 == 0 && mask2 == 0){
                    count++ ;
                }
            }
        }
        
        return count ;
    }
    
}

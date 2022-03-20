package Bit_Manipulation;

public class Q22_is_power_of_2 {


      // Function to check if given number n is a power of two.
      public static boolean isPowerofTwo(long n){
        

        // every power of 2 is in the form of : 1 -> 0001, 2 -> 0010 , 4 -> 0100 and so on.
        
        if( n == 0){
            return false;
        }
        
        long mask = n & (n-1) ; // so Doing "AND" with n-1 that is '01000' & 00111 will give us 00000 if it is valid power of two
        
        if(mask == 0){ // if zero then true
            return true ;
        }
        
        return false;
    }
    
}

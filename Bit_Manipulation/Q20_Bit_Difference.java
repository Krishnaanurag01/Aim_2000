package Bit_Manipulation;

public class Q20_Bit_Difference {

    public static int countBitsFlip(int a, int b){
        
        int flipped = a ^ b ; // getting final flipped integer
        
        int count = 0 ;
        
        // using karnighans algo
        while(flipped > 0){
            
            int rsb = flipped & -flipped ; // finding the right most set bit.
            
            flipped -= rsb ;
            count++ ;
        }
        
        return count ;
        
    }
    
    
}

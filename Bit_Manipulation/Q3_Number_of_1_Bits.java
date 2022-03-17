package Bit_Manipulation;

public class Q3_Number_of_1_Bits {

    static int setBits(int N) {
        
        int count = 0 ; // will hold the total count
        
        // Kernighans algo :

        while(N != 0){
            // using Q2 approch
            int rms = N & -N ; // finding the right most set bit

            // and subtracting in N 
            N = N - rms ;
            
            count++ ;
        }
        
        return count ;
    }
    
}

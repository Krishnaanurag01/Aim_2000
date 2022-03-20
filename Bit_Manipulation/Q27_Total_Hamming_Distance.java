package Bit_Manipulation;

public class Q27_Total_Hamming_Distance {

    public int totalHammingDistance(int[] arr) {
        
        // same as Q26. 

        int result = 0 ;
        
        for(int i = 0 ; i < 32 ; i++){
            
            int countOn = 0 ;
            
            for(int val : arr){
                if( (val & (1 << i)) != 0 ){
                    countOn++ ;
                }
            }
            
            int countOff = arr.length - countOn ;
            
            int diff = countOn*countOff ; // here we are not multiplying with 2 becuase we are considering only distinct pair eg. only (a,b) or (b,a)
            result += diff ;
        }
        
        return result ;
    }
    
}

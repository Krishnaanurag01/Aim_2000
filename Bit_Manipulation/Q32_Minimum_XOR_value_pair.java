package Bit_Manipulation;
import java.util.*;

public class Q32_Minimum_XOR_value_pair {


    static int minxorpair(int N, int arr[]){
        
        Arrays.sort(arr) ; // sorting the array because the min xor difference can be found only in adjecent sorted values;
        // becuase if we find xor of for eg : 3( 0011) ^ and 10(1010) then we can see that the msb in 10 giving very large value where as if we do xor of 3 ^ any(4,5,6...9) it will give lesser value becuase it will have different bit in lesser index of bit.
        
        int min = Integer.MAX_VALUE ;
        
        for(int i = 0 ; i < arr.length - 1 ; i++)
        {
            int temp = arr[i] ^ arr[i+1] ; // doing xor
            
            if(temp < min){ // updating min.
                min = temp ;
            }
        }
        
        return min ;
    }
    
}

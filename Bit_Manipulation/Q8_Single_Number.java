package Bit_Manipulation;

public class Q8_Single_Number {
    
    int getSingle(int nums[], int n) {
        // code here
        
          // Doing XOR operation operation.
        // when we do : x ^ x = 0 
        // so if do XOR on every number then alll then duplicate  numbers becomes 0 and when we do the 0 ^ that number which comes only onece then output is = that same number.
        
        int mask = 0 ;
        
        for(int num : nums){
            mask  = mask ^ num ;
        }
        
        return mask ;
    }
}

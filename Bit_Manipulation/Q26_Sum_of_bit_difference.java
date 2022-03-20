package Bit_Manipulation;

public class Q26_Sum_of_bit_difference {


    // time comp : O(32*N) which is better than brute force O(n2)
    long sumBitDifferences(int[] arr, int n) {
        // code here
        
        long result = 0 ; // final count of difference bit
        
        for(int i = 0 ; i < 32 ; i++){ // running for each bit position
            
            long countOn = 0 ; // count of ith bit whether it is on or not.
            
            for(int val : arr){ // checking ith bit for each value of arr
                if( (val & (1 << i)) != 0 ){ // if it on then increase the count.
                    countOn++ ;
                }
            }
            
            long countOff = arr.length - countOn ; // count of off bit.
            
            long diff = countOn*countOff*2 ; // counting total different bit and multiplying with 2 wo next permutation of pair. eg : we counted different bit for (a,b) and multiplying with 2 denotes total different bit for both (a,b) and (b,a)
            result += diff ; // adding to answer.
        }
        
        return result ;
    }
    
}

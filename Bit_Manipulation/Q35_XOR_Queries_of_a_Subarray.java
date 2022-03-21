package Bit_Manipulation;

public class Q35_XOR_Queries_of_a_Subarray {

    public int[] xorQueries(int[] arr, int[][] queries) {
        
        int n = arr.length ;

        int[] xorSf = new int[n] ; // it will store presum of xor
        
        // filling the presum
        xorSf[0] = arr[0] ;
        for(int i = 1 ; i < n ; i++ ){
            xorSf[i] = xorSf[i-1] ^ arr[i] ;
        }
        

        int m = queries.length ;
        int[] result = new int[m] ;
        int k = 0 ;
        // now accessing each queries
        for(int[] in : queries ){
            int leftIdx = in[0] ;
            int rightIdx = in[1] ;
            
            if(leftIdx == 0){ // when left index is 0 then simply take the right index presum value
                result[k] = xorSf[rightIdx] ;
                k++ ;
                continue ;
            }
        
            //else toggle off theleftIdx -1 value from riht idx presum sum value
            result[k] = xorSf[leftIdx - 1] ^ xorSf[rightIdx] ;
                k++ ;
        }
        
        return result ;
    }
    
}

package Bit_Manipulation;

public class Q15_Sum_of_XOR_of_all_pairs {

    public long sumXOR (int arr[], int n) {
       
        long ans = 0 ;
        
        for(int i = 0 ; i < n ; i++){
            int mask = arr[i] ;
            
            for(int j = i + 1 ; j < n ; j++){
                mask = mask ^ arr[j] ;
                ans += mask ;
                mask = arr[i] ;
            }
        }
        
        return ans ;
    }
    
}

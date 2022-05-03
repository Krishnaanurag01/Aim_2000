package Problem_Of_The_day;

public class Q58_Subsets_with_XOR_value {

    static int subsetXOR(int arr[], int N, int K) {
       
        return helper(N-1,arr,K,0) ;
     }
     
     static int helper(int idx, int[] arr, int K,int mask){
         
         if(idx == -1 && mask == K ) return 1 ;
         if(idx == -1) return 0;
         
         int notTook = helper(idx-1, arr, K, mask) ;  // not taking current num
         int took = helper(idx-1, arr, K, (mask ^ arr[idx]) ); // taking current num
         
         return notTook + took ; // returning total count.
     }
}

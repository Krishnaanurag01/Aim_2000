package Problem_Of_The_day ;

public class Q305_Sum_of_Subarrays {
        public static long subarraySum( long a[], long n) {
           long ans = 0 ;
           int mod = (int)1e9+7 ;
           
           for(int i = 0 ; i < n ; i++){
               long n_minus_i = (n - i) ; // total number of subarray where ith element is the first element in the subarray
               long rest_ocurrance = i+1 ;
               
               ans = (ans + (a[i] * n_minus_i * rest_ocurrance)) % mod ; // val * total occurance
           }
           
           return ans ;
        }
}

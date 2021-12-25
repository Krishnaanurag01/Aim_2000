package Problem_Of_The_day;
import java.util.*;

public class Q27_Max_sum_after_K_negations {

    public static void main(String[] args) {
        
        long[] arr = {1, 2, -3, 4, 5} ;
        int k = 1 ;

        System.out.println(maximizeSum(arr, 5, k));
    }

    public static long maximizeSum(long arr[], int n, int k)
    {
        // Your code goes here   
        Arrays.sort(arr) ;

        int p = 0 ;
        int j = n-1 ;

        while (p < j ) {
            long temp = arr[p] ;
            arr[p] = arr[j] ;
            arr[j] = temp ;
            p++ ;
            j-- ;
        }
        
        long ans = 0 ;
        
        for(int i = 0 ; i < n ; i++){
            if(k > 0 ){
                if(ans < 0 && arr[i] < 0 ){
                arr[i] = arr[i] ;
                }
                else if(ans < 0 && arr[i] > 0 ){
                arr[i] = -arr[i] ;
                k-- ;
                }
                else if(ans > 0 && arr[i] < 0){
                    arr[i] = -arr[i] ;
                    k-- ;
                }
            }
            ans = Math.max(ans, ans + arr[i] ) ;
        }
        
        return ans ;
    }
    
}

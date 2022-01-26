package Problem_Of_The_day;
import java.util.*;

public class Q45_Next_Permutation {
    static List<Integer> nextPermutation(int N, int arr[]){
        // code here
        
        int fdx = N ; // first decreasing index.
        
        List<Integer> list = new ArrayList<>() ;
        
        for(int i = N-2 ; i >= 0 ; i--){
            if(arr[i] < arr[i+1]){
                fdx = i ;
                break ;
            }
        }
        
        
        if(fdx != N){
            
            // int idx = N ;
            
            for(int i = N-1 ; i >= 0 ; i--){
                if(arr[i] > arr[fdx]){
                    // idx = i ;
                    swap(arr,fdx,i) ;
                    break ;
                }
            }
            
            int k = fdx+1 ;
            int l = N-1 ;
            
            while( k < l){
                
                swap(arr,k,l) ;
                
                k++ ;
                l-- ;
            }
            
            for(int i = 0 ; i < N ; i++){
                list.add(arr[i]) ;
            }
            
            return list ;
            
        }
        else{
            
            Arrays.sort(arr) ;
            
            
            for(int i = 0 ; i < N ; i++){
                list.add(arr[i]) ;
            }
            
            return list ;
            
        }
    }
    
    public static void swap(int[] arr, int i , int j){
        
        int temp = arr[i] ;
        arr[i] = arr[j] ;
        arr[j] = temp ;
     }
}

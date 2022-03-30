package Binary_Tree;
import java.util.*;

public class Q74_count_zero_xor_pairs {

    public static long calculate (int arr[], int n) {
       
        Arrays.sort(arr) ; // sorting becuase two same numbers xor is 0 so directly check adjecent numbers.
        int res = 0 ;
        int count = 0 ;
        
        for(int i = 1 ; i < n ; i++){
            if( (arr[i] ^ arr[i-1]) == 0){
                count++ ; 
                res += count ;
            }
            else{
                count = 0 ;
            }
        }
        
        return res ;
     }
     
    
}

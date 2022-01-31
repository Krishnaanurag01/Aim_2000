package Searching_Sorting_level_02;
import java.util.*;

public class Q23_Count_the_triplets {
    
    int countTriplet(int arr[], int n) {
        
        Arrays.sort(arr) ;
        
        int count = 0 ; 
        
        for(int i = n-1 ; i >= 2 ; i--){ // running till 2th index starting from last
            
            int l = 0 ; // left
            int r = i-1 ; // right

            // normal 2 two pointers approch
            while(l < r ){
                int sum = arr[r] + arr[l] ;
                
                if( sum == arr[i] ){ // if same 
                   r-- ; // then increment and decrement boht becuase contains distinct element
                   l++ ;
                   count++ ;
                }
                else if( sum < arr[i]){
                    l++ ;
                }
                else if(sum > arr[i]){
                    r-- ;
                }
            }
        }
        
        return count ;
    }
}

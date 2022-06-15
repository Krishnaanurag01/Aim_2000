package HashMaps_and_Heaps_Level_02;
import java.util.*;

public class Q13_Equivalent_Sub_Arrays {

    static int countDistinctSubarray(int arr[], int n) 
    { 
        
        // counting distinct numbers using set.
        HashSet<Integer> set = new HashSet<>() ;
        
        for(int i : arr){
            set.add(i) ;
        }
        
        int distinct = set.size() ;
        
        

        // using Aquire and Release method.
        HashMap<Integer,Integer> map = new HashMap<>() ; 
        
        int i = 0 ; 
        int j = 0 ;
        int count = 0 ;
         
        while(true){
            boolean f1 = false; 
            boolean f2 = false; 
            
            // aquiring.
            while(i < n){
                
                f1 = true ;
                
                int num = arr[i] ;
                
                // adding to map.
                map.put( num , map.getOrDefault(num,0)+1 ) ;
            
                
                i++ ; // incrementing before so that for next iteration we will start from next element.
                
                // map contains all the distinct element then break the array.
                if(map.size() == distinct){
                    break ;
                }
            
            }
            
            
            while(j < i){
                
                f2 = true ;
                
                // if map has all the element then count total subarrays.
                if(map.size() == distinct ){

                    // subtracting from n becuase if a small part of array contains all element then that part till end of the array will also contains all the element so calcualting count.
                    count += (n-i+1) ;
                }
                
                // now releasing the jth number.
                int num = arr[j] ;
                
                int freq = map.get(num) ;
                
                if(freq == 1){
                    map.remove(num) ;
                }
                else{
                    map.put(num,freq - 1) ;
                }
                
                j++ ;

                // if our map no longer contains all the numbers then break the loop
                
                if(map.size() < distinct){
                    break ;
                }
            }
            
            if(f1 == false && f2 == false)
            break ;
            
        }
        
        return count ;
    }
    
}

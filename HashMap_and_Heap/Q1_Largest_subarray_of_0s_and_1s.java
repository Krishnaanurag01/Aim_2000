package HashMap_and_Heap;
import java.util.* ;

public class Q1_Largest_subarray_of_0s_and_1s {
    
    int maxLen(int[] arr, int N)
    {
        
        HashMap<Integer,Integer> map = new HashMap<>() ;
        
        int ans = 0 ; // this will contain ans
        int sum = 0 ;
        
        map.put(sum,-1) ; // adding 0 sum with -1 index
        
        for(int i = 0 ; i < N ; i++){
            if(arr[i] == 0){ // if 0 comes then add -1
                sum += -1 ;
            }
            else{ // else 1
                sum += 1 ;
            }
            
            if(map.containsKey(sum)){ // if already present the same sum then get its index and subtract it with current index this wll give us width
                ans = Math.max(ans , i - map.get(sum)) ;
            }
            else{
            
            map.put(sum,i) ;
        }
        
        }
    
    return ans ;
    }
}

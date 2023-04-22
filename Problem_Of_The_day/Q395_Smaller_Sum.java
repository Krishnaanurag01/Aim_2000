package Problem_Of_The_day;
import java.util.*;

public class Q395_Smaller_Sum {
    
    public long[] smallerSum(int n,int arr[])
    {
        
        HashMap<Integer,Long> map = new HashMap<>() ;
        TreeMap<Integer,Integer> set = new TreeMap<>() ;
        
        for(int val : arr){ // storing vals of arr in treemap
            set.put(val, set.getOrDefault(val,0)+1) ;
        }
        
        long sum = 0 ;
        for(int key : set.keySet()){ // calculating sum
            map.put(key, sum) ; // and putting sum on key
            sum += (1L * key * set.get(key)) ; 
        }
        
        long[] ans = new long[n] ;
        for(int i = 0 ; i < n ; i++){
            ans[i] = map.get(arr[i]) ; // getting sum for arr[i]
        }
        
        return ans ;
    }
}

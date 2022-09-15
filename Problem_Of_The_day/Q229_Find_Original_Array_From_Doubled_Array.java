package Problem_Of_The_day;
import java.util.*;

public class Q229_Find_Original_Array_From_Doubled_Array {
    public int[] findOriginalArray(int[] changed) {
        ArrayList<Integer> list = new ArrayList<>() ;// here we will store answer.
        
        HashMap<Integer,Integer>  map = new HashMap<>() ; // freq map
        for(int val : changed){
            map.put(val, map.getOrDefault(val,0)+1) ;
        }
        
        Arrays.sort(changed) ; // so that we can examine every values in order.
        for(int val : changed){
            int twice = 2*val ; 
            // if either val or twice not present then skip.
            if(map.containsKey(val) == false) continue ;
            if(map.containsKey(twice) == false) continue ;
           
            
            // reducing the freq of val by 1
            int val_freq = map.get(val) ;
            if(val_freq == 1) map.remove(val) ;
            else map.put(val, val_freq-1) ;
            
            // again applying the check condition it works on the case when both val and twice is same(i.e 0 and2*0)
            if(map.containsKey(twice) == false) continue ;
            
            // now reduce the freq of twice by 1
            int freq = map.get(twice) ;
            list.add(val) ; // and add val into answer.
            if(freq == 1) map.remove(twice) ;
            else map.put(twice, freq-1) ;
            
           
        }
        
        // this check whether every element in the original array is present or not.
        if(list.size() * 2 != changed.length) return new int[0] ;
        
        // now return the original array by converting list to array.
        return list.stream().mapToInt(i -> i).toArray() ;
    }

    // using array.
    public int[] findOriginalArray2(int[] changed) {
        int n = changed.length ;
        if(n % 2 != 0) return new int[0] ; // if not even size 
        
        int[] ans = new int[n/2] ;
        int s = 0 ;
        int[] freq_arr = new int[100001] ; // made 1e5 +1 size freq array.
        
        for(int val : changed) freq_arr[val]++ ; // increasing freq
        
        for(int num = 0 ; num < freq_arr.length && num * 2 <= freq_arr.length ; num++){
            
            if(num == 0){ // when num is 0 then it must be handle seperately
                if(freq_arr[0] % 2 != 0) return new int[0] ;
            }
            
            int twice = num + num ;
            if(freq_arr[num] > freq_arr[twice]) return new int[0] ;
            
            while(freq_arr[num] > 0 && freq_arr[twice] > 0){ // here we are finding twice one by one becuase array may has duplicate elements and we have to find the orignal.
                freq_arr[num]-- ;
                freq_arr[twice]-- ;
                ans[s++] = num ;
            }
        }
        
        if(s != n/2) return new int[0] ; // checking if ans contains all the n/2 elements or not.
        
        return ans ;
    }
}

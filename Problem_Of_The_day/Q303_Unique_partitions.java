package Problem_Of_The_day;
import java.util.*;

public class Q303_Unique_partitions {

    public ArrayList<ArrayList<Integer>> UniquePartitions(int n)
    {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>() ;
        
        // adding values in array.
        int[] arr = new int[n+1] ;
        for(int i = 0 ; i <= n ; i++){
            arr[i] = i ;
        }
        
        helper(n, arr.length -1, arr, ans, new ArrayList<>()) ;
        return ans ;
    }
    
    
    public void helper(int n,int idx, int[] arr, ArrayList<ArrayList<Integer>> ans, ArrayList<Integer> list){
        if(n == 0){
            ans.add(new ArrayList<>(list)) ;
            return;
        }
        
        for(int i = idx ; i > 0 ; i--){ // trying values from idx to 0th index
            if(arr[i] > n) continue ;  // if greater than n then skip
            
            // otherwise add it to the list
            list.add(arr[i]) ;
            helper(n - arr[i], i ,arr , ans, list) ; // now recall 
            list.remove(list.size() - 1) ; // and remove last from the list
        }
    }




    // now without any extra space.

    public ArrayList<ArrayList<Integer>> UniquePartitions_(int n)
    {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>() ;
        helper_(n, n,ans, new ArrayList<>()) ;
        return ans ;
    }
    
    
    public void helper_(int n, int nn, ArrayList<ArrayList<Integer>> ans, ArrayList<Integer> list){
        if(n == 0){
            ans.add(new ArrayList<>(list)) ;
            return;
        }
        
        for(int val = nn ; val > 0 ; val--){ // trying values from idx to 0th index
            if(val > n) continue ;  // if greater than n then skip
            
            // otherwise add it to the list
            list.add(val) ;
            helper_(n - val, val, ans, list) ; // now recall 
            list.remove(list.size() - 1) ; // and remove last from the list
        }
    }
}

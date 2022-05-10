package Recursion_and_backtracking_level_02;
import java.util.*;

public class Q36_Combination_Sum {
    
    List<List<Integer>> ans ;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        
        ans = new ArrayList<>() ;
        helper(0, target, candidates, new ArrayList<>() ) ;
        return ans ;
    }
    
    void helper(int idx, int target,int[] arr, List<Integer> list){
        
        if(target == 0)
        {
            ans.add( new ArrayList<>(list)) ; // add when target becomes 0
            return ;
        }

        if(idx >= arr.length) return ; /// return when out of bound

        
        helper(idx+1,target,arr,list) ; // when current element is not part of our ans
        
        for(int i = 1 ; i*arr[idx] <= target ; i++){ // when current element is part of our answer i times.
            
            int j = i ;
            while(j-- > 0)
            list.add(arr[idx]);
            
            helper(idx+1,target- i*arr[idx], arr, list);
            
            j = i ;
            while(j-- > 0)
            list.remove(list.size() - 1);
            
        }
    }


    // without using loop in recursive function.

    void helper2(int idx, int target,int[] arr, List<Integer> list){
        
        if(target == 0)
        {
            ans.add( new ArrayList<>(list)) ;
            return ;
        }
        if(idx >= arr.length) return ;
        
        helper(idx+1,target,arr,list) ; // not taking current element
        
        if(arr[idx] <= target){
            list.add(arr[idx]) ;  // taking current element
            helper(idx,target - arr[idx],arr,list); // and again calling for same index.
            list.remove(list.size() - 1) ;
        }
    }
}

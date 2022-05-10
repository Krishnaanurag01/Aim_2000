package Recursion_and_backtracking_level_02;
import java.util.*;

public class Q38_Combination_Sum_II {

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(candidates) ;
        helper(0,candidates,target,new ArrayList<>(), ans) ;
        return ans ;
    }
    
    void helper(int idx, int[] arr, int target, List<Integer> list, List<List<Integer>> ans){
        
        if(target == 0){
            ans.add( new ArrayList<>(list)) ;
            return;
        }
        
        for(int i = idx ; i < arr.length ; i++){
            if(i > idx && arr[i-1] == arr[i]) continue ; // if previous element is same then don't use.
            if(arr[i] > target) break ; // breaking becuase our array is sorted and if current element is larger so all other higher inddex will also be largers.
            
            list.add(arr[i]) ; // adding to potential answer
            helper(i+1,arr,target - arr[i],list,ans) ;
            list.remove(list.size() - 1) ; // backtracking.
        }
    }
}

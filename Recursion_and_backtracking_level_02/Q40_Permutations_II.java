package Recursion_and_backtracking_level_02;
import java.util.*;

public class Q40_Permutations_II {

    List<List<Integer>> ans ;
    public List<List<Integer>> permuteUnique(int[] nums) {
        ans = new ArrayList<>() ;
       Arrays.sort(nums) ;
        helper(0,nums);
        return ans ;
    }
    
    // code is same as Q20 only added line is at 30.
    void helper(int idx,int[] arr) {
        
        if(idx == arr.length ){ // if list has all the element in it then add this to answer.
           ArrayList<Integer> list = new ArrayList<>() ;
            for(int val : arr){
                list.add(val) ;
            }
            
            ans.add(list) ;
            return ;
        }
        
       
        // we will try all element which are not used or taken.
        for(int i = idx ; i < arr.length ; i++){
            if( i != idx && ithAppearsBefore(idx,i,arr)) continue ; // here we will check if i is not idx and the ith element has appeared before then we will not consider this ith element as we are making distinct permutations.
            swap(arr,idx,i) ;
            helper(idx+1,arr) ;
            swap(arr,i,idx) ;
        }
    }
    
    void swap(int[] arr, int i, int j){
        int temp = arr[i] ;
        arr[i] = arr[j] ;
        arr[j] = temp ;
    }
    
    boolean ithAppearsBefore(int si, int curr, int[] arr){
        for(int i = si  ;  i < curr ; i++){
            if(arr[i] == arr[curr]) return true;;
        }
        return false;
    }
}

package LeetCode_Daily;
import java.util.*;

public class Q7_Permutation_2 {
    List<List<Integer>> ans ;

    public List<List<Integer>> permuteUnique(int[] nums) {
        ans = new ArrayList<>() ; // answer list.

        // converting array into arrayList.
        ArrayList<Integer> arr = new ArrayList<>() ;
        for(int val : nums){
            arr.add(val);
        }
        Collections.sort(arr) ; // now sorting which will help us in removing the duplicacy.
         helper(arr,new ArrayList<>());
        return ans ;
    }
    
    void helper(ArrayList<Integer> arr, List<Integer> list) {
        
        if(arr.size() == 0){
            ans.add(new ArrayList<>(list));
            return ;
        }
        
        // int[] narr = new int[]
        
        for(int i = arr.size() -1 ; i >= 0 ; i--){
            // removing from last in list take o(1) time insted of log(n)
            if(i < arr.size() - 1 && arr.get(i) == arr.get(i+1)) continue ; // if next element is same then skip.
            int bkp = arr.remove(i) ; // removing
            list.add(bkp); // adding to list
            helper(arr,list);
            arr.add(i,bkp) ; // adding again in the helper at the same position.
            list.remove(list.size() - 1); 
        }
        
    }    
}

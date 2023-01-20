package Problem_Of_The_day;
import java.util.*;

public class Q342_Non_decreasing_Subsequences {

    List<List<Integer>> ans ;
    HashSet<String> set ;
    public List<List<Integer>> findSubsequences(int[] nums) {
        ans = new ArrayList<>() ;
        set = new HashSet<>() ;
        helper(nums, 0, "", new ArrayList<>()) ;
        return ans ;
    }
    
    public void helper(int[] nums, int idx, String key, ArrayList<Integer> list){
        if(idx >= nums.length){
            if(set.contains(key) == false && list.size() > 1){
                ans.add(new ArrayList<>(list)) ;
                set.add(key) ;
            }
            return ;
        }
        
        int val = nums[idx] ;
        
        helper(nums, idx+1, key, list) ;
        
        if(idx == 0 || list.size() == 0 || list.get(list.size() - 1) <= val){
            list.add(val) ;
            helper(nums, idx+1, key + " - " + val, list) ;
            list.remove(list.size() - 1) ;
        }
    }
}

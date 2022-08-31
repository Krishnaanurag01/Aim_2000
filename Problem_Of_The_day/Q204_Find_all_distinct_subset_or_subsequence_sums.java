package Problem_Of_The_day ;
import java.util.*;

public class Q204_Find_all_distinct_subset_or_subsequence_sums {
    
    boolean[][] visited ; // esme hum bas etna store karenge ki phle kabhi same configuration k sath aaye h ki nhi
    public int[] DistinctSum(int[] nums)
    {
        HashSet<Integer> list = new HashSet<>();
        visited = new boolean[nums.length][10001] ;
        
        helper(0,nums,0,list) ;
        int[] ans = new int[list.size()] ;
        int k = 0 ;
        for(int val : list){
            ans[k] = val ;
            k++;
        }
        Arrays.sort(ans) ;
        
        return ans ;
    }
    
    void helper(int idx, int[] nums, int sum, HashSet<Integer> set){
        if(idx == nums.length ){
            set.add(sum) ;
            return ;
        }
        if(visited[idx][sum]) return ;// agar phle bhi same idx aur sum k sath aa chuke h toh retunr kar lo. kyuki same sum generate hoga aur hum disticnt chaiy.
        
        helper(idx+1, nums, sum + nums[idx], set) ;
        helper(idx+1, nums, sum, set) ;
        visited[idx][sum] = true ; // marking visited.
    }
}

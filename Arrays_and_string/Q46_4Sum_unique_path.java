package Arrays_and_string;
import java.util.*;

public class Q46_4Sum_unique_path {

    // it uses 3 sum as base.

    public List<List<Integer>> fourSum(int[] nums, int target) {
        
        Arrays.sort(nums) ;
        List<List<Integer>> ans = new ArrayList<>() ;
        
        for(int i = 0 ; i <= nums.length - 4 ; i++){
            
            if(i > 0 && nums[i] == nums[i-1]) // if num is not starting position and the nums[i] == nums[i-1] then skip it. 
                continue ;
            
            threeSum(nums,i+1,nums[i],target,ans) ; // go for the 3sum
        }
        
        return ans ;
    }
    
    public void threeSum(int[] nums, int si , int first , int target , List<List<Integer>> ans){
        
        
        for(int j = si ; j <= nums.length - 3 ; j++ ){
            
            if(j != si && nums[j] == nums[j-1])
                continue ;
            
            twoSum(nums,j+1,first,nums[j],target,ans) ;
            
        }
        
        
    }
    
    
    public void twoSum(int[] nums , int si , int first , int second , int target , List<List<Integer>> ans){
        
        int i = si ;
        int j = nums.length - 1 ;
        
        while(i < j){
            
            if( i!= si && nums[i] == nums[i-1]){
                i++ ;
                continue ;
            }
            
            int sum = first + second + nums[i] + nums[j] ;
            
            if(sum == target){
                
                List<Integer> in = new ArrayList<>() ;
                in.add(first) ;
                in.add(second) ;

                in.add(nums[i]) ;
                in.add(nums[j]) ;
                
                ans.add(in) ;
                
                
                i++ ;
                j-- ;
            }
            else if(sum < target){
                i++ ;
            }
            else{
                j-- ;
            }
            
        }
        
        
    }
    
}

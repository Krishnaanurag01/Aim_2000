package Problem_Of_The_day ;
import java.util.*;

public class Q196_3Sum_Closest {

    public int threeSumClosest(int[] nums, int target) {
        
        int ans = (int)1e9 ;
        Arrays.sort(nums) ;
        
        for(int i = 0 ; i < nums.length - 2 ; i++){
            
            int temp = helper(i+1, nums, target - nums[i]) ;
            if(nums[i] + temp == target) return target ;
            if(Math.abs(target - ans)  > Math.abs(target - (temp+ nums[i])) ){
                ans = temp + nums[i] ;
            }
        }
        
        return ans ;
    }
    
    int helper(int si, int[] nums, int target){
        
        int i = si ;
        int j = nums.length - 1 ;
        int sum = (int)1e9 ;
        
        while(i < j){
            int num1 = nums[i] ;
            int num2 = nums[j] ;
            int temp = num1 + num2 ;
            
            if(Math.abs(target - temp) < Math.abs(target-sum)){
                sum = temp ;
            }
            
            if(temp < target){
                i++;
            }
            else if(temp > target){
                j--;
            }
            else{
                return target ;
            }
        }
        
        return sum ;
    }
}

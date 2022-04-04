package Dynamic_Programming_extras ;

public class Q16_Target_Sum {

    // recursive code : does not give tle

    public int findTargetSumWays(int[] nums, int target) {
        
        return helper(nums.length - 1 , nums, 0, target) ;
    }
    
    static int helper(int i, int[] nums, int ssf, int target){
        
        if(i == 0){
            if(ssf +nums[i] == target && ssf - nums[i] == target ) return 2 ; // if after adding and subtracting the first number we got target in both way then return 2
            if(ssf +nums[i] == target || ssf - nums[i] == target ) return 1 ; // else if any add or subtract will make target equal then return 1.
            return 0 ; // else return 0.
        }

        
        int add = helper(i-1,nums,ssf+nums[i], target ) ; // adding.
        int sub = helper(i-1,nums,ssf-nums[i], target ) ; // subtracting.
        
        return add + sub ; // returning total count.
    }
    

    // optimal soluion : 
    // same as Q13.

    // if we take all +element at s1 and all -element in negative side then it will be same as Q13
    public int findTargetSumWays2(int[] nums, int target) {
        int sum = 0 ;
        for(int i : nums) sum+= i ;
        if((sum - target < 0) || (sum - target ) % 2 != 0 ) return 0 ;
        return helper(nums,(sum-target)/2) ;
    }
    
    static int helper(int[] nums, int target){
        
        int[] prev = new int[target+1] ;
        if(nums[0] == 0 ) prev[0] = 2 ;
        else prev[0] = 1 ;
        
        if(nums[0] != 0 && nums[0] <= target ) prev[nums[0]] = 1 ;

        
        for(int i = 1 ; i < nums.length ; i++){
            int[] temp = new int[target+1] ;
            for(int j = 0 ; j <= target ; j++){
                int notTook = prev[j] ;
                int took = 0 ;
                if(nums[i] <= j)
                    took = prev[ j - nums[i] ] ;
                
                temp[j] = notTook + took ;
            }
            prev = temp ;
        }
        
        return prev[target] ;
    }
}

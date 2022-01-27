package Arrays_and_string_level_02;

public class Q69_Maximum_average_subarray {

    public double findMaxAverage(int[] nums, int k) {
        
        int right = 0 ;

        double ans = 0 ; // final ans
        double sum = 0 ; // current sum
        
        while(right < k){  // first adding all k elements.
            sum += nums[right++] ;
        }
    
        ans = sum ;    
                        // System.out.println(ans) ;

        for(int i = right , left = 0  ; i < nums.length ; i++ , left++){ // now sliding widnows to i side and removing from left side
            sum += nums[i] ; // adding right side
            sum -= nums[left] ; // removing left side
            
            ans = Math.max(ans,sum) ; // updating answer
        }
        
        // System.out.println(ans) ;
        
        return ans/(double)k ; // returning average answer.
        
    }
    
}

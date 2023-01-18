package Problem_Of_The_day;

public class Q340_Maximum_Sum_Circular_Subarray {

    public int maxSubarraySumCircular(int[] nums) {
        int[] left = new int[nums.length] ; // here we will store best prefix sum.
        
        // finding best subarray using kadanes.
        int best = nums[0] ;
        int curr = nums[0] ;
        left[0] = best ; // storing bestpref sum.
        
        int currPref = best ; // intitally best pref is equals to best 
        
        for(int i = 1 ; i < nums.length ; i++){
            int val = nums[i] ;
            curr += val ;
            currPref += val ; // adding to curr prefix
            
            if(val > curr){
                curr = val ;
            }
            
            if(best < curr){
                best = curr ;
            }
            
            if(currPref < left[i-1]){ // if curr prefx is leff than prev best prefix then use prev best
               left[i] = left[i-1] ;    
            }
            else{ // else use curr prefix
                left[i] = currPref ;
            }
        }
        
        // now take best prefix from right side with best prefix from left.
        
        int ans = best ; // storing best ans of kadanes so that if any midddle subarray has max answer then that will be covered.
        int bestR = 0 ; // best prefix from right
        curr = 0 ; // curr prefix from right/
        
        for(int i = nums.length - 1 ; i >= 1 ;i--){
            int val = nums[i] ;
            curr += val ; // adding to current prefix of right
            
            if(bestR < curr){ // storing best prefix.
                bestR = curr ;
            }
            
            int temp = bestR +  left[i-1]  ; // now summing the best prefix from both side.
            ans = Math.max(ans, temp) ; // and finding the answer.
        }
        
        return ans ;
    }
}

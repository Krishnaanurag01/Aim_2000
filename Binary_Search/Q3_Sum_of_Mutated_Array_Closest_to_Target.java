package Binary_Search;

public class Q3_Sum_of_Mutated_Array_Closest_to_Target {

    public int findBestValue(int[] arr, int target) {
        
        int low = 0 ;
        int high = 0 ;
        for(int val : arr) high = Math.max(high,val) ; // we have to take high value with max of arr. becuase ek value ek baad sare values same answer dene lagenge aur answer k base par judge karna aur min value khoja difficult ho jayega.
        
        
        // as we are working on absolute diff so we have to maintain two sides. one side which is less than target and other side is greater than target.
        
        int left_diff = (int)1e9 ;
        int left_best = (int)1e9 ;
        
        int right_diff = (int)1e9 ;
        int right_best = (int)1e9 ;
        
        while(low <= high){
            int mid = low + (high - low)/2 ; 
            int sum = getSum(arr, mid) ;
            
            if(sum < target){ // when new sum is lesser than target
                if(Math.abs(target - sum) < left_diff){ // check it is also less than prev diff then update it
                    left_diff = target- sum ;
                    left_best = mid ;
                }
                low = mid + 1 ; // and in order to get less diff we have to increase the low so that we can go closer to target.
            }
            else{ // when sum is higher.
                if(Math.abs(target-sum) < right_diff){
                    right_diff = Math.abs(target - sum) ;
                    right_best = mid ;
                }
                high = mid - 1; // in order to go closer to target we have to go lower.
            }
        }
        
        return left_diff <= right_diff ? left_best : right_best ;
    }
    
    int getSum(int[] nums, int x){
        int sum = 0 ;
        for(int val : nums) sum += Math.min(val,x) ;
        return sum ;
    }
}

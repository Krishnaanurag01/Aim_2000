package Problem_Of_The_day;

public class Q315_Split_Array_Largest_Sum {
    
    static int splitArray(int[] arr , int N, int K) {
        
        long low = (int)1e9 ; 
        long high = 0 ;
        
        for(int val : arr) {
            low = Math.min(low, val); // taking the min value as low
            high += val; // ans sum in high
        }

        long ans = 0 ; 
        
        
        // now applying the binary search.
        while(low <= high){
            long mid = low + (high - low)/2 ; // now this is current max sum, check with this sum whether we can divide arrr into k subarrya with max sum eqaul to mid
            if(isPossible(mid, arr, K)){
                ans = mid ;
                high = mid - 1 ; // now finding the min possible answer.
            }
            else{
                low = mid + 1;
            }
        }
        
        return (int)ans ;
    }
    
    
    static boolean isPossible(long max_sum, int[] arr, int k){
        
        
        int curr_sum = 0 ; 
        k-- ; // reducing because we starting sum for first subarray
        
        for(int val : arr){
            if(val > max_sum) return false ; // if any value is greater than max sum then return false.
        }
        
        
        for(int i = 0 ; i <  arr.length ; i++){
            int val = arr[i] ;
            if(arr.length - i == k) return true ;// if we could divide each element into k part then do it already
            
            curr_sum += val ; // now adding to sum
            if(curr_sum > max_sum ){ // if becomes greater then it means its the start of next subarray
                curr_sum = val ;
                k-- ;
            }
        }
        
        return k == 0 ;
    }
}

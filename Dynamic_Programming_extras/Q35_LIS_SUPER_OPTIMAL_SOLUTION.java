package Dynamic_Programming_extras;

public class Q35_LIS_SUPER_OPTIMAL_SOLUTION {


    // using binary search. // takes O(n) space and O(nlogn) time.
    public int lengthOfLIS(int[] nums) {
        
        int[] LIS = new int[nums.length] ; // this will hold answer LIS.
        int k = 0 ; // index is last inserted  num in sequence.
        LIS[k] = nums[0]; // adding first by default
        
        for(int i = 1 ; i < nums.length ; i++){    
            int val = nums[i] ;   
            if(val > LIS[k]){ // if value is greater then add directly in array.
                k++ ;
                LIS[k] = val ;
            }
            else{ // otherwise when val is smaller then override in the LIS
                override(val,LIS,k) ;
            }
        }
        return k - 0 + 1 ;
    }
    
    // using binary search to override the value. this will return without any operation if the value we want to override is already present in lis else it will override the val on value that is just larger. 
    static void override(int val, int[] lis, int high){
        
        int low = 0 ;
        
        while(low <= high){
            int mid = (low+high)/ 2 ;
            
            if(lis[mid] == val){ // if value is already presen then return and dont do anything
                return ;
            }
            
            if(lis[mid] < val){ // check larger side
                low = mid+1 ;
            }
            else{ // check smaller side
                high = mid - 1 ;
            }       
        }        
        lis[high+1]= val ; // overriding on just larger value of val.
    }



    // storing lis in the same given array so space comp will be o(1) but it is not preffered in interview to use same given array.


    public int lengthOfLIS2(int[] nums) {
        
        // int[] LIS = new int[nums.length] ;
        int k = 0 ;
        // LIS[k] = nums[0];
        // k++ ;
        
        for(int i = 1 ; i < nums.length ; i++){    
            int val = nums[i] ;
            
            if(val > nums[k]){
                k++ ;
                nums[k] = val ;
            }
            else{ // otherwise when val is smaller then override in the LIS
                override(val,nums,k) ;
            }
        }
        
        return k - 0 + 1 ;
    }
    
}

package Searching_Sorting_level_02;

public class Q21_Split_Array_Largest_Sum {
    
    // ditto same as Q20
    public int splitArray(int[] nums, int m) {
        
        int sum = 0 ; 
        
        for(int val : nums) // calculating sum
            sum += val ;
        
        if(m == 1){ // when no of subarray asked is 1 then return the sum directly
            return sum ;
        }
    
        
        int low = 0 ; 
        int high = sum ; // high will be total sum
        int ans = 0 ;
        while(low <= high ){
            
            int mid = low + ( high - low )/2 ;
            
            int MLS = isPossible(nums,m,mid) ; // minimal largest sum
            
            if(MLS != -1){ // if it is not -1 then it means It is one of the possible answer
                ans = MLS ; // and update the answer
                high = mid - 1 ;  // now check with lower higher range
            }
            else{
                low = mid + 1 ; // else go with larger sum
            }
        }
        
        return ans ;
    }
    
    public int isPossible(int[] nums , int m , int range){
        
        // same as Q20

        int count = 1 ; // taking 1 (one of m) by default
        int max =  0 ;
        int sum = 0 ;
        
        for(int i = 0 ; i < nums.length ; i++){
            sum += nums[i] ;
            
            if(sum > range){
                count++ ;
                
                sum = nums[i] ;
                max = Math.max(sum,max) ;
            }
            else{
              max = Math.max(sum,max) ;   
            }
        }
        
        return count > m ? -1 : max ;
    }

}

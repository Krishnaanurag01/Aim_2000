package Arrays_and_string_level_02;

public class Q8_Product_of_Array_Except_Self {
    
    public int[] productExceptSelf(int[] nums) {
        
        int n = nums.length ;
        
        int[] right = new int[n] ;
        
        right[n-1] = nums[n-1] ;
        
        for(int i = n - 2 ; i >= 0 ; i--){
            right[i] = nums[i]*right[i+1] ; 
        }
        
        int left_prefix = 1 ;
        int[] ans = new int[n] ;
        
        for(int i = 0 ; i < n ; i++){
            
            int left_is = left_prefix ;
            int right_is = i < n - 1 ? right[i+1] : 1 ;
            
            ans[i] = left_is*right_is ;
            
            left_prefix *= nums[i] ;
        }
        
    
        return ans ;
        
    }
}

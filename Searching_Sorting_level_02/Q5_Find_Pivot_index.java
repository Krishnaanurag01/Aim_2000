package Searching_Sorting_level_02;

public class Q5_Find_Pivot_index {

    // method 01 : finding both the left pre sum and right pre sum and checking pivot index.
    public int pivotIndex(int[] nums) {
        
        int n = nums.length ;
        int[] lps = new int[n] ; // lps -> left pre sum
        lps[0] = nums[0] ;
        
        // calculating and storing the left presum
        for(int i = 1 ; i < n ; i++){
            lps[i] = nums[i] + lps[i-1] ;
        }
        
        int[] rps = new int[n] ; // rps -> right pre sum
        rps[n-1] = nums[n-1] ;
        
        // calculating and storing the right presum
        for(int i = n-2 ; i >= 0 ; i--){
            rps[i] = rps[i+1] + nums[i] ;
        }
        
        int idx = -1 ; // this will contains the pivot index.
        
        for(int i = 0 ; i < n ; i++ ){
            int left , right ;
            
            if(i == 0){ // when i is on left edge then left will be 0
                left = 0 ;
                right = rps[i+1] ;
            }
            else if(i == n-1){ // when i is on right edge then right will be 0
                 left = lps[i-1] ;
                 right = 0 ;
            }
            else{
                left  = lps[i-1] ;
                right = rps[i+1] ;
            }
            
            if(left == right){ // when left equals right then update the pivot index.
                idx = i ;
                break ;
            }
        }
        
        return idx ;
     }
    

     // method 02 : only finding the right pre sum and calculating the left presum while traversing array.

     public int pivotIndex2(int[] nums) {
        
        int n = nums.length ;

        int[] rps = new int[n] ; // rps -> right pre sum
        rps[n-1] = nums[n-1] ;
        
        // calculating and storing the right presum
        for(int i = n-2 ; i >= 0 ; i--){
            rps[i] = rps[i+1] + nums[i] ;
        }
        
        int idx = -1 ; // this will contains the pivot index.
        int presum = 0 ;
        
        for(int i = 0 ; i < n ; i++ ){
            int  right ;
            
            if(i == 0){ // when i is on left edge then presum will be 0
                presum = 0 ;
                right = rps[i+1] ; // and right sum is rps[i+1]
            }
            else if(i == n-1){ // when i is on right edge then right will be 0 
                 right = 0 ;
            }
            else{
                right = rps[i+1] ;
            }
            
            if(presum == right){ // when presum equals right sum then update the pivot index.
                idx = i ;
                break ;
            }

            presum += nums[i] ; // calculating the presum
        }
        
        return idx ;
     }

     // method 03 : optimal one! use's O(1) extra space 

     public int pivotIndex3(int[] nums) {
      
        int n = nums.length ;

     int sum = 0 ;
      
      for(int i : nums){
          sum += i ;
      }
      
      int lSum = 0 ;
      int rSum = sum ;
      
      for(int i = 0 ; i < n ; i++){
          rSum -= nums[i] ;
          
          if(lSum == rSum){
              return  i ;
          }
          
          lSum += nums[i];
      }
      
      return -1 ;
      
   }
}

package Dynamic_Programming_extras;

public class Q51_Minimum_Number_of_Removals_to_Make_Mountain_Array {
    
    public int minimumMountainRemovals(int[] nums) {  // using bitonic subseq code
        
        int[] dpi = new int[nums.length] ;
          int[] dpd = new int[nums.length] ;
          
          for(int i = 0 ; i < nums.length ; i++){
              int max = (int)-1e9 ;
              for(int j = 0 ; j < i ; j++){
                  if(nums[j] < nums[i]){
                      max = Math.max(max, dpi[j] + 1) ;
                  }
              }
              dpi[i] = max == (int)-1e9 ? 1 : max  ;
          }
          
          
          for(int i = nums.length - 1 ; i >= 0 ; i--){
              int max = (int)-1e9 ;
              for(int j = nums.length - 1 ; j > i ; j--){
                  if(nums[j] < nums[i]){
                      max = Math.max(max, dpd[j] + 1) ;
                  }
              }
              dpd[i] = max == (int)-1e9 ? 1 : max ;
          }
          
          int max = (int)1e9;
          for(int i = 0 ; i < nums.length ; i++){
              if(dpi[i] == 1 || dpd[i] == 1) continue ; // skiping becuase this denote that mountain has not left size or right size.
              max = Math.min(max, nums.length -  (dpi[i] + dpd[i] - 1 ))  ; // getting min.
          }
          
          // System.out.println(max) ;
      
          return  max ;
      }



      // using binary search lis for optimality.
}

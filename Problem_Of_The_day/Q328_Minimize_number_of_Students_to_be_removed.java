package Problem_Of_The_day;

public class Q328_Minimize_number_of_Students_to_be_removed {

          // LIS Application.
           
          public int removeStudents(int[] nums, int N) {
            int k = 0 ; // index in nums where it denotes that k + 1 student taken in LIS
    
            // same he array me answer bana rhe esme.
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
            
            return N - k - 1 ;
        }
        
         void override(int val, int[] lis, int high){
            
            int low = 0 ;
            
            while(low <= high){
                int mid = (low+high)/ 2 ;
                
                if(lis[mid] == val){
                    return ;
                }
                
                if(lis[mid] < val){
                    low = mid+1 ;
                }
                else{
                    high = mid - 1 ;
                }       
            }        
    
            lis[low]= val ;
        }
}

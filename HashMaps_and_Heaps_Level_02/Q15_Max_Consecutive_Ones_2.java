package HashMaps_and_Heaps_Level_02;

public class Q15_Max_Consecutive_Ones_2 {

    public int longestOnes(int[] nums, int k) {
        
        int n = nums.length ;
        
        int msc = 0 ; // measured count.
        int ans = 0 ;
        

        int j = -1 ; 
        
       for(int i = 0 ; i < n ; i++){
           
        // Aquiring.
           int num = nums[i] ;
           
            if(num == 0 )
               msc++ ;
           
        // if count is greater than k then release.
            while(msc > k){
               j++ ;
               int nj = nums[j] ;
               
               if(nj == 0)
                   msc-- ;
            }

            // calculating answer.
           
           ans = Math.max(ans,i-j) ;
           
       }
        return ans ;
        
    }
    
}

package Dynamic_Programming_extras;

public class Q2_House_Robber_II {

    public int rob(int[] nums) {
       
        if(nums.length == 1) return nums[0] ;
        int[] temp1 = new int[nums.length];  // this will not include first element
        int[] temp2 = new int[nums.length] ;  // not include the last element.
      
        int j = 1 ;
        int k = 0 ;
        for(int i = 0 ; i < nums.length ; i++){
            // System.out.println(i)
            if(i != 0) temp1[j++] = nums[i] ;
            if(i != nums.length - 1) temp2[k++] = nums[i] ;
        }
        
        // now check max when not including first or when not including last.
        return Math.max(rob3(temp1), rob3(temp2)) ;
     }
     
     // using house robber one function.
      public int rob3(int[] nums) {
        
         int fp = nums[0] ; // first prev
         int sp = 0 ; // second prev
         
         for(int i = 1 ; i < nums.length ; i++){
             int notPicked = 0 + fp ; // if not picked then take i-1 ans(just previous or fp)
             int picked = nums[i] + ( i > 1 ? sp : 0 ) ; // take sp(second previous that is i-2)
             sp = fp ; // now sp becomes fp
             fp = Math.max(notPicked,picked) ; // and new fp assigned
         }
         return fp ;
     }
    
}

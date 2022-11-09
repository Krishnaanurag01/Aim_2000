package Problem_Of_The_day ;
public class Q288_Rearrange_Array_Elements_by_Sign {
    public int[] rearrangeArray(int[] nums) {
        
        int[] ans = new int[nums.length] ;
        int p = 0 ; // positive index
        int n = 1 ; // negative index
        
        for(int val : nums){
            if(val >= 0){ // when number is positive
                ans[p] = val ;
                p += 2 ;
            }
            else{ // when number is negative
                ans[n] = val ;
                n += 2 ;
            }
        }
        
        return ans ;
    }
}

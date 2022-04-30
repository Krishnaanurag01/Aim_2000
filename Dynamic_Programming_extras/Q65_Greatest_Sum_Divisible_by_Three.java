package Dynamic_Programming_extras;

public class Q65_Greatest_Sum_Divisible_by_Three {

    public int maxSumDivThree(int[] nums) {
        
        int[] temp = new int[3] ; // 0th index store max sum with 0 remainder , 1 for sum with 1 remainder and same for 2.
        
        for(int i = 0 ; i < nums.length; i++){
            int wz = nums[i] + temp[0] ;  // adding current num with zeroth index max sum
            int wo = nums[i] + temp[1] ; // with 1th index max sum
            int wt = nums[i] + temp[2] ; // with 2nd index max sum 
            
            // updating the max value
            if(temp[wz%3] < wz)
                temp[wz%3] = wz ;
            
            if(temp[wo%3] < wo)
                temp[wo%3] = wo ;
            
            if(temp[wt%3] < wt)
                temp[wt%3] = wt ;
        }
        
        return temp[0] ;
    }
}

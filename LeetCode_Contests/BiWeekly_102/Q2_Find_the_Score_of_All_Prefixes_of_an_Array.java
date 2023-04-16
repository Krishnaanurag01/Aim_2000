package LeetCode_Contests.BiWeekly_102;

public class Q2_Find_the_Score_of_All_Prefixes_of_an_Array {
    
    public long[] findPrefixScore(int[] nums) {
        long[] conver = new long[nums.length] ;
        long[] score = new long[nums.length] ;
        
        int max = (int)-1e9 ;
        
        for(int i = 0 ; i < nums.length ; i++){
            max = Math.max(max, nums[i]) ;
            conver[i] = max + nums[i] ;
            
            if(i == 0){
                score[i] = conver[i] ;
            }
            else{
                score[i] = score[i-1] + conver[i] ;
            }
        }
        
        return score ;
    }
}

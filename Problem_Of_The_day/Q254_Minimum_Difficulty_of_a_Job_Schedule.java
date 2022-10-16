package Problem_Of_The_day;

public class Q254_Minimum_Difficulty_of_a_Job_Schedule {

     
    Integer[][] dp  ;
    public int minDifficulty(int[] jobDifficulty, int d) {
        
        if(jobDifficulty.length < d) return -1 ; // if we have lesser jobs than days then In that case we can't perform task on each day.
        
        dp = new Integer[d+1][jobDifficulty.length] ;
        
        return helper(0, d, jobDifficulty) ;
    }
    
    int helper(int idx, int days, int[] jobs){
        
        if(days == 1){ // when only one day is there then the max job diff is answer.
            int max = 0 ;
            for(int i = idx; i < jobs.length ; i++){
                max = Math.max(max, jobs[i]) ;
            }
            
            return max ;
        }
        
        // checking if solved before
        if(dp[days][idx] != null) return dp[days][idx] ;
        
        int ans = (int)1e9 ;
        int left_max = 0 ;
        
        // partioning at ith index and searching the answer in other part.
        for(int i = idx ; i < jobs.length - days + 1 ; i++){
            left_max = Math.max(left_max, jobs[i]) ; // taking max at thee same time.
            
            int left_part = left_max ;
            int right_part = helper(i+1, days - 1, jobs) ; // finding the answer for next part.
            
            ans = Math.min(ans, left_part + right_part) ; /// chose the min ans.
        }
        
        
        return dp[days][idx] = ans ;
    }
}

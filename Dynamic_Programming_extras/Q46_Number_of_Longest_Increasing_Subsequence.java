package Dynamic_Programming_extras;

public class Q46_Number_of_Longest_Increasing_Subsequence {

    public int findNumberOfLIS(int[] nums) {
      
        int[] dp = new int[nums.length] ;
        int[] count = new int[nums.length] ; // using this additonal count array which will tell the count of subsequence.
        int lis = 0 ;
        int countSeq = 0 ;
        
        for(int i = 0 ; i < nums.length ; i++){
            dp[i] = count[i] = 1 ;
            for(int j = 0 ; j < i ; j++){
                if(nums[j] < nums[i]){
                    if(dp[j] + 1 > dp[i]){ // if bigger subseq found update 
                        dp[i] = dp[j] + 1;
                        count[i] = count[j] ; // also update with it's count
                    }
                    else if(dp[j] + 1 == dp[i]){
                        count[i] += count[j] ; // when same subseq comes add all the count of that.
                    }
                }
            }

            // also updating answer.
            if(lis < dp[i]){
                lis = dp[i] ;
                countSeq = count[i] ;
            }
            else if(lis == dp[i]){
                countSeq += count[i] ;
            }
        }

        return countSeq ;
    }
}

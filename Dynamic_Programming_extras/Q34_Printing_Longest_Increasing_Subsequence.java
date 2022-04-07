package Dynamic_Programming_extras;
public class Q34_Printing_Longest_Increasing_Subsequence {

    public int lengthOfLIS(int[] nums) { // using q33 last approch
        
        int[] dp = new int[nums.length+1] ;
        int[] hash = new int[nums.length+1] ; // store the previous child of lis.
        int ans = 0 ;
        int ansidx = 0 ;
        
        for(int i = 0 ; i < nums.length ; i++){
            int max = (int)-1e8 ;
            hash[i] = i ; // storing same index by default in hash array
            for(int j = 0 ; j < i ; j++){
                
                if(nums[j] < nums[i] && dp[j] > max ){
                    max =  dp[j] ; // taking max lis till now.
                    hash[i] = j ; // and storing/overiding the previous max lis.
                }
            }

            dp[i] = max == (int)-1e8 ?  1 : max + 1 ;
            
            if(ans < dp[i]){
                ans = dp[i] ;
                ansidx = i ;  // this is starting for priting the LIS.
            }   
        }
        

        // printing the LIS.
        StringBuilder lis = new StringBuilder() ;
        lis.append(nums[ansidx]) ;
        
        while(hash[ansidx] != ansidx){
            lis.append( nums[ hash[ansidx] ] ) ;
            ansidx = hash[ansidx] ;
        }
        
        System.out.println(lis.reverse().toString()) ;
        
        return ans ;
    }
    
}

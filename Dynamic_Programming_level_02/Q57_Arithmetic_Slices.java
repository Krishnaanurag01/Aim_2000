package Dynamic_Programming_level_02;

public class Q57_Arithmetic_Slices {

    public static void main(String[] args) {
        
    }

    public static int get_number_of_arithmatic_slice(int[] nums) {
        
        int[] dp = new int[nums.length];
        int ans = 0 ;  

        for (int i = 2 ; i < dp.length; i++) {
            if(nums[i] - nums[i-1] == nums[i-1] - nums[i-2]){ // if current element - previous element diffrence is same as previous element - previou's previous element then add 1 to previous element dp and update answer.
                dp[i] = dp[i-1] + 1 ;
                ans += dp[i] ;
            }
        }
        return ans ;
    }
    
}

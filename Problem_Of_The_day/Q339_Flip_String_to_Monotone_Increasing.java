package Problem_Of_The_day;

public class Q339_Flip_String_to_Monotone_Increasing {
    Integer[][] dp ; // using memoization.
    public int minFlipsMonoIncr(String s) {
        dp = new Integer[s.length()][2] ;
        return helper(s, 0, '#'); // # is prev char of 0th char
    }

    public int helper(String s, int idx, char prev) {
        if (idx >= s.length()) {
            return 0;
        }
        int skey = prev == '0' ? 0  : 1 ; // changing prev into int form to store in memoi
        if(dp[idx][skey] != null) return dp[idx][skey]; 

        char ch = s.charAt(idx);

        if (prev == '#') { // means we are at first index.
            if (ch == '0') return dp[idx][skey] = helper(s, idx + 1, '0'); // if first index is itself 0 then no issue
            // else if it is then check for both case
            
            int min = 1 + helper(s, idx + 1, '0'); // case 1 : change to 0
            min = Math.min(min, helper(s, idx + 1, '1')); // case2 : continue with 1 
            return dp[idx][skey] = min; // and return min answer.
        } else {
            if (ch == prev) return dp[idx][skey] = helper(s, idx + 1, ch); // when it is same with prev then no issue

            if (prev == '0') { // if prev is 0 and current is 1
                int min = 1 + helper(s, idx + 1, '0'); // case 1 : change to 0
                min = Math.min(min, helper(s, idx + 1, '1')); // case 2 : continue with 1
                return dp[idx][skey] = min; // 
            } else {
                return dp[idx][skey] = 1+ helper(s, idx+1, '1') ; // when prev is 1 and curr is 0 then we must change this 0 to 1.
            }
        }
       
    }
}

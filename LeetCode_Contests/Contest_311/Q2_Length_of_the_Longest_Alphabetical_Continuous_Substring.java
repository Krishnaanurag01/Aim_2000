package LeetCode_Contests.Contest_311;

public class Q2_Length_of_the_Longest_Alphabetical_Continuous_Substring {

    public int longestContinuousSubstring(String s) {
        
        if(s.length() == 0) return 0 ;
        
        StringBuilder sb = new StringBuilder();
        int ans = 1 ;
        int curr = 0 ;
        
        for(char ch : s.toCharArray()){
            if(sb.length() == 0 ){
                sb.append(ch) ;
                curr = 1 ;
            }
            else{
                int lc = sb.charAt(sb.length() - 1) - 'a' + 1 ;
                int cc = ch - 'a' + 1 ;
                if(lc + 1 == cc){
                    sb.append(ch) ;
                    curr++ ;
                    ans = Math.max(ans, curr) ;
                }
                else{
                    sb.append(ch) ;
                    curr = 1 ;
                }
            }
        }
        
        return ans ;
    }
}

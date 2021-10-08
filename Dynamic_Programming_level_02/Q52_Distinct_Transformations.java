package Dynamic_Programming_level_02;

public class Q52_Distinct_Transformations {

    public static void main(String[] args) {

        String s1 = "abcccdf"; 
        String s2 = "abccdf" ;

        
        System.out.println(get_distinct_transformations(s1, s2, 0 , 0));

        int[][] dp = new int[s1.length()][s2.length()] ;
        
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                dp[i][j] = -1 ;
            }
        }

        System.out.println( get_total_ways(s1, s2,0,0, dp));
    }


    // recursive way :

    public static int get_distinct_transformations(String s , String t , int si , int ti) {
        
        if(si == s.length()){ // if s1 string index == s.length then check if target string index is less than t.length() then return 0 
            if(ti < t.length()){
                return 0 ;
            }
            else{ // else return 1;
                return 1 ;
            }
        }
        else if(ti == t.length()){ // else if target index string is completed then return 1.
            return 1; 
        }

        // took both char of both string.
        char c1 = s.charAt(si) ;
        char c2 = t.charAt(ti) ;

        int tw = 0 ;

        if(c1 != c2){ // if both are not same then remove first char and check with si +1
            tw = get_distinct_transformations(s, t, si+1, ti) ;
        }
        else{ // if both char are same then we have two options : first is to remove and look for si+1 and second is we take both char and go with si+1 and ti+1.
            int tw1 = get_distinct_transformations(s, t, si+1, ti) ;
            int tw2 = get_distinct_transformations(s, t, si+1, ti+1);
            tw = tw1 + tw2 ;
        }

        return tw ;
    }


    // method 02 : using memoization.

    public static int get_total_ways(String s, String t ,int si , int ti , int[][] dp) {

        
        if(si == s.length()){ // if s1 string index == s.length then check if target string index is less than t.length() then return 0 
            if(ti < t.length()){
                return 0 ;
            }
            else{ // else return 1;
                return 1 ;
            }
        }
        else if(ti == t.length()){ // else if target index string is completed then return 1.
            return 1; 
        }

        if(dp[si][ti] != -1){
            return dp[si][ti] ;
        }

        // took both char of both string.
        char c1 = s.charAt(si) ;
        char c2 = t.charAt(ti) ;

        int tw = 0 ;

        if(c1 != c2){ // if both are not same then remove first char and check with si +1
            tw = get_distinct_transformations(s, t, si+1, ti) ;
        }
        else{ // if both char are same then we have two options : first is to remove and look for si+1 and second is we take both char and go with si+1 and ti+1.
            int tw1 = get_distinct_transformations(s, t, si+1, ti) ;
            int tw2 = get_distinct_transformations(s, t, si+1, ti+1);
            tw = tw1 + tw2 ;
        }

        dp[si][ti] = tw;
        return tw ;
        
    }

    //method 03 : using tabulation

    public static int get_total_ways2(String s , String t) {
        
        int[][] dp = new int[t.length()+1][s.length()+1]; // target string is on row side and given string is on col side.

        for (int i = dp.length - 1 ; i >= 0 ; i--) {
            for (int j = dp[0].length - 1 ; j >= 0 ; j--) {
                
                if(i == dp.length-1){ //last row is 1 as last in this index target is "" so we'll delete every character in string so 1 way only
                    dp[i][j] = 1 ;
                }
                else if(j == dp[0].length){
                    dp[i][j] = 0 ;  // we can't make target string with '' char.
                }
                else{
                    // now same logic as previous methods
                    char c1 = t.charAt(i);
                    char c2 = s.charAt(j) ;

                    if(c1 == c2){ // if same then search diagonal and previous string(leaving current char)
                        dp[i][j] = dp[i+1][j+1] + dp[i][j+1] ;
                    }
                    else{ 
                        dp[i][j] = dp[i][j+1] ;
                    }
                }
            }
        }

        return dp[0][0] ;
    }
    
}

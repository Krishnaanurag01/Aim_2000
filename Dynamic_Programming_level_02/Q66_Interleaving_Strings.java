package Dynamic_Programming_level_02;

public class Q66_Interleaving_Strings {

    public static void main(String[] args) {

        String s1 = "aabcc", s2 = "dbbca", s3 = "aadbbbaccc" ;

        if(s1.length() + s2.length() != s3.length()){ // when length of s3 is different then false
           System.out.println( false ) ; 
        }
        System.out.println( can_str3_formed_by_interlived2(s1,s2,s3,0,0, new Boolean[s1.length()+1][s2.length()+1]) ) ;
    }

    // recursive solution

    public static boolean can_str3_formed_by_interlived(String s1 , String s2 , String s3 , int i , int  j) {
        
        if(i == s1.length() && j == s2.length()){ // both i and j becomes equal to their length then return true
            return true ;
        }


        // i + j == k (string 3 pointer)

        if( i < s1.length() && s1.charAt(i) == s3.charAt(i+j) ){

            boolean f1 = can_str3_formed_by_interlived(s1, s2, s3, i+1, j);  // when s1[i] == s3[i+j] then check with i+1 index

            if(f1 == true){
                return true ;
            }
        }

        if( j < s2.length() && s2.charAt(j) == s3.charAt(i+j) ){

            boolean f2 = can_str3_formed_by_interlived(s1, s2, s3, i, j+1);  // when s2[j] == s3[i+j] then check with j+1 index

            if(f2 == true){
                return true ;
            }
        }



        return false; // else returnn false
    }

    // using memoization
    // method  - 02

    public static boolean can_str3_formed_by_interlived2(String s1 , String s2 , String s3 , int i , int  j , Boolean[][] dp ) {
        
        if(i == s1.length() && j == s2.length()){ // both i and j becomes equal to their length then return true
            return true ;
        }


        // checking if dp has already answer.

        if( dp[i][j] != null){
            return  dp[i][j] ;
        }

        // i + j == k (string 3 pointer)

        if( i < s1.length() && s1.charAt(i) == s3.charAt(i+j) ){

            boolean f1 = can_str3_formed_by_interlived2(s1, s2, s3, i+1, j, dp);  // when s1[i] == s3[i+j] then check with i+1 index

            dp[i][j] = f1; // storing answer to dp

            if(f1 == true){
                return true ;
            }
        }

        if( j < s2.length() && s2.charAt(j) == s3.charAt(i+j) ){

            boolean f2 = can_str3_formed_by_interlived2(s1, s2, s3, i, j+1, dp);  // when s2[j] == s3[i+j] then check with j+1 index

            dp[i][j] = f2; // storing answer to dp

            if(f2 == true){
                return true ;
            }
        }

        dp[i][j] = false;


        return false; // else returnn false
    }

    
}

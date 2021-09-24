package Dynamic_Programming_level_01;

public class Q12_Count_Binary_Strings {

    public static void main(String[] args) {

        binaryString_of_len_n(6);
        
    }
    

    // method 01 :

    // took o(n) time and o(n) (actually o(2n) space) space.

    public static void binaryString_of_len_n(int n ) {   // without having any two consecutive zeros
        
        int dp0[] = new int[n+1] ;
        int[] dp1 = new int[n+1] ;

        // as 0 length binary string so starting from 1.
        dp0[1] = 1 ; // and 1 length of binary string which end at 0 without consecutive zeros is 1 that is "0"
        dp1[1] = 1 ; // and 1 length of binary string which end at 1 without consecutive zeros is 1 that is "1"

        for (int i = 2; i <= n ; i++) {
            dp0[i] = dp1[i-1] ; // now i length of binary string which end at 0 is equal to previous value of dp1.
            dp1[i] = dp0[i-1] + dp1[i-1] ; // and it is sum of both previous dp0 and dp1.
        }

        System.out.println(dp0[n] + dp1[n]);

    }


    // method 2 : using o(n) time and o(1) space .

    public static void binaryString_of_len_n2(int n) {

        int obczeros = 1 ;  // old binary cound zeros is 1 by default.
        int obcones = 1; // old binary cound of one is 1 by default.

        for (int i = 2; i <= n ; i++) {
            int nbczeros = obcones ;
            int nbcones = obcones + obczeros ;

            obcones = nbcones ;
            obczeros = nbczeros ;
        }

        System.out.println(obcones + obczeros);
        
    }
}

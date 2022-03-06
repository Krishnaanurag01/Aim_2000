package Dynamic_Programming_level_02;

import java.util.HashMap;

public class Q58_Arithmetic_Slices_2 {
    
    public static void main(String[] args) {
        
    }

    public static int get_total_arithmatic_subsec(int[] arr) {
        
        // In this hashMap array we will store the common difference of key (a[0]... - a[i]  ) and value as freq
        HashMap<Integer,Integer>[] map = new HashMap[arr.length] ; // making an hashmap array

        for (int i = 0; i < map.length; i++) {
            map[i] = new HashMap<>() ;    // now initializing each hashmap.
        }

        int ans = 0 ;

        // starting from 1 becuase we are making common difference map
        for (int i = 1 ; i < map.length; i++) { // now starting from 1st index to last
            for (int j = 0; j < i ; j++) { // and 0 to i
                
                long cd = (long)arr[i] - (long)arr[j] ; /// finding common difference.. converting to long as if we find differnece if  - infinity - (plus infinity) then it will givem 2*infinity

                if(cd <= Integer.MIN_VALUE || cd >= Integer.MAX_VALUE) {
                    continue ; // so if that occurs then skip it
                }

                // otheriwse check in j and i map that is it contains any key with cd value
                int valueEndAtJ = map[j].getOrDefault((int)cd,0);
                int valueEndAtI = map[i].getOrDefault((int)cd,0);

                ans += valueEndAtJ ; // for j map we add it to the answer (for exam : it has 1 sequence like : 2-5 so if add current value then it becomes something like : 2-5-x) so total sequence remains same but length of sequence increase and we just have to give count.

                map[i].put((int)cd, valueEndAtI + valueEndAtJ + 1 ) ;// and putting cd key with j value + i value(if it already has this key)+1(current value).
            }
        }

        return ans ;

    }


    // method - 02 ; tabulation method.  // not giving corrent output.

    // public static boolean is_interleaved_string(String s1 , String s2 , String s3) {
        
    //     if(s1.length() + s2.length() != s3.length()){
    //         return false ;
    //     }

    //     boolean[][] dp = new boolean[s1.length()+1][s2.length()+1] ;  


    //     for (int i = 0; i < dp.length; i++) {
    //         for (int j = 0; j < dp[0].length; j++) {
                
    //             if(i == 0 && j == 0){
    //                 dp[i][j] = true ;
    //             }
    //             else if( i == 0 ){
    //                 dp[i][j] = s2.charAt(j-1) == s3.charAt(i+j-1) ? dp[i][j-1] : false ;
    //             }
    //             else if( j == 0 ){
    //                 dp[i][j] = s1.charAt(i-1) == s3.charAt(i+j-1) ? dp[i-1][j] : false ;
    //             }
    //             else{

    //                 if(s1.charAt(i-1) == s3.charAt(i+j-1)){
    //                     dp[i][j] = dp[i-1][j] ;
    //                 }

    //                 if(dp[i][j] != true && s2.charAt(j-1) == s3.charAt(i+j-1)){
    //                     dp[i][j] = dp[i][j-1] ;
    //                 }

    //             }
    //         }
    //     }

    //     return dp[ dp.length-1][dp[0].length - 1] ;

    // }
}

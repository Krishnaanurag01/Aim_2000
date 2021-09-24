package Dynamic_Programming_level_01;

import java.util.Scanner;

public class Q15_Total_Decoding_Messages {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String str = sc.next() ;

       System.out.println( get_total_decoding_msg(str) ) ;
        
       sc.close();
    }
    

    public static int get_total_decoding_msg(String str) {


        if(str.length() == 1 && str.charAt(0) == '0'){  // when our string is like this "0" then return 0 . 
            return 0 ;
        }

       int[] dp = new int[str.length()] ; // making dp.
        
        dp[0] = str.charAt(0) == '0'? 0 : 1 ; // if our first char of str is 0 then store 0 elese 1.

        for (int i = 1; i < dp.length; i++) {
            char fc = str.charAt(i-1) ; // taking the previous char
            char sc = str.charAt(i) ; // and current char.

            if(fc == '0' && sc == '0'){ // if both 0 then store 0 .
                dp[i] = 0 ;
            }
            else if(fc != '0' && sc == '0'){ // if first char is 1-9 and second char is 0 then perform this,
                if(fc == '1' || fc == '2'){ // if first char is 1 or 2 then only perform this becuase for ex: fc is 4 and sc is 0 then 40 is not a character thats why not considering it.
                    dp[i] = i >= 2 ? dp[i-2] : 1 ; /// checking i is greater than 2 then we can comeback to i -2 otherwise store 1.
                }
                else{
                    dp[i] = 0 ; // 
                }
            }
            else if(fc == '0' && sc != '0'){ // when 04 like string exist. then simply save previous data.
                dp[i] = dp[i-1] ;
            }
            else{ // else.
                int num = Integer.parseInt(str.substring(i-1, i+1)) ; // finding the number .
                if(num <= 26){ // if number eg> 24 is less than 26 or equal then we add both i-2 total data and i-1 data becuase we can have both this character. (4 or 24)

                    dp[i] = (i >=2 ? dp[i-2] : 1 ) + dp[i-1] ; 
                }
                else{
                    dp[i] = dp[i-1] ; // else if number 45 then 45 is not a character so we only consider 5 thats why we are storing our data back.
                }

            }
        }


        return dp[str.length() -1] ;


    }
}

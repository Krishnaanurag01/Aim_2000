package LeetCode_Contests.Contest286;

public class Find_Palindrome_With_Fixed_Length {

    public long[] kthPalindrome(int[] queries, int intLength) {
        
        // we'll take length/2 -1 power of 10 if size is even else when odd just take half length power for 10.
        int pow = intLength % 2 == 0 ? ( intLength/2 - 1 ) : (intLength / 2) ;
        
        long[] result = new long[ queries.length ] ;
        
                    int power = (int)Math.pow(10,pow)  ; // finding power value

        for(int i = 0 ; i < queries.length ; i++){
            int q = queries[i] ;
            String ans = String.valueOf(power + q - 1) ; // now adding q+1 that is qth value.
            StringBuilder sb = new StringBuilder(ans) ;
           // System.out.println("sb = " + sb) ;

            String rev  = sb.reverse().toString() ;
            
            String num = "" ;
            if(intLength % 2 == 0 ){ // when we want length of evem then simply add both norml and reverse
                 num = ans + rev   ;
            }
            else{
                // System.out.println("odd => "+ans+" - " + rev) ;
                //else add normal + rev excluding the first 
                 num = ans +  rev.toString().substring( 1 , rev.length())  ;
            }
            
            // if our answer become greater then qth palin is not possible so store -1
            if(num.length() > intLength ){
                result[i] = -1;
            }
            else{ // else store our result
                result[i] = Long.parseLong(num) ;
            }
        }
        
        return result ;
    }
    
}

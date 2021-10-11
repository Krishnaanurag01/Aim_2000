package Dynamic_Programming_level_02;

public class Q62_Ugly_Numbers {

    public static void main(String[] args) {
        
    }

    public static long get_ugly_number(int n ) {
        
        long[] dp = new long[n+1];
        dp[1] = 1;  // 1 is already.

        int p2 = 1; // pointer of 2 , 3 , 5 all are at 1st index
        int p3 = 1;
        int p5 = 1 ;

        for (int i = 2 ; i <= n ; i++) { // now starting from 2
            
            long val2 = 2 * dp[p2] ;  // multiply 2 with  arr[2's pointer]
            long val3 = 3 * dp[p3] ;  // multiplying 3 with arr[3's pointer]
            long val5 = 5 * dp[p5] ; // multiplying 5 with arr[5's pointer]

            long min = Math.min(val2, Math.min(val3, val5)); // find min

            dp[i] = min ; // store in i

            // and then check which val is min and increase the pointer whoever gives the min value 
            if(min == val2){
                p2++;
            }
            else if(min == val3){
                p3++;
            }
            else{
                p5++;
            }
        }




        return dp[n] ;
    }
    
}

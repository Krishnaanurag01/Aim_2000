package Dynamic_Programming_level_02;

public class Q85_Maximum_subsequence_sum_such_that_no_three_are_consecutive {
    
    public static void main(String[] args) {
        int arr[] = { 100, 1000, 100, 1000, 1 };
        // int n = arr.length;

        System.out.println( get_max_subseq_sum_without_conse_three(arr));
    }

    public static int get_max_subseq_sum_without_conse_three(int[] arr) {
        
        int n = arr.length ;

        int[] dp = new int[n] ;

        if(n >= 1){ // when arrays length is greater or equal to 1 then store first element of arr
            dp[0] = arr[0] ;
        }

        if(n >= 2){ // when length if >= 2 then store previous + current element
            dp[1] = arr[0] + arr[1] ;
        }

        if( n > 2){ // when  greater than two size the, check either previous element is greater or 0th index + current index or previous index + current index. choose largest.
            dp[2] = Math.max(dp[1], Math.max(arr[0] + arr[2] , arr[1] + arr[2])) ;
        }

        for (int i = 3 ; i < dp.length; i++) { // now running a loop.
            /*
            dp[i-2] denotes that we didn't took dp[i-1] element and adding with arr[i].
            dp[i-1] denotes that we didn't choose current arr[i] element.
            dp[i-3] denotes we didn't took dp[i-2] element and adding with current arr[i] and arr[i-1].
            */
            dp[i] = Math.max(Math.max(dp[i-2] + arr[i], dp[i-1]),dp[i-3]+arr[i] + arr[i-1]) ;
        }

        return dp[n-1] ;
    }
}

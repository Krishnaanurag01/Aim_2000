package Dynamic_Programming_level_02;

public class Q47_Maximum_Sum_Subarray_with_at_least_Size_K {

    public static void main(String[] args) {

    }

    public static long get_max(long[] arr, long k) {
        long ans = Integer.MIN_VALUE; // this will store the answer.

        long[] maxsum = new long[arr.length]; // this will store the max sum subarray at each point using kadanes algo.
        long cmax = arr[0];
        maxsum[0] = arr[0];
// kadanes algo.
        for (int i = 1; i < maxsum.length; i++) {
            cmax += arr[i];

            if (cmax < arr[i]) {
                cmax = arr[i];
            }

            maxsum[i] = cmax;
        }

        // now finding the exact k sum values.
        long exact_value = 0 ;

        for (int i = 0; i < k ; i++) {
            exact_value += arr[i] ;
        }

        // updating with answer.
        if(exact_value > ans){
            ans = exact_value ;
        }

        // here wwe start from k to end.
        for (int i = (int)k ; i < arr.length; i++) {
            exact_value += arr[i] - arr[i-(int)k] ; // in this we are adding next value(arr[i]) and removing first value(arr[i-k]).

            // updating answer if exact_value is greater.
            if(exact_value > ans){
                ans = exact_value ;
            }

            // this  is the sum of from start to current index.
            // maxsum is previous index maxsum(kadanes) + current exact value
            long morethan = exact_value + maxsum[i-(int)k];

            // will update answer if larger.
            if(morethan > ans){
                ans = morethan;
            }
        }


        return ans ;
    }

}

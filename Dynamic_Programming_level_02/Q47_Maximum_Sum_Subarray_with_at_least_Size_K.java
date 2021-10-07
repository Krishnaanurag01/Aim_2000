package Dynamic_Programming_level_02;

public class Q47_Maximum_Sum_Subarray_with_at_least_Size_K {

    public static void main(String[] args) {

    }

    public static long get_max(long[] arr, long k) {
        long ans = arr[0];

        long[] maxsum = new long[arr.length];
        long cmax = arr[0];
        maxsum[0] = arr[0];

        for (int i = 1; i < maxsum.length; i++) {
            cmax += arr[i];

            if (cmax < arr[i]) {
                cmax = arr[i];
            }

            maxsum[i] = cmax;
        }

        long exact_value = 0 ;

        for (int i = 0; i < k ; i++) {
            exact_value += arr[i] ;
        }

        if(exact_value > ans){
            ans = exact_value ;
        }

        for (int i = (int)k ; i < arr.length; i++) {
            exact_value += arr[i] - arr[i-(int)k] ;

            if(exact_value > ans){
                ans = exact_value ;
            }

            long morethan = exact_value + maxsum[i-(int)k];

            if(morethan > ans){
                ans = morethan;
            }
        }


        return ans ;
    }

}

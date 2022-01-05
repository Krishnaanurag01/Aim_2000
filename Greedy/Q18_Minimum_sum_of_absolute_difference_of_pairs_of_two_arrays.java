package Greedy;

import java.util.Arrays;

public class Q18_Minimum_sum_of_absolute_difference_of_pairs_of_two_arrays {

    static long findMinSum(long a[], long b[], long n)
    {

        Arrays.sort(a);
        Arrays.sort(b);

        long ans = 0 ;

        for (int i = 0; i < a.length ; i++) {
            ans += Math.abs(a[i] - b[i]) ;
        }

        return ans ;

    }
    
}

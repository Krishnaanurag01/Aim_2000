package Problem_Of_The_day;

public class Q332_Absolute_difference_divisible_by_K {

    static long countPairs(int n, int[] arr, int k) {

        // Analysis :-
        // We Know,
        // (a-b)%mod => ((a%mod) - (b%mod) + mod)%mod;
        // Now we have to find completely divisible pair,it means :-
        // (a-b)%k = 0;
        // => ((a%k) - (b%k) + k) =0;
        // It only happen, when both (a%k) & (b%k) are equal to each other.
        // So, We Conclude that, 1st we have to take modulo of each elements with "k",
        // then we find it's frequency.

        long[] freq = new long[k];
        long ans = 0;

        for (int val : arr) {
            val %= k;
            ans += freq[val]; // taking all value with same reminder.
            freq[val]++;
        }

        return ans;
    }
}

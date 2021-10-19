package Dynamic_Programming_level_02;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Q63_Super_Ugly_Numbers {

    public static void main(String[] args) {

    }

    // method : 01

    // time complexcity : o(nk)

    public static int is_super_ugly_number(int n, int[] primes) {

        int[] pointer = new int[primes.length]; // making an pointer array that store the pointers(index) of each number
                                                // of prime.

        Arrays.fill(pointer, 1); // now filling 1 as index in pointer array.

        int[] dp = new int[n + 1];
        dp[1] = 1; // as 1 is first ugly number so stored at first index.

        for (int i = 2; i <= n; i++) {
            int min = Integer.MAX_VALUE; // find min
            for (int j = 0; j < primes.length; j++) {
                min = Math.min(min, primes[j] * dp[pointer[j]]); // multiplying the number with its dp[ index ] and
                                                                 // finding the min
            }
            dp[i] = min; // store it

            // now increasing the pointer whose value gives min.

            for (int j = 0; j < primes.length; j++) {
                if (primes[j] * dp[pointer[j]] == min) {
                    pointer[j]++;
                }
            }

        }

        return dp[n];

    }

    // method : 02

    // time complexcity : o( nlogk )

    /**
     * InnerQ63_Super_Ugly_Numbers
     */
    static class pair implements Comparable<pair> {
        int prime; // store the prime number
        int pointer; // store its pointer(index)
        int value; // store its value of arr[pointer]

        public pair(int prime, int pointer, int value) {
            this.prime = prime;
            this.pointer = pointer;
            this.value = value;
        }

        @Override
        public int compareTo(pair o) { // sort on the basis of value
            return this.value - o.value;
        }
    }

    public static int get_nth_super_ugly(int n, int[] primes) {

        int[] dp = new int[n + 1];

        PriorityQueue<pair> pq = new PriorityQueue<>();

        for (int i = 0; i < primes.length; i++) { // now adding pair of each prime element

            pq.add(new pair(primes[i], 1, primes[i]));
        }

        dp[1] = 1; // stored 1st ugly number that is 1 at 1st index.

        for (int i = 2 ; i < dp.length;) { // now starting from 2 to n

            pair rp = pq.remove(); // removed the pair from pq (it will remove the top most pair that has min value)

            if (dp[i - 1] != rp.value) { // now check if previous dp element is not same then only store value in dp[i]

                dp[i] = rp.value;
                i++; // and then increment i only when we have different element then previous dp value
            }

            pq.add(new pair(rp.prime, rp.pointer + 1, rp.prime * dp[rp.pointer + 1])); // now add new pair with pointer + 1 and        [ pointer + 1 ] index value.

        }

        return dp[n] ;// returning the nth value.

    }
}

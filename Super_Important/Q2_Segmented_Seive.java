package Super_Important;

import java.util.*;

public class Q2_Segmented_Seive {

    // ~~~~~~~~~~~~Input Management~~~~~~~~~~~
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int a = scn.nextInt();
        int b = scn.nextInt();
        segmentedSieveAlgo(a, b);
        scn.close();
    }


    static int n = (int) 1e6 + 1; // took the largest size for which we can create the seive array.
    static boolean seive[];

    // this is implementaion of Seive of eratosthenes
    static void generateSieve() { /// generating this help use in finding the primes from 2 to square root of
                                  /// R(right boundary)
        seive = new boolean[n];
        Arrays.fill(seive, true);

        for (int i = 2; i * i < seive.length; i++) {
            if (seive[i] == true) { // i is prime then the numbers where this i could be multiple can not be prime.
                for (int j = i + i; j < seive.length; j += i) {
                    seive[j] = false;
                }
            }
        }

    }

    // returning primes till N using seive array.
    static ArrayList<Integer> getPrimesTilln(int N) {
        ArrayList<Integer> primes = new ArrayList<>();

        for (int i = 2; i <= N; i++) {
            if (seive[i] == true)
                primes.add(i);
        }

        return primes;
    }



    public static void segmentedSieveAlgo(int L, int R) {

        // created seive so that we can get primes from 2 to sqrt of R.
        generateSieve();

        // now take the primes from 2 to sqrt of R from seive.
        ArrayList<Integer> primes = getPrimesTilln((int) Math.sqrt(R));

        // now after getting primes, Make the multiple of these primes which lies in range false.
        boolean[] ss = new boolean[R - L + 1]; // ss -> segmented seive.
        Arrays.fill(ss, true);

        // now selecting every prime and making the number in which this prime is multiple, false.
        for (int prime : primes) {

            int first_multiple = (L / prime) * prime; // getting the first value in the range which is multiple of current prime.
            if (first_multiple < L)
                first_multiple += prime; // if this first value is less than left range then add prime once.

                // we start with the max between the first multiple or prime * prime and go till R range
            for (int i = Math.max(first_multiple, prime * prime); i <= R ; i += prime) { 
                ss[i - L] = false; // making false as it is not prime.
            }
        }

        // now selecting the number in the range which is prime.
        for (int i = L; i <= R; i++) {
            if (ss[i - L] == true) {
                System.out.println(i);
            }
        }

    }

}

package Greedy;

import java.util.Arrays;

public class Q14_Maximize_sum_after_K_negations {

    public static void main(String[] args) {

        long[] a = { -9,-8,-7,-5 };

        maximizeSum(a, 4,2 );
    }

    public static long maximizeSum(long a[], int n, int k) {
        Arrays.sort(a);

        long sum = 0;
        int smallest = n - 1;

        for (int i = n - 1; i >= 0; i--) {

            if (Math.abs(a[i]) < a[smallest]) {
                smallest = i;
            }

            if (a[i] < 0 && k >= 1) {
                a[i] = -a[i];
                k--;
            }

        }

        while (k > 0) {
            a[smallest] = -a[smallest];
            k--;
        }

        for (int i = 0; i < a.length; i++) {
            sum += a[i];
        }

        System.out.println(sum);

        return sum;
    }
}

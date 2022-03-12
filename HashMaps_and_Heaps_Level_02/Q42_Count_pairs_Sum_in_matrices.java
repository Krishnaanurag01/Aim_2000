package HashMaps_and_Heaps_Level_02;

import java.util.*;

public class Q42_Count_pairs_Sum_in_matrices {

    /// method - 01
    // Time comp : O(n2) and space : O(n2)

    int countPairs(int mat1[][], int mat2[][], int n, int x) {

        // storing mat2 in set.
        HashSet<Integer> set = new HashSet<>();

        for (int[] m : mat2) {
            for (int mi : m) {
                set.add(mi);
            }
        }

        int count = 0;

        // accessing each element of m1 and checking if x-val present in mat2, if yes
        // then increase the count.
        for (int[] m1 : mat1) {
            for (int m : m1) {

                int rest = x - m;

                if (set.contains(rest)) {
                    count++;
                }

            }
        }

        return count;
    }

    // method 02 :
    // using two pointers approch
    // time comp : O(n2) and O(1)

    int countPairs2(int mat1[][], int mat2[][], int n, int x) {

        int tc = n * n;

        int s = 0; // starting cell
        int e = n * n - 1; // ending cell

        int count = 0;

        while (s < tc && e >= 0) {
            int val1 = mat1[s / n][s % n]; // starting cell value in mat1  
            int val2 = mat2[e / n][e % n]; // ending cell value in mat2

            if (val1 + val2 == x) { 
                count++;
                s++;
                e--;
            } else if (val1 + val2 < x) {
                s++;
            } else {
                e--;
            }

        }

        return count;
    }

}

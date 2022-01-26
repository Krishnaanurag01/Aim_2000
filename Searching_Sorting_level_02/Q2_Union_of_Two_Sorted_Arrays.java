package Searching_Sorting_level_02;

import java.util.*;

public class Q2_Union_of_Two_Sorted_Arrays {

    // method 01 : uses extra n space for hashset

    public static ArrayList<Integer> findUnion(int arr1[], int arr2[], int n, int m) {
        ArrayList<Integer> ans = new ArrayList<>();
        HashSet<Integer> set = new HashSet<>();

        

        int i = 0;
        int j = 0;

        while (i < n && j < m) {
            int val1 = arr1[i];
            int val2 = arr2[j];

            if (val1 < val2) {
                if (!set.contains(val1)) {
                    ans.add(val1);
                    set.add(val1);
                }

                i++;
            } else if (val1 > val2) {
                if (!set.contains(val2)) {
                    ans.add(val2);
                    set.add(val2);
                }
                j++;
            } else {
                if (!set.contains(val1)) {
                    ans.add(val1);
                    set.add(val1);
                }
                i++;
                j++;
            }
        }

        while (i < n) {
            int val1 = arr1[i++];
            if (!set.contains(val1)) {
                ans.add(val1);
                set.add(val1);
            }
        }

        while (j < m) {
            int val2 = arr2[j++];
            if (!set.contains(val2)) {
                ans.add(val2);
                set.add(val2);
            }
        }

        return ans;
    }

    // method 02 : here we don't use any extra space instead we check the last
    // inserted element of ans list if it same then skip else add to the list.

    public static ArrayList<Integer> findUnion2(int arr1[], int arr2[], int n, int m) {
        ArrayList<Integer> ans = new ArrayList<>();

        int i = 0;
        int j = 0;

        while (i < n && j < m) {
            int val1 = arr1[i];
            int val2 = arr2[j];
            int ansSize = ans.size();

            if (val1 < val2) {

                if (ansSize > 0 && ans.get(ansSize - 1) == val1) { // if last inserted val is same then skip it.
                    i++;
                    continue;
                }
                ans.add(val1);

                i++;
            } else if (val1 > val2) {

                if (ansSize > 0 && ans.get(ansSize - 1) == val2) {// if last inserted val is same then skip it.
                    j++;
                    continue;
                }

                ans.add(val2);

                j++;

            } else {

                if (ansSize > 0 && ans.get(ansSize - 1) == val1) {// if last inserted val is same then skip it.
                    i++;
                    j++;
                    continue;
                }

                ans.add(val1);

                i++;
                j++;
            }
        }

        while (i < n) {

            int val1 = arr1[i];
            int ansSize = ans.size();
            if (ansSize > 0 && ans.get(ansSize - 1) == val1) {// if last inserted val is same then skip it.
                i++;
                continue;
            }

            i++;
            ans.add(val1);

        }

        while (j < m) {

            int val2 = arr2[j];
            int ansSize = ans.size();
            if (ansSize > 0 && ans.get(ansSize - 1) == val2) {// if last inserted val is same then skip it.
                j++;
                continue;
            }

            j++;

            ans.add(val2);

        }

        return ans;
    }

}

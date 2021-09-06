package Arrays;

import java.util.Scanner;

// 1. You are given an array(arr) of integers and a pivot.

// 2. You have to re-arrange the given array in such a way that all elements smaller or equal to pivot lie on the left side of pivot and all elements greater than pivot lie on its right side.
// 3. You have to achieve this in linear time.

public class Partition_An_Array {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }

        int pivort = sc.nextInt();
        partitionIt(arr, pivort);

        for (int i : arr) {
            System.out.print(i+" ");
        }

        sc.close();
    }

    public static void partitionIt(int[] arr, int pivort) {

        int i = 0;
        int j = 0;

        while (i < arr.length) {
            if (arr[i] > pivort) {
                i++;
            } else {
                swap(arr, i, j);
                i++;
                j++;
            }
        }

    }

    private static void swap(int[] arr, int i, int j) {

        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}

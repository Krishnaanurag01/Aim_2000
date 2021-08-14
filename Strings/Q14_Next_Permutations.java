package Strings;

import java.util.ArrayList;

public class Q14_Next_Permutations {
    public static void main(String[] args) {
        int[] arr=  {1, 2, 3, 6, 5, 4};
        System.out.println(nextPermuList(arr, arr.length));
    }

    public static ArrayList<Integer> nextPermuList(int[] arr , int n) {

        ArrayList<Integer> list = new ArrayList<>();

        
        int i = n-2;

        // 

        while (i>= 0 && arr[i] >= arr[i+1]) {
            i--;
        }

        
        if(i>=0 ){
            int j = n-1 ;
            
            while (j >= 0 && arr[j] <= arr[i]) {
                j--;
            }

            swap(arr,j,i);
        }
        reverse(arr,i+1);

        for (Integer integer : arr) {
            list.add(integer);
        }

        return list;
        
    }

    public static void swap(int[] arr , int j , int i) {
        int temp  = arr[j];
        arr[j] = arr[i];
        arr[i] = temp;
    }

    public static void reverse(int[] a , int i) {
        int j = a.length-1;

        while(i < j ){
            int temp = a[j];
            a[j] = a[i];
            a[i] = temp;
            j--;
            i++;
        }
    }
}

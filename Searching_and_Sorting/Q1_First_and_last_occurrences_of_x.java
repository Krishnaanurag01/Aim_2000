package Searching_and_Sorting;



public class Q1_First_and_last_occurrences_of_x {
    public static void main(String[] args) {
        int[] arr = { 1, 3, 5, 5, 5, 5, 67, 123, 125 };

        System.out.println(getFirstOccurrence(arr, 5));
        System.out.println(getLastOccurrence(arr, 5));

    }
    public static int getFirstOccurrence(int[] arr, int x) {
        
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] == x){
                return i;
            }
        }

        return -1 ;
    }

    public static int getLastOccurrence(int[] arr , int x) {
        
        for (int i = arr.length-1 ; i >= 0 ; i--) {
            if(arr[i] == x) {
                return i ;
            }
        }
        return -1;
    }

    // get both in list.

}

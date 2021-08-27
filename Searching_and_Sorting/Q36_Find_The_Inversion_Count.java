package Searching_and_Sorting;

public class Q36_Find_The_Inversion_Count {

    public static void main(String[] args) {
        
    }

    public static long getTheInversionCount(long[] arr , long n) {

        long count =  0;

        while (n > 1) {

            count += getTheInversionCount(arr, n)
            
        }
        



        return  0 ;
    }
}

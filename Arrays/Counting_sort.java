package Arrays;

public class Counting_sort {

    public static void main(String[] args) {
        
    }

    public static void sort_with_count_sort(int[] arr,int min , int max) {
        
        /// making an frequency array that will store the frequency of elements.

        int[] farr = new int[max-min+1] ; // max - min is range that elements belongs from min to max including min max both so total length is max - min + 1 ;

        for (int i = 0; i < arr.length ; i++) { // storing frquency.
            int val = arr[i] ;
            farr[val - min]++ ; // suppose min is 3 and first element is 3 so 3-3 = 0 is the index where we increase the freq.
        }

        // now making pre sum array.

        for (int i = 1; i < farr.length; i++) {
            farr[i] = farr[i] + farr[i-1] ;
        }


        // now traversing the original array from last.
        int[] ans = new int[arr.length] ; // this will store the sorted values .

        for (int i = arr.length - 1 ; i >= 0; i--) {
            int val = arr[i] ;
            int pos = farr[val-min] ;
            int index = pos-1 ;

            ans[index] = val ;
            farr[val-min]-- ;
        }

        // now storing in the original array.

        for (int i = 0; i < ans.length; i++) {
            arr[i] = ans[i] ;
        }


    }
    
}

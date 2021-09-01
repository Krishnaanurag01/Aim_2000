package Searching_and_Sorting;



public class Q1_First_and_last_occurrences_of_x {
    public static void main(String[] args) {
        int[] arr = { 1, 3, 5, 5, 5, 5, 67, 123, 125 };

        // System.out.println(getFirstOccurrence(arr, 5));
        // System.out.println(getLastOccurrence(arr, 5));
      
        getFirstOccurrenceBinaryWay(arr, 5);
        getLastOccurrenceBinaryWay(arr, 5);

    } 

    // this is taking o(n) time which is not as a good as binary search.
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


    // using binary search.
    // takes only : o(log n) time

    public static void getFirstOccurrenceBinaryWay(int[] arr , int x ) {
        
        int low = 0 ;
        int high = arr.length-1;
        int ans = 0;

        while (low <= high) {
            int mid = (low + high)/2 ;
            if(arr[mid] < x){
                low = mid + 1;
            }
            else if(arr[mid] > x){
                high = mid - 1;
            }
            else{
                ans = mid;
                high = mid - 1 ;
            }

            
        }
        System.out.println(ans);
    }

    public static void getLastOccurrenceBinaryWay(int[] arr , int x ) {
        
        int low = 0 ;
        int high = arr.length-1;
        int ans = 0;

        while (low <= high) {
            int mid = (low + high)/2 ;
            if(arr[mid] < x){
                low = mid + 1;
            }
            else if(arr[mid] > x){
                high = mid - 1;
            }
            else{
                ans = mid;
                low = mid + 1;
            }

            
        }
        System.out.println(ans);
    }
}

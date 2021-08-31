package Arrays;

// Quickselect is a selection algorithm to find the k-th smallest element in an unordered list. It is related to the quick sort sorting algorithm.

public class Quick_Select_for_finding_the_kth_smallest_values {
    public static void main(String[] args) {

        int arr[] = { 10, 4, 5, 8, 11, 6, 26 };
        int n = arr.length;
        int k = 5;

       System.out.println(Quickselect(arr, 0 , n-1 , k-1)); // here k-1 denotes the index . means if we want find the  5th smallest number then that 5th number must ne placed on the 4th index.
        
    }   

    public static int Quickselect(int[] arr , int low , int high , int k) {
        
        int pivort = arr[high]; // taking the last index number as pivort.
        int pi = partitionIt(arr, pivort , low , high); // now cheking the giver pivort has the same index as k or not.

        if( k > pi ){
            return Quickselect(arr, low + 1, high, k); // if not then find in larger side.
        }
        else if (k < pi){
            return Quickselect(arr, low, high -1 , k); // else find in left side.
        }
        else{
            return arr[k];
        }
    }


    public static int partitionIt(int[] arr, int pivort , int low , int high) {

        int i = low ;
        int j = low ;

        while (i <= high) {
            if (arr[i] > pivort) {
                i++;
            } else {
                swap(arr, i, j);
                i++;
                j++;
            }
        }

        return j-1 ;
    }

    private static void swap(int[] arr, int i, int j) {

        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}

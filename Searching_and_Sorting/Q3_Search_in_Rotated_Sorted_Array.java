package Searching_and_Sorting;

public class Q3_Search_in_Rotated_Sorted_Array {
    public static void main(String[] args) {
        int[] arr = {4,5,6,7,0,1,2};
        System.out.println(searchInRotatedArray(arr, 3));
    }
    public static int searchInRotatedArray(int[] arr, int x) {
        
        int low = 0 ;
        int high = arr.length-1;

        while (low<=high) {
            int mid  = (low+high) / 2;

            if(arr[mid] == x){
                return mid; // index found.
            }// else if not found then checking which part of array is sorted. even after rotation one part of array is always sorted.
            else if(arr[low] <= arr[mid]){ // this will check if first half is sorted.
                // now if sorted then we'll check if the target value(x) belongs to the first half.
                if(arr[low] <= x && arr[mid] > x){
                    // if yes then we'll search in this part now. 
                    high = mid-1;
                }// o\w we start searching in the other half.
                else{
                    low=mid+1;
                }
            }
            else if(arr[mid] <= arr[high]) // this will check if other part of array is sorted or not.
            {
                // now if sorted then check if target x belongs in this.
                if( arr[mid] < x && arr[high] >= x){
                    low = mid + 1;
                }
                else{
                    // check in another part.
                    high = mid - 1;
                }
            }
        }








        return -1;
    }
}

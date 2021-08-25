package  Searching_and_Sorting;


// pivot element is : smallest element in the entire array.
public class Q21_Find_pivot_element_in_a_sorted_array {

    public static void main(String[] args) {
        int[]  arr = {4,5,6,7,0,1,2};
        int[] arr2 = {90,324,350,400, 9808, 10, 45 };

        System.out.println(getPivotElement(arr2));
        System.out.println(getPivortLargestNumber(arr2));

    }

    // time complexcity : o(log n) as we are applying binary search.
    public static int getPivotElement(int[] arr) {
        int low = 0 ;
        int high = arr.length-1;

        while (low < high) {            /// logic is super simple : when the mid element is smaller than high element then it means we 
            int mid = (low+high)/2 ;                                //have to search in left side .and vice versa.
            if(arr[mid] < arr[high]){
                high = mid;
            }
            else{
                low = mid+1 ;
            }
        }
     
        return arr[high];
    }

    // when we have to search pivort element such that pivot element is largest in array.

    public static int getPivortLargestNumber(int[] arr) {
        
        int low = 0;
        int high = arr.length-1;

        while (low < high) {
            int mid = (low+high) /2 ;

            if(arr[mid] > arr[low] ){                               // 4,5,6,7,0,1,2
                low = mid + 1 ;                                          // 10, 45, 90,324, 9808
            }
            else{
                high = mid  ;
            }
        }

        return arr[high];
    }
}
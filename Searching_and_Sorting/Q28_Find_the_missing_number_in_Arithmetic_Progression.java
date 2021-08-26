package Searching_and_Sorting;

public class Q28_Find_the_missing_number_in_Arithmetic_Progression {
    
    public static void main(String[] args) {
        int arr[] = {2, 4, 8, 10, 12, 14};
        int n = arr.length;

    System.out.println(getMissingNNumber(arr, n));
    }

    // Time Complexity: O(logN)

    public static int getMissingNNumber(int[] arr , int n) {

        int diff = (arr[n-1] - arr[0])/n;  // this will give the common difference between each element. 

        return findNumber(arr, 0 , n-1,diff);
        
    }

    private static int findNumber(int[] arr, int low, int high, int diff) {
   
        if( high <= low) {
            return Integer.MAX_VALUE ;
        }

        int mid  = low + (high-low)/2;

        // here checking if mid+1 element - mid element difference if not equals to common difference then element missing will be mid + diff.
        if(arr[mid+1] - arr[mid] != diff){
            return arr[mid] + diff;
        }

         // here checking if mid element - mid-1 element difference if not equals to common difference then element missing will be mid-1 element + diff.
        if( mid>0 && arr[mid] - arr[mid-1] != diff){
            return arr[mid-1] + diff; 
        }


        // this is a formula to find element. when calculated mid value is less then to original mid value then our missing element is lies in left side. and vice versa.
        if(arr[mid] == arr[0] + mid*diff){
            return findNumber(arr, mid+1, high, diff);
        }
   
   
   
      return findNumber(arr, low , mid-1, diff);
    }
}

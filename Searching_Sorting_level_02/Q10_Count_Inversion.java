package Searching_Sorting_level_02;

public class Q10_Count_Inversion {
    
    static long inversionCount(long arr[], long N)
    {
        long[] temp = new long[(int)N] ;
        return mergeSort(arr,temp, 0 , arr.length-1);
        
    }
    
    public static long mergeSort(long[] arr, long[] temp , int low , int high) {
        
        long inver = 0 ;
        if( low < high ){

        int mid = (high + low)/2 ;

        inver += mergeSort(arr,temp, low , mid);
        inver += mergeSort(arr, temp, mid+1, high);
        inver += mergeTwoSortedArrays(arr,temp,low,mid+1,high);
        }
    
        return inver ;
    }
    
    private static long mergeTwoSortedArrays(long[] arr, long[] temp , int left , int mid , int right) {

        long inv_count = 0 ;

        int i = left ;
        int j = mid ;
        int k = left ;

        while (( i <= mid-1) && (j <= right )) {

            if(arr[i] <= arr[j]){
                temp[k++] = arr[i++];
            }
            else{ // when right side is smaller then it means it has to swap with left.length - i elements(this is rest elements) of left array.
                
                temp[k++] = arr[j++];
                
                inv_count += (mid - i) ; 
            }
        }

        while (i <= mid-1) {
            temp[k++] = arr[i++];
        }

        while (j <= right) {
            temp[k++] = arr[j++];
        }
        
        for( i = left  ; i <= right ; i++){
            arr[i] = temp[i] ;
        }



        return inv_count;
    }
    
}

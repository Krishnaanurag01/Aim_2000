package Arrays;

public class Quick_Sort {
    
    public static void main(String[] args) {
        int[] arr = { 10, 7, 8, 9, 1, 5 };
        int n = arr.length;
        quick_sort_algo(arr, 0 , n-1 );

        for (int i : arr) {
            System.out.print(i+" ");
        }
    }

    public static void quick_sort_algo(int[] arr , int low , int high) {

        if( low >= high){
            return;
        }
        
        int pivort = arr[high] ;
        int pi = partitionIt(arr, pivort, low, high);

        quick_sort_algo(arr, low, pi - 1 );
        quick_sort_algo(arr,  pi + 1  , high);


    }

    public static int partitionIt(int[] arr , int pivort , int low , int high) {
        
        int i = low;
        int j = low ;

        while (i <= high) {
            if(arr[i] > pivort){
                i++;
            }
            else{
                swap(arr , i  , j);
                i++;
                j++;
            }
        }
         return j-1;
    }

    private static void swap(int[] arr, int i, int j) {

        int temp = arr[i];
        arr[i] = arr[j] ;
        arr[j] = temp ;
    }
}

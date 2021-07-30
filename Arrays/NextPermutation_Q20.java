package Arrays;

public class NextPermutation_Q20 {
    public static void main(String[] args) {
        int[] arr={1,2,3};
        getNextPermutation(arr);
        for (int i : arr) {
            System.out.print(i+" ");
        }
        
    }
    public static void getNextPermutation(int[] arr) {
    //    using i to get the first element of decresing order.
        int i = arr.length-2; 
        while (i>=0 && arr[i] >= arr[i+1] ) {
            i--;
        }

        // now we got the index where we have to change the value for next lexicographic order.

        if(i>= 0){
            int j = arr.length-1;
            while (j>=0 && arr[j] <= arr[i]) {
                j--;
            }
                // by decrementing j we get the first value which is greater than the arr[i]. after that we'll swap it with arr[i].
                swap(arr,i,j);                
            }
            reverse(arr,i+1);

        // now we swapped the next permutation value . now we'll arrange the i+1 to end index array in  decreasing order. we can simply use sort or reverse the values.

    
    }


    public static void swap(int[] arr, int i , int j ){
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }

    public static void reverse(int[] arr , int start) {
        int end = arr.length-1;
        while (start < end ) {
            swap(arr,start,end);            
        start++;
        end--;
        }
    }
}

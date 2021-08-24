package Searching_and_Sorting;

public class Q16_Product_array_puzzle {
    
    public static void main(String[] args) {
        int arr[] = { 10, 3, 5, 6, 2 };
        long[] result =  productExceptSelf(arr, arr.length);
        for (long l : result) {
            System.out.print(l+" ");
        }

        System.out.println();

        int[] result2 = productExceptSelfUsingOnlyOneArray(arr, arr.length);

        for (int i : result2) {
            System.out.print(i+" ");
        }



    }

    // time and space complexcity : o(n)
    public static long[] productExceptSelf(int nums[], int n) 
	{ 
        long[] longArr = new long[n];

        long[] rightArr = new long[n] ;

        long rightSum = 1 ;

        for (int i = nums.length-1 ; i >=0 ; i--) {
            rightSum*=nums[i];
            rightArr[i] = rightSum;
        }

        long leftSum = 1 ; 

        for (int i = 0; i < rightArr.length - 1  ; i++) {
            long leftIs = leftSum ;
            long rightIs = rightArr[i+1]; // we calculating product from 0 to end expect current index.
            
            longArr[i] = leftIs*rightIs;

            leftSum*=nums[i];
        }

        longArr[n-1] = leftSum;




        return longArr;
	} 


    // using only one array with same complexcity.
    public static int[] productExceptSelfUsingOnlyOneArray(int[] arr , int n) {

        //
        int[] productArray = new int[n] ; 

        int rightSum = 1;

        // first adding the right sum in answer array.
        for (int i = arr.length-1 ; i >= 0; i--) {
            rightSum *= arr[i];
            productArray[i] = rightSum;            
        }

        int leftSum = 1  ;

        // now finding left part and multiplying with right part.
        for (int i = 0; i < arr.length-1; i++) {
            productArray[i] = productArray[i+1]*leftSum ;

            leftSum *= arr[i];
        }

        // as we not added the last part in above loop because we user i+1 . so adding last part here.
        productArray[n-1] = leftSum ;

        return productArray;
    }
}

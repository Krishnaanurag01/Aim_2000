package Searching_and_Sorting;


// In this question we just have to give the index of X which we can simply do in linear time but there's a catch ! as we have already provided the adjacent difference (atmost k). so now example : {2,3,5,7,4} and we have to return index of 5 so we'll find the difference between arr[i] - x /2 this will gives that if we jump directly to calculated step then we might found the index of x.
public class Q9_Searching_in_an_array_where_adjacent_differ_by_at_most_k {
    public static void main(String[] args) {
        int arr[] = { 2, 4, 5, 7, 7, 6 };
        int x = 6;
        int k = 2;
        System.out.println(getIndex(arr, x, k));
        System.out.println(getIndex_optimizedApproch(arr, x, k));
    }

    // o(n) time.
    public static int getIndex(int[] arr , int x , int k) {
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] == x) {
                return i;
            }
        }

        return -1;
    }


    // o(n) but optimized one means less processing.
    public static int getIndex_optimizedApproch(int[] arr , int x , int k) {

        
        int i = 0 ;

        while ( i < arr.length) {
            if(arr[i] == x){
                return i ;
            }

            i = i + Math.max( 1 , (Math.abs(arr[i] - x))/ k ); // when next element adjcent is 1 then it might give 0 and we must move at least one step further thats why I took Math.max( 1 , ...)
        }
        
        return -1;
    }
}

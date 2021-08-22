package Searching_and_Sorting;

public class Q2_Value_equal_to_index_value {
    public static void main(String[] args) {
        int[] arr = {15, 2, 45, 12, 7};
        System.out.println(getIndexWhoseValueIsSameAsIndex(arr));
    }
    public static int getIndexWhoseValueIsSameAsIndex(int[] arr) {
       for (int i = 0; i < arr.length; i++) {
           if(arr[i] == i + 1){
               return arr[i] ;
           }
       } 



        return 0 ;
    }
}

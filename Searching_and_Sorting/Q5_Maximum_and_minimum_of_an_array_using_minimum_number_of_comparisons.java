package Searching_and_Sorting;


public class Q5_Maximum_and_minimum_of_an_array_using_minimum_number_of_comparisons {
    public static void main(String[] args) {
        int[] arr  = {2,3,4,1,5,9,3};
        getMaxMinUsingMinimumComparision(arr);
    }
    public static void getMaxMinUsingMinimumComparision(int[] arr) {
        
        int n = arr.length;
        int max = 0 , min = 0 ; 
        int i = 0 ;

        if( n %2 == 0){ // means  there must be minimum 2 elements in array.
            if(arr[1] > arr[0]){
                max = arr[1];                              /// total steps in odd : 3*(n-1)/2 // even = 1 + 3*(n-2)/2 ;
                min = arr[0];
            }
            else{
                max = arr[0] ; 
                min = arr[1] ;
            }
            i =2 ;
        }
        else{ // means there could be only one value in array.
            max = arr[0] ;
            min = arr[0] ;
             i= 1;
        }

        while( i < n-1){
            if(arr[i] > arr[i+1]){
                if(arr[i] > max){
                    max = arr[i];
                }
                else{
                    if(arr[i+1] < min){
                        min = arr[i+1];
                    }
                }
            }
            else{
                if(arr[i+1] > max) {
                    max = arr[i+1];
                }else if(arr[i] < min){
                    min = arr[i];
                }
            }
            i = i+2 ;
        }


        System.out.println("MAX : " + max);
        System.out.println("MIN : " + min);

    }
}

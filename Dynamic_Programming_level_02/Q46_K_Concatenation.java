package Dynamic_Programming_level_02 ;

/**
 * Q46_K_Concatenation
 */
public class Q46_K_Concatenation {

    public static void main(String[] args) {
        
        int[] arr = {1,-2,1} ;

        long sum = 0 ;

        for (int i = 0; i < arr.length; i++) {
            sum += arr[i] ;
        }

        get_max_sum(arr,sum,5) ;
    }

    // uses kadanes algo.

    public static long get_max_sum(int[] arr, long sum , int k) {
        
        if(k==1){ // when k is only 1 then perform kadane algo on one array
            return kadanes( arr) ;
        }
        else if(sum < 0 ){ // when sum of array is < 0 then perform kadanes of two array
            return kadanesforTwo(arr) ;
        }
        else{ // else when sum > 0 then perform kadanes of two array + (k-2)* sum ( as sum is positive so we are adding it k -2 times.)
            return kadanesforTwo(arr) + (k-2)*sum ;
        }

    }

    private static int kadanesforTwo(int[] arr) {

        int[] narr = new int[arr.length * 2] ;

        for (int i = 0; i < arr.length; i++) {
            narr[i] = arr[i] ;
        }

        for (int i = 0; i < narr.length; i++) {
            narr[i + arr.length] = arr[i] ;
        }


        return kadanes(narr);
    }

    private static int kadanes(int[] arr) {

        int csum = arr[0];
        int bsum = arr[0] ;

        for (int i = 1 ; i < arr.length; i++) {
            csum += arr[i] ;

            if(csum < arr[i]){
                csum = arr[i] ;
            }
            if(bsum < csum){
                bsum = csum ;
            }
        }

        return bsum;
    }
}
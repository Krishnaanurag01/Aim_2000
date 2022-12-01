package Problem_Of_The_day;

public class Q308_Rearrange_Array_Alternately {

    public static void rearrange(long arr[], int n){
        
        long max = arr[n-1] + 1 ; // taking a max element
        int max_idx = n - 1 ; // max value index
        int min_idx = 0 ; // min value index
        
        for(int i = 0 ; i < n ; i++){
            if(i % 2 == 0){ // max place
                arr[i] = arr[i] + ((arr[max_idx] % max) * max); // this is the formula
                max_idx-- ; // and moving t0 next max index
            }
            else{ // min place
                arr[i] = arr[i] + ((arr[min_idx] % max) * max); // using same formula for min
                min_idx++ ; // and moving to next min index
            }
        }
        
        // now dividing modifed values by max gives the desired answer.
        for(int i = 0 ; i < n ; i++){
            arr[i] /= max ;
        }
 
    }
}

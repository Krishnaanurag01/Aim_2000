package Searching_and_Sorting;

public class Q30_Smallest_factorial_number {
    
    public static void main(String[] args) {

        System.out.println(getSmallestNummberWith_N_Trailing_Zeros(6));
        
    }

    public static int getSmallestNummberWith_N_Trailing_Zeros(int n) {
        
        int low = 0 ; 

        // 5*n means : 5! give 1 zero , 10! gives 2 zero , 15! gives 3 zero, 20! gives 4 zero and 25! gives 6 zero because 25 contains two 5 ( 25 = 5 * 5). thats why took 5*n. and applying binary search.
        int high = 5*n ;

        while( low < high ){
            int mid = low + (high- low)/2 ;

            if(containsNzeros(mid , n)){
                high = mid ;
            }
            else{
                low = mid + 1;
            }
        }

        return low;
    }

    private static boolean containsNzeros(int mid, int n) {

        // here doing same thing which we done in q30
        int power = 5 ;
        int ans = 0 ;

        while(mid/power > 0 ){
            ans += mid/power ;
            power *= 5 ;
        }
        return ans >= n ;
    }
}

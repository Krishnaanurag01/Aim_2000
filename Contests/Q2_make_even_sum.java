package Contests;

public class Q2_make_even_sum {

    public static boolean makeEven(int N, int[] arr) {
        if(N % 2 != 0) return false;  // if odd elements then pairing is not possible.
        int sum = 0 ;
        for(int val : arr) sum += val ;
        
        return sum % 2 == 0 ;
    }
}

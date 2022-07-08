package Problem_Of_The_day;

public class Q81_Brackets_in_Matrix_Chain_Multiplication {

    // MCM with a little modification. here we will return both the value and then string in a pair class.
    
    static class Pair{
        int val ;
        String s ;
        Pair(String s, int x){
            this.val = x ;
            this.s = s ;
        }
    }
    
    static String matrixChainOrder(int arr[], int N) {
       Pair[][] dp = new Pair[N][N] ;
       return helper(1, N - 1, arr, dp).s ; // starting from the first matrix.
    }

    static Pair helper(int si, int ei, int[] arr, Pair[][] dp) {

        if (si == ei)
            return new Pair( "" + (char)(si-1+'A'),0 ) ; // beause we can't multiply a 1*0 dimention matrix. returning a pair.

        if (dp[si][ei] != null)
            return dp[si][ei]; // returning stored result

        int min = (int) 1e9;
        String ans = "" ;
        
        for (int k = si; k < ei; k++) { // partitoning the array .
            Pair partition1 = helper(si, k, arr, dp) ;
            Pair partition2 = helper(k+1, ei, arr, dp ) ;
            int x =  arr[si - 1] * arr[k] * arr[ei] + partition1.val + partition2.val;
            if(x < min){
                min = x ;
                ans = partition1.s + partition2.s ;
            }
        }
        return dp[si][ei] = new Pair( "(" + ans + ")", min ) ;
    }
}

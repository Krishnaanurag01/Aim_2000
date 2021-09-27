package Dynamic_Programming_level_02;

public class Q14_Longest_Bitonic_Subsequence {

    public static void main(String[] args) {
        
    }


    public static int Longest_bitonic_subSeq(int[] arr) {

        int n = arr.length ;

        // finding longest increasing subsequence. same as Q11.
        int[] lis = new int[n] ;

        for (int i = 0; i < lis.length; i++) {

            int max = 0 ;

            for (int j = 0; j < i ; j++) {
                if(arr[j] < arr[i]){
                    max = Math.max(max, lis[j]) ;
                }
            }

            lis[i] = max + 1 ;
        }

        // finding longest decreasing subsequence.

        int[] lds = new int[n] ;

        for (int i = n-1 ; i >= 0 ; i--) { // starting from end.

            int max = 0 ; // this will have the max value.

            for (int j = n-1 ; j > i ; j--) {  // now running loop from i+1 to end.
                if(arr[j] < arr[i]){ // checking if arr[j] has smaller value  then it means we can place element over that element.
                    max = Math.max(max, lds[j]) ; // updating max.
                }
            }

            lds[i] = max + 1 ; // store the longest decreasing subsequences.
        }


        int ans = 0 ;

        for (int i = 0; i < n ; i++) {
            if(lis[i] + lds[i] - 1 > ans){ // now adding lis[i] (have longest increasing subsequence ) + lds[i] (have longest decreasing subsequences )  - 1 ( doing this because both lis and lds have current element in common so removing 1 will no longer have common element.)
                ans = lis[i] + lds[i] - 1 ;
            }
        }

        return ans ;


    }
    
}

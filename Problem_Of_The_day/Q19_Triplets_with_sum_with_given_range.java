package Problem_Of_The_day;


public class Q19_Triplets_with_sum_with_given_range {

    static int countTriplets(int arr[], int N, int L, int R) {
        // code here

        int c1 = helper(arr, N , L- 1) ; // count all triplets less than equal to l-1 
        int c2 = helper(arr, N, R ) ; // counting all triplet less than equal to r , so here l - 1 part will also get counted as l -1 comes before r so we'll subtract for answer.

        return c2 - c1 ;
    }

    private static int helper(int[] arr, int n, int sum) {


        int count = 0 ;

        for (int i = 0; i < arr.length - 2 ; i++) {
            
            int j = i + 1 ;
            int b = arr.length - 1 ;

            while (j < b) {
                int Tempsum = arr[i] + arr[j] + arr[b] ;

                if(Tempsum > sum){
                    b-- ;
                }
                else{
                    count += (j - b) ; // this denotes if 1,2,3,4,5 here if 1 and 4 is the part of triplet then all inner element will also be part.
                    j++ ;
                }
            }
        }

        return count;
    }

   
    
}

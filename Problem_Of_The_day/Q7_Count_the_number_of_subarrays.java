package Problem_Of_The_day;

public class Q7_Count_the_number_of_subarrays {

    public static void main(String[] args) {

    }


    long countSubarray(int N,int A[],long L,long R) {
        // code here

        long total_subArr_less_than_r = find_count_of_sub(A,N,R);
        long total_subArr_less_than_l = find_count_of_sub(A,N,L-1);


        return total_subArr_less_than_r - total_subArr_less_than_l ;
    }


    private long find_count_of_sub(int[] a, int n, long x) {

        int start = 0 ;
        int end = 0 ;
        long count = 0 ;

        long sum = 0 ;

        while (end < n) {
            sum += a[end] ;

            while (start <= end && sum > x ) {
                sum -= a[start] ;
                start++ ;
            }

            count += (end - start + 1) ;
            end++ ;
        }
        return count ;
    }
}

package Searching_and_Sorting;

public class Q4_square_root_of_an_integer {
    public static void main(String[] args) {
        System.out.println(countOfNumbersWhoseSQRTisLessThanX(9));
        System.out.println(countOfNumWhoseSQRTisLessThan_X_UsingBinarySearch(9));

    }

    /// time complexcity :O(√ n).
    public static int countOfNumbersWhoseSQRTisLessThanX(int n) {

        int count = 0;
        for (int i = 1; i < n; i++) {
            if (i * i < n) {
                count++;
            }
        }
        return count;
    }
    // better approach using binary search.
    // time complexcity = o(log n )

    public static int countOfNumWhoseSQRTisLessThan_X_UsingBinarySearch(int x) {

        if (x == 0 || x == 1)
        return 0;

        long end = x , start = 1,ans  =  0 ;

        while (start <= end) {
            long mid = ( start + end )/ 2;
            if (mid * mid == x) {
                return (int)mid-1 ; //because we want values which have smaller square root than x ; // this means if 5*5 is == 25 ( x ) then all tha value less than 5 will also
                            // have sq root which is less than 25 so 5 elements is answer.
            } else if (mid * mid < x) {
                ans = mid; // this means current value of sq root is less than x means values less than
                           // including mid can have sq root which is less than limit(x) so add in answer.
                start = mid + 1; // and started searching further.
            } else {
                end = mid - 1; // otherwise we'll look for smaller values which have sq root less than limit x.
            }
        }
        return (int) ans ; 
    }
    }


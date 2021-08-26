package Searching_and_Sorting;

public class Q29_Trailing_Zeros {
    public static void main(String[] args) {
        
        System.out.println(getTrailingZeros(25));
    }

    // finding total trailing zeros.
 // check dsa copy for better understanding.
    public static int getTrailingZeros(int n) {
        
        int power = 5 ; // taking 5 initally .
        int ans = 0 ;

        while (n/power > 0) { // when dividing with 5 does not gives 0 or less then we continue dividing with increasing power by one power.

            ans += n/power;
            power *= 5;
            
        }

        return ans;
    }
}

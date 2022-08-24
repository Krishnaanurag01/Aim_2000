package Problem_Of_The_day;

public class Q181_Power_of_Three {
    
    public boolean isPowerOfThree(int n) {
        if( n == 0 ) return false ;
        // checking if n is multiple of 3.
        while(n % 3 == 0) n /= 3 ; // if yes then we are reducing the power of 3 for n by 1
        return n == 1 ; // in the end when n == 1 means 3^0
        
    }
}

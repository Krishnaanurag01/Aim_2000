package Problem_Of_The_day;

public class Q233_Maximum_number_of_2X2_squares {

    public static long numberOfSquares(long base)
    {
       if(base <= 2) return 0 ; // when base is <= 2 then it can't have square of 2*2
       
       // so subtract 2 from base
       long n = (base - 2)/2 ;
       long ans = n*(n+1)/2 ; // sum formula
       
       return ans ;
    }
}

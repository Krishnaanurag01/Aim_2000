package Dynamic_Programming;

import java.util.Scanner;

public class Q20_Painting_the_Fence {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in) ;

        int n = sc.nextInt() ; // total fence
        int k = sc.nextInt() ; // total colour

        get_total_ways_to_paint_fence(n,k) ;
        sc.close();
    }

    private static long get_total_ways_to_paint_fence(int n, int k) {

        if( n == 1){
            return k ;
        }
        

        int mod = 1000000007 ;  // given in question to use this.


        // storing it for n = 2 . as when n = 1 then we were returing k.
        long lastSame = (k * 1)%mod ; // here storing total ways such that last two colours are same. so at two only k.( eg. k =3 so at n =2 , total ways would be : rr , bb , gg)
        long lastDiff = (k * (k-1))%mod ; // here storing total ways such that last two colours are different. so at two total ways t colour fence would be ( eg k =3 , r with b and g , b with r and g ,g with r and b ) 6. k - 1 here means same colour ignoring so k-1 colour left.
        long total = (lastDiff + lastSame)%mod ; // calculating total.

        for (int i = 3 ; i <= n ; i++) { // now starting from 3 to n .
            lastSame = (lastDiff)%mod ; // last same would previous different so that we'll not have 3 colours as previous different has different colours so if add same colour then they becomes colours with last same.
            lastDiff = (total * (k-1))%mod ;     // same as for last diff we'll multiply total previous ways with k - 1 means ignoring same colour.
            total = (lastSame + lastDiff )%mod ; // again calculating total.
        }

      return (total)%mod ;


    }
    
}

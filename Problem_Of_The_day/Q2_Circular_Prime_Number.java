package Problem_Of_The_day;

public class Q2_Circular_Prime_Number {



    public static void main(String[] args) {
        
        isCircularPrime(197) ;
    }


    public static int isCircularPrime(int n)
    {
        
        
        if(n ==1 ) return 0 ; /// 1 is not prime so returning 0.
        
        String m = n+""+n ;

        // System.out.println(m);

        for (int i = 0; i < m.length() - String.valueOf(n).length() ; i++) {
            // finding each circular permuatation of number and check if any one permutation is not prime then return 0(false).
            int num = Integer.parseInt( m.substring(i, i+ String.valueOf(n).length()) ) ;
             if(check_prime(num) == false ) return 0 ;
        }

        return 1 ;
    }



    public static  boolean check_prime(int n){
        
        if( n == 1) return false ;
        
        if( n == 2 ){
            return true ;
        }
        
        if( n % 2 == 0){
            return false ;
        }
        
        for( int i = 3 ; i < n/2 ; i++){
            if(n % i == 0){
                return false ;
            }
        }
        //
        return true ;
        
    }
    
}

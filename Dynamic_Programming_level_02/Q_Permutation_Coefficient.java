package Dynamic_Programming_level_02;

public class Q_Permutation_Coefficient {

    public static void main(String[] args) {
        // get_permutation(6,3) ;
        get_permutation02(6,3) ;
    }



    // method : 01 take o(n) time and space.
    public static void get_permutation(int n , int k) {
        int[] fact = new int[n+1] ;
        fact[0] = 1 ;
        for (int i = 1; i < fact.length; i++) {
            fact[i] = i*fact[i-1] ;
        }

       System.out.println(fact[n]/fact[n-k]);
    }


    // method : 02 take o(n) time and o(1) space.
    public static void get_permutation02(int n , int k ) {
        int p = 1 ;

        for(int i = 0 ; i < k ; i++){
            p *=(n-i) ;
        }

        System.out.println(p);
    }
    
}

package Problem_Of_The_day;

public class Q292_Primes_sum {

    static String isSumOfTwo(int N){
        if(N <= 3) return "No" ;
       
       for(int i = 2 ; i <= N ; i++){
           if(isPrime(i) && isPrime(N - i)) 
           {
            //   System.out.println(i + " -- " + (N-i)) ;
               return "Yes" ;
           }
       }
       
       return "No";
    }
    
    static Boolean isPrime(int N){
        if(N <= 1) return false;
    
        for(int k = 2 ; k * k <= N ; k++){
            if(N % k == 0) return false ;
        }
        
        return true ;
    }
}

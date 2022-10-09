package Problem_Of_The_day;

public class Q246_Help_Ishaan {

    public int NthTerm(int N)
    {
        if(N == 1) return 1 ;

       // finding the lesser or equal prime number
       int lesser_prime = 0 ;
       int temp = N ;
       
       while(lesser_prime == 0){
           boolean prime = true ;
           
           for(int i = 2 ; i * i <= temp ; i++ ){
               if(temp % i == 0){
                   prime = false;
                   break ;
               }
           }
           
           if(prime == true){
               lesser_prime = temp ;
           }   
           temp-- ;
       }
       
       
       // finding greater or equal prime
       int larger_prime = 0 ;
       temp = N ;
       while(larger_prime == 0){
           boolean prime = true ;
           
           for(int i = 2 ; i * i <= temp ; i++ ){
               if(temp % i == 0){
                   prime = false;
                   break ;
               }
           }
           
           if(prime == true){
               larger_prime = temp ;
           }
           
           temp++ ;
       }
       
       // returning the min absolute diff.
      return Math.min(N - lesser_prime, larger_prime - N) ;
    }
}

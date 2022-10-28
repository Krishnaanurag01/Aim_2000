package Problem_Of_The_day;

public class Q269_Sequence_Fun {
    
    public int NthTerm(int n)
    { // pattern for this subsec is  -> next number is = prevNumber * (their pos + 1) + 1
        if(n ==  1) return 2 ;
        
        int mul = 2 ;
        long num = 2 ;

        for(int i = 2 ; i <= n ; i++){
            num = add(multiply(num , mul), + 1) ;
            mul++ ;
        }
        
        return (int)num ;
    }
    
    long M = (int)1e9+7 ;
    long mod(long val){
        return (val % M + M)%M ;
    }
    
    long multiply(long a, long b){
        return mod(mod(a)*mod(b)) ;
    }
    
    long add(long a, long b){
        return mod(mod(a) + mod(b)) ;
    }
}

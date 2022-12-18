package Problem_Of_The_day ;

public class Q316_A_Game_of_LCM {
    long solve(int N) {
        
        long ans = N * (N-1) ; // taking first two consecutive number in answer
        int count = 0 ;
        
        for(int i = N - 2 ; i >= 2 && count < 2; i--){ // now searching for other two
            if(gcd(ans,i) == 1){ // we pick i if it has no factor in common with answer.
                count++ ;
                ans *= i ;
            }
        }
        
        return ans ;
    }
    
    long maxGcd(int N) {
         return Math.max(solve(N),solve(N-1)); // try starting with N and N-1
    }
    
    long gcd(long m, long n){
        if(n == 0) return m;
        return gcd(n, m % n) ;
    }    
}

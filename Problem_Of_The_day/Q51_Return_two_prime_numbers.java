package Problem_Of_The_day;
import java.util.*;

public class Q51_Return_two_prime_numbers {

    public static void main(String[] args) {
        
        primeDivision(74) ;
    }
    
    static List<Integer> primeDivision(int N){
        // code here
        boolean isPrime[]=new boolean[N+1];
        Arrays.fill(isPrime,true);
        for(int i=2;i*i<=N;i++){
            if(isPrime[i]==true){
                for(int j=i*i;j<=N;j+=i){
                    isPrime[j]=false;
                }
            }
        }
        
        for(int i=2;i<=N/2;i++){
            if(isPrime[i]==true && isPrime[N-i]==true){
                List<Integer> res=new ArrayList<>();
                res.add(i);
                res.add(N-i);
                return res;
            }
        }
        return new ArrayList<>();
    }

}

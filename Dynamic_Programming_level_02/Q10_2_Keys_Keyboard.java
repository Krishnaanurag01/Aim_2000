package Dynamic_Programming_level_02;

public class Q10_2_Keys_Keyboard {

    public static void main(String[] args) {
        
    }

    public int minSteps(int n) {
        
        int ans = 0 ;
        
        for(int i = 2 ; i*i<= n;){
            if(n%i == 0){ // if number % i == 0 then add to the answer and divide the n with i.
                ans += i ;
                
                n /= i ;
            }
            else{
                i++ ;  // else increase the i
            }
        }
        

        // here checking if number is prime then add directly.
        if( n!=1){
            ans += n ;
        }
        
        return ans ;
        
    }
    
}

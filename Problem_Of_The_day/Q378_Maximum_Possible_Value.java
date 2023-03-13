package Problem_Of_The_day;

public class Q378_Maximum_Possible_Value {
    
    long maxPossibleValue(int N, int A[] ,int B[]) { 
       
        int min_stick = (int)1e9 ;
        long total_stick = 0 ;
        long sum = 0 ;
        
        for(int i = 0 ; i< N ; i++){
            if(B[i] % 2 == 1) B[i]-- ; // if odd then reduce 1 from it.
            if(B[i] >= 2) min_stick = Math.min(min_stick, A[i]) ; // taking smallest stick which has freq >= 2
            
            total_stick += B[i] ; // odd hone par humne 1 reduce kar he dia h toh ab always even quantity me aayega i.e 0,2,4,6
            sum += A[i] * B[i] ;
        }
        
        if(total_stick % 4 != 0) sum -= min_stick * 2 ; // matlab 2 extra bach rha toh min length wale stick ko hata do
        
        return sum ;
     }
}

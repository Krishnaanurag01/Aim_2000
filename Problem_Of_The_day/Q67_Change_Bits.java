package Problem_Of_The_day;

public class Q67_Change_Bits {

    static int[] changeBits(int N) {
       
        int nn = 0 ;
        int n = N ;
        
        while(n != 0 ){
            n = n >> 1 ;
            nn = nn << 1 ;
            nn = nn | 1 ;
        }
        
        return new int[]{ nn - N, nn } ;
     }
}

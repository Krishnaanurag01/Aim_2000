package Problem_Of_The_day;

public class Q237_The_Bit_Game {

    public static int swapBitGame(long N) {
       
        StringBuilder sb = new StringBuilder(Long.toBinaryString(N)) ;
        int turn = 1 ;  // 0 -> player 1 , 1 -> player 2
        
        for(int i = 0 ; i < sb.length() ; i++){
            if(sb.charAt(i) == '0') continue ;
            turn = turn == 1 ? 2 : 1 ;
        }
        
        return turn == 1 ? 2 : 1 ;
     }
}

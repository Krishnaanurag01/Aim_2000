package Problem_Of_The_day;
import java.util.*;

public class Q374_Cutting_Rectangles {
    
    static List<Long> minimumSquares(long L, long B)
    {
        ArrayList<Long> list = new ArrayList<>() ;
        Long K = gcd(L,B) ;
        list.add(L/K * B/K) ;
        list.add(K) ;
        return list ;
    }
    
    static long gcd(Long a, Long b){
        if(a == 0) return b ;
        return gcd(b%a, a) ;
    }
}

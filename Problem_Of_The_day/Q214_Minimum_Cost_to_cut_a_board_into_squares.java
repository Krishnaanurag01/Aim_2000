package Problem_Of_The_day;
import java.util.*;

public class Q214_Minimum_Cost_to_cut_a_board_into_squares {

    public static int minimumCostOfBreaking(int[] X, int[] Y,int M,int N) {
        // sorting so that we can perform cut for edge with larger cost.
        Arrays.sort(X) ;
        Arrays.sort(Y) ;
        
        int hz = 1 ; // horizontal peice initially.
        int vr = 1 ; // vertical peice initially.
        
        int i = X.length - 1 ; // pointer of X.
        int j = Y.length - 1 ; // pointer of Y.
        
        int total_cost = 0 ;
        // we have to cut greedly in order to obtain minimum cost. 
        // x means we have to cut vertically and vice versa.
        while(i >= 0 && j >= 0){
            if(X[i] >= Y[j]){
                total_cost += (X[i] * vr) ; 
                // now as we cut vertical so it divides horizontal piece in two.
                hz++ ;
                i-- ;
            }
            else{
                total_cost += (Y[j] * hz) ; 
                // now as we cut horizontal so it divides vertical piece in two.
                vr++ ;
                j-- ;
            }
        }
        
        while(i >= 0){
            total_cost += (X[i] * vr) ; 
            // now as we cut vertical so it divides horizontal piece in two.
            hz++ ;
            i-- ;
        }
        
        while(j >= 0){
            total_cost += (Y[j] * hz) ; 
            // now as we cut horizontal so it divides vertical piece in two.
            vr++ ;
            j-- ;
        }
        
        return total_cost ;
    }
}

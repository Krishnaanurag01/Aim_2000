package Problem_Of_The_day;
import java.util.*;;

public class Q274_Satisfy_the_equation {

    static int[] satisfyEqn(int[] A, int N) {
        
        int[] ans = {-1,-1,-1,-1} ;
        
        for(int i = 0 ; i < N ; i++){
            for(int j = 0 ; j < N; j++){
                
                if(i == j) continue; // i (A) && B(j) can't be same.
                int left = A[i] + A[j] ; // summing up the left side.
                
                HashMap<Integer,Integer> map = new HashMap<>() ; // now storing the values.
        
                for(int k = 0 ; k < N; k++){
                    if(k == i || k == j) continue; // make sure to not use A and B
                    int val = A[k] ;
                    map.putIfAbsent(val,k) ; // we are storing the val with earliest index only.
                }
                
                for(int k = 0 ; k < N; k++){
                    if(k == i || k == j) continue; // and C also can't be A and B
                    int val = A[k] ;
                    int rem = left - val ; // this is the remaining value we need.
                    if(map.containsKey(rem) && map.get(rem) != k){ // and It can't be C.
                        ans[0] = i ;
                        ans[1] = j ;
                        ans[2] = k ;
                        ans[3] = map.get(rem) ;
                        return ans ;
                    }
                }
                
            }
        }
        
        
        return ans;
    }
}

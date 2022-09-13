package Problem_Of_The_day;
import java.util.*;

public class Q226_Bag_of_Tokens {

    public int bagOfTokensScore(int[] tokens, int power) {
        
        // using two pointers.
        Arrays.sort(tokens) ;
        int left = 0 ;
        int right = tokens.length - 1 ;
        int score = 0 ;
        int ans = 0 ;
        
        while(left <= right){
            if(tokens[left] <= power){ // if we have enough power for left token then pick it.
                score++ ; // score increase.
                power -= tokens[left] ;
                left++;
            }
            else{ // else choose the largest unsued token .
                if(tokens[right] + power >= tokens[left] && score >= 1){ // we can chose if the condition follows.
                    score-- ;
                    power += tokens[right] ;
                    right-- ;
                }
                else break;
            }
            
            ans = Math.max(ans, score) ;
        }
        
        return ans ;
    }
}

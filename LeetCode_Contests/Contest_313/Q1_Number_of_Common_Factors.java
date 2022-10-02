package LeetCode_Contests.Contest_313;
import java.util.*;

public class Q1_Number_of_Common_Factors {

    public int commonFactors(int a, int b) {
        
        HashSet<Integer> factors_a = new HashSet<>() ;
        for(int i = 1; i <= a ; i++){
            if(a % i == 0) factors_a.add(i) ;
        }
        
        int count = 0 ;
        
        for(int i = 1 ; i <= b ;i++){
            if(b % i == 0 && factors_a.contains(i)) count++ ;
        }
        
        return count ;
    }
}

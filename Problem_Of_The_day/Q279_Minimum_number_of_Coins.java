package Problem_Of_The_day;
import java.util.*;

public class Q279_Minimum_number_of_Coins {

    static List<Integer> minPartition(int N)
    {  
        int[] arr = {1,2,5,10,20,50,100,200,500,2000} ;
        List<Integer> ans = new ArrayList<>() ;
        
        for(int i = arr.length - 1; i >= 0 ; i--){
            int val = arr[i] ;
            while(val <= N){
                N -= val ;
                ans.add(val) ;
            }
        }
        
        return ans ;
    }
}

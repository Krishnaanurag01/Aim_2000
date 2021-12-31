package Greedy;
import java.util.*;

public class Q10_Shop_in_Candy_Store {
    
    static ArrayList<Integer> candyStore(int candies[],int N,int K){
        // code here
        
        Arrays.sort(candies) ;
        
        int min = 0 ; // this will contain the min cost
        
        int i = 0 ;
        int j = N-1 ;
        
        while(i <= j){
            min += candies[i++] ; // bought one candie. so we got extra k candies free (as we want to pay min so we'll ask candies which are costly)
            j -= K ; // as array is sorted so costly candies start from last to start in array so reducing j index by k.
        }
        
        
        int max = 0 ;
        
        i = N-1 ;
        j = 0 ;

        // now we want max price
        
        while(i >= j){
            max += candies[i--] ; // buying costliest candies and
            
            j+= K; // reducing the min cost candies by taking it.
        }
        
        ArrayList<Integer> list = new ArrayList<>() ;
        
        list.add(min) ;
        list.add(max) ;
        
        
        return list ;
        
    }
}

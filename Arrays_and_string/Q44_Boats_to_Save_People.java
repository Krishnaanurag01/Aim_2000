package Arrays_and_string;
import java.util.*;

public class Q44_Boats_to_Save_People {

    public int numRescueBoats(int[] people, int limit) {
        
        Arrays.sort(people) ; 
        
        int ans = 0 ;
        
        int i = 0 ;
        int j = people.length-1 ;
        
        while(i <= j){
            
            // here we are adding min weight(people[i]) and max weight (people[j])
            int total = people[i] + people[j] ;
            
            if(total <= limit){ // if the total weight becomes less than or equals to limit then increase the count 
                ans++ ;
                i++ ; // and go to next i
                j-- ; // and next j
            }
            else{ // else if the total weight is greater then it means that the max weight(arr[j]) person can't be along with anyone so he need his personal boat.
                ans++ ; // so giving personal boat to jth person.
                j-- ; // moving to next person.
            }
        }
        
        
        return ans ;
        
    }
    
}

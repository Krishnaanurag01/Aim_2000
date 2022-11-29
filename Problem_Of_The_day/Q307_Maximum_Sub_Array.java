package Problem_Of_The_day;
import java.util.*;

/**
 * Q307_Maximum_Sub_Array
 */
public class Q307_Maximum_Sub_Array {

    ArrayList<Integer> findSubarray(int a[], int n) {
    
        ArrayList<Integer> ans_list = new ArrayList<>();
        int best= 0 ; // best sum
        int sum = 0 ; // curr sum
        int si = 0; // starting index of current sum
        int ei = 0 ; // ending index of current sum 
        int bsi = -1 ; // best starting index
        int bei = -1 ; // best ending index

        
        for(int i = 0 ; i < a.length ; i++){
            int val = a[i] ;
            sum += val ; // adding to sum
            ei = i ; // and extending the end index of current sum
            
            if(val < 0){ // if negative value comes then initialize sum, si and skip
                sum = 0 ; 
                si = i + 1 ;
                continue ;
            }
            
            if(sum < val){ // if sum get lesser then 
                sum = val ;
                si = i ;
            }
            
            
            if(best <= sum){ // now when found better sum then update the answer.
                best = sum ;
                bsi = si ;
                bei = ei ;
            }
        }
        
        // if not found any positive numbers of sub array then return -1 in list
        if(bsi == -1 || bsi >= n){
            ans_list.add(-1) ;
            return ans_list ;
        }
        
        // else return the best sum in list
       while(bsi <= bei ){
           int val = a[bsi++] ;
           ans_list.add(val) ;
       }
       
        
        return ans_list ;
    }
}
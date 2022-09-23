package LeetCode_Contests.Contest288 ;
import java.util.*;

public class Q1_Largest_Number_After_Digit_Swaps_by_Parity {

    public int largestInteger(int num) {
        
        StringBuilder sb = new StringBuilder() ;
        String nums = String.valueOf(num) ;
        PriorityQueue<Integer> odd = new PriorityQueue<>( (a,b) ->  b - a ) ; // will store all the even numbers
        PriorityQueue<Integer> even = new PriorityQueue<>( (a,b) ->  b - a ) ; // will store all the odd numbers

        // storing in q
        for(int i = String.valueOf(num).length()- 1 ; i >= 0 ; i-- ){
            int ld = num % 10 ;
            num = num/10 ;
            
            if(ld % 2 != 0) odd.add(ld) ;
            else even.add(ld) ;
        }

        // making the optimal or maximum number
       for(int i = 0 ; i< nums.length() ; i++){
           int val = nums.charAt(i) - '0' ;
            if(val % 2 == 0) sb.append(even.poll() + "") ;
            else sb.append(odd.poll() + "") ;
       }
             
        return  Integer.parseInt(sb.toString()) ;
    }
    
}
package Problem_Of_The_day;
import java.util.*;

public class Q301_Find_Longest_Awesome_Substring {

    // using hashmap
    public int longestAwesome(String s) {
        
        HashMap<Integer,Integer> map = new HashMap<>() ;
        map.put(0,-1) ; // storing 0 state so that when every digit is even then we look for state with all bits as 0 then it will help.
        
        int state = 0 ;
        int ans = 0 ;
        for(int i = 0 ; i < s.length() ; i++){
            int mask = (1  << (s.charAt(i) - '0')) ;
            
            state = state ^ mask ; // modifying the ch bit position in state
            
            // for even .
            if(map.containsKey(state)){ // when every bit of current state matches with previous state it means all the bit is even .
                ans = Math.max(ans, i - map.get(state)) ;
            }
            
            
            // now for odd. we will modify one bit of current state and check if same state occured before or not.
            for(int k = 0 ; k <= 9 ; k++){ // we will modify each digit position ad=nd convert even into odd and vide versa
                
                int temp = (1 << k) ;
                temp = state ^ temp ; // changing kth bit.
                if(map.containsKey(temp)){
                    ans = Math.max(ans, i - map.get(temp)) ;
                }
                
            }
            
            if(map.containsKey(state) == false){// if current state is previously not present then add it to the map otherwise we will get smaller ans if we override already defined state.
                map.put(state,i) ;
            }
        }
        
        
        return ans ;
    }


// using array 10 times faster with same approach

    public int longestAwesome2(String s) {
        
        Integer[] map = new Integer[ (1 << 10) ] ; // now instead of map using array
        map[0] = -1 ; // storing 0 state so that when every digit is even then we look for state with all bits as 0 then it will help.
        
        int state = 0 ;
        int ans = 0 ;
        for(int i = 0 ; i < s.length() ; i++){
            int mask = (1  << (s.charAt(i) - '0')) ;
            
            state = state ^ mask ; // modifying the ch bit position in state
            
            // for even .
            if(map[state] != null ){ // when every bit of current state matches with previous state it means all the bit is even .
                ans = Math.max(ans, i - map[state]) ;
            }
            
            
            // now for odd. we will modify one bit of current state and check if same state occured before or not.
            for(int k = 0 ; k <= 9 ; k++){ // we will modify each digit position ad=nd convert even into odd and vide versa
                
                int temp = (1 << k) ;
                temp = state ^ temp ; // changing kth bit.
                if(map[temp] != null){
                    ans = Math.max(ans, i - map[temp]) ;
                }
                
            }
            
            if(map[state] == null){// if current state is previously not present then add it to the map otherwise we will get smaller ans if we override already defined state.
                map[state] = i ;
            }
        }
        
        
        return ans ;
    }
}

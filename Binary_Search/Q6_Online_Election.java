package Binary_Search ;
import java.util.*;
public class Q6_Online_Election {
    

    class TopVotedCandidate {
        TreeSet<int[]> set ; // stores : 0th index - winner, 1st index - time.
        public TopVotedCandidate(int[] persons, int[] times) {
            
            set = new TreeSet<>( (a,b) -> a[1] - b[1] ) ; // sorting based on time.
            HashMap<Integer,Integer> map = new HashMap<>() ; // freq map.
            
            int maxFreq = 0 ;
            int winner = 0 ;
            
            for(int i = 0 ; i < persons.length ;i++){
                int person = persons[i] ;
                int time = times[i] ;
                
                map.put(person, map.getOrDefault(person,0)+1) ;
                if(map.get(person) >= maxFreq){
                    maxFreq = map.get(person);
                    winner = person ;
                }
                set.add(new int[]{winner,time});   
            }
        }
        
        public int q(int t) {
            int[] ceil = set.floor(new int[]{0,t}) ; // getting the winner at time t.
            return ceil != null? ceil[0] : -1 ;
        }
    }
}

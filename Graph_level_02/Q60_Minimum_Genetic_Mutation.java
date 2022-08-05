package Graph_level_02;
import java.util.*;

public class Q60_Minimum_Genetic_Mutation {

    public int minMutation(String start, String end, String[] bank) {
        
        if(start.equals(end)) return 0 ; // if start and end both same then 0
        
        // storing the bank gene in set so that we can find a specifc gene in constant time
        HashSet<String> setBank = new HashSet<>();
        for(String s : bank){
            setBank.add(s) ;
        }
        
        // running bfs
        LinkedList<String> q = new LinkedList<>() ;
        HashSet<String> set = new HashSet<>() ; // this is visited set.
        set.add(start) ;
        q.add(start) ;
        
        char[] choices = {'A','C','G','T'} ; // we can change char in these only as mentioned in question
        
        int step = 0 ;
        while(q.size() > 0){
            step++ ;
            int size = q.size() ;
            while(size-- > 0){
                String lg = q.removeFirst() ;
                if(lg.equals(end)) return step ; // if found return step
                
                
                for(int i = 0 ; i < lg.length() ; i++){ // now for each index of last removed gene try all the possiblities
                    StringBuilder sb = new StringBuilder(lg) ;
                    
                    for(char ch : choices){ 
                        sb.setCharAt(i,ch); // changing ith index with ch
                        String ng = sb.toString() ;
                        if(set.contains(ng)) continue ; // if already visited then continue
                        if(setBank.contains(ng) == false ) continue; // if not valid (as not in bank)
                        
                        q.add(ng); // adding to queue and visited set
                        set.add(ng) ;
                        
                        if(ng.equals(end)) return step ; // if it is target then return ans
                                              
                        }
                }
                
            }
        }
        
        return -1;
    }
}

package Graph_level_02 ;
import java.util.*;

public class Q61_Open_the_Lock {
    
    public int openLock(String[] deadends, String target) {
        
        if(target.equals("0000")) return  0 ;
        
        HashSet<String> deadendSet = new HashSet<>();
        for(String s : deadends){
            if(s.equals("0000")) return -1; // means when even the starting point is deadend then -1
            deadendSet.add(s) ;
        }
        
        // running bfs
        LinkedList<String> q = new LinkedList<>() ;
        HashSet<String> set = new HashSet<>() ; // this is visited set.
        set.add("0000") ;
        q.add("0000") ;
        
        
        int step = 0 ;
        while(q.size() > 0){
            step++ ;
            int size = q.size() ;
            // System.out.println(q) ;
            while(size-- > 0){
                String currCode = q.removeFirst() ;
                if(currCode.equals(target)) return step ; // if found return step
                
                
                for(int i = 0 ; i < currCode.length() ; i++){ // now for each index try all the possiblities
                    StringBuilder sb = new StringBuilder(currCode) ;
                    int cch = currCode.charAt(i) - '0' ;
                    
                    if(cch == 0){ // from 0 we can move to 9 to 1.
                        
                        sb.setCharAt(i,'9'); // changing ith index with ch
                        String ng = sb.toString() ;
                        if(ng.equals(target)) return step ;
                        addToQ(ng,q,set,deadendSet) ;
                        
                        sb.setCharAt(i,'1'); // changing ith index with ch
                        String ng2 = sb.toString() ;
                        if(ng2.equals(target)) return step ;
                        addToQ(ng2,q,set,deadendSet) ;
                        
                    }
                    else if(cch == 9){ // from 9 we can move to 8 or 0
                        
                        sb.setCharAt(i,'0'); // changing ith index with ch
                        String ng = sb.toString() ;
                        if(ng.equals(target)) return step ;
                        addToQ(ng,q,set,deadendSet) ;
                        
                        sb.setCharAt(i,'8'); // changing ith index with ch
                        String ng2 = sb.toString() ;
                        if(ng2.equals(target)) return step ;
                        addToQ(ng2,q,set,deadendSet) ;
                        
                    }
                    else{ // else we can go to +1 , -1 
                        
                        // System.out.println( currCode + " -- " + i + " -- " + cch);
                        
                        sb.setCharAt(i, (char)(cch  + 1 + '0') ); // changing ith index with ch
                        String ng = sb.toString() ;
                        if(ng.equals(target)) return step ;
                        addToQ(ng,q,set,deadendSet) ;
                        
                        sb.setCharAt(i, (char)(cch  - 1 + '0') ); // changing ith index with ch
                        String ng2 = sb.toString() ;
                        if(ng2.equals(target)) return step ;
                        addToQ(ng2,q,set,deadendSet) ;
                        
                    }
                }
            }
        }
        
        return -1;
        
    }
    
    void addToQ(String data, LinkedList<String> queue, HashSet<String> visited, HashSet<String> deadEnd){
        
        if(visited.contains(data)) return ; // if already visited then continue
        if(deadEnd.contains(data)) return ; // if not valid (as it is deadend)                
        queue.add(data); // adding to queue and visited set
        visited.add(data) ;
    }
}

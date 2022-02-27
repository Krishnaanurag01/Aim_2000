package Graph_level_02;
import java.util.*;

public class Q32_Reconstruct_Itinerary {

    // finding eulidean path
    
    HashMap<String, PriorityQueue<String>> map ; // for making graph
    LinkedList<String> ans ;
    public List<String> findItinerary(List<List<String>> tickets) {
        
        map = new HashMap<>() ;
        ans = new LinkedList<>() ;
        
        for(List<String> ticket : tickets ){ // making graph
            PriorityQueue<String> q = map.getOrDefault(ticket.get(0) , new PriorityQueue<>()  ) ;
            
            q.add(ticket.get(1)) ;
            map.put(ticket.get(0),q) ;
        }
        
        dfs("JFK") ; // now starting from "JFK" ( mentioned in question)
        
        return ans ;
    }
    
    void dfs(String s){
        PriorityQueue<String> q = map.get(s) ;

        // as we have asked for lexicographical order that's why used p queue
        while( q != null && q.size() > 0 ){
            String nbr = q.poll() ; // removing top most ticket
            dfs(nbr) ; // and moving to it's adjecent
        }
        
                        ans.addFirst(s) ; // adding in last

        
    }

}

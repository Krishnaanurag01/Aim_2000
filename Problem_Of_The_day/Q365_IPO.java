package Problem_Of_The_day ;
import java.util.* ;
public class Q365_IPO {

    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        
        // step 01: add all the project in projects ie. cost and profit in a node
        ArrayList<Node> projects = new ArrayList<>() ;
       
        for(int i = 0 ; i < profits.length ; i++){
            projects.add(new Node(capital[i], profits[i])) ;
        }
        
        int idx = 0 ;
        Collections.sort(projects, (a,b) -> a.cap - b.cap) ; // now sort on the basis of cost.

        PriorityQueue<Node> canBeUsed = new PriorityQueue<>((a,b) -> b.prof - a.prof) ; // this gives us the best project with max profit.
        
        while(k-- > 0){
            while(idx < projects.size()  && projects.get(idx).cap <= w){
                canBeUsed.add(projects.get(idx++)); // jisko bhi use kar saktey h usko nikal k dusre wale queuee me daal do
            }
            
            if(canBeUsed.size() == 0) return w; // agar koi bhi project avail nhi h toh return the w so far.
            // now take the max from canBeUsed
            w += canBeUsed.poll().prof ;
        }
        
        return w ;
    }
    
    class Node{
        int cap ;
        int prof ;
        
        Node(int x, int y){
            cap = x ;
            prof = y ;
        }
    }
    
}

package Problem_Of_The_day;
import java.util.*;;

/**
 * Q223_Maximum_Performance_of_a_Team
 */
public class Q223_Maximum_Performance_of_a_Team {

    public int maxPerformance(int n, int[] speed, int[] efficiency, int k) {
        
        // making object of engs.
        List<Engineers> list = new ArrayList<>() ;
        for(int i = 0; i < speed.length ; i++){
            list.add(new Engineers(speed[i], efficiency[i])) ;
        }
        
        // sort them according to their efficiency desc.
        Collections.sort(list, (a,b) -> b.efficiency - a.efficiency) ;
        
        // now making a heap of k engineers speeds. here sorting will be based on the speeds.
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        long total_speed = 0 ;
        long max_performance = 0 ;
        
        for(Engineers e : list){
            
            if(pq.size() == k){
        // remove the least speed engineer
                total_speed -= pq.poll() ;// and also reducing the total speed.
            }
            
        // and add current engineer speed.
            total_speed += e.speed ;
            pq.add(e.speed) ;
            // now the nnew efficiency is least efficiency * total speed ( as the list is sorted based on effi so in every iteration we will get the min effi.)
            long new_performance = total_speed * e.efficiency ;
            
            max_performance = Math.max(max_performance, new_performance) ;   
        }
        
        return (int)(max_performance % 1000000007) ;
    }
    
    
    private class Engineers{
        int speed ;
        int efficiency ;
        
        Engineers(int x, int y){
            this.speed = x ;
            this.efficiency = y ;
        }
    }
}
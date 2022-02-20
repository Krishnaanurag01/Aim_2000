package Problem_Of_The_day;
import java.util.*;

public class Q48_Maximum_number_of_events_that_can_be_attended {


    // brute force 

    static class Pair implements Comparable<Pair> {
        int sd ;
        int ed ;
        
        Pair(int x, int y){
            sd = x ;
            ed = y ;
        }
        
        public int compareTo(Pair o){
            
                return this.ed - o.ed ;
     
        }
    }
    
    static int maxEvents(int[] start, int[] end, int N) {
        // code here
        
        Pair[] arr = new Pair[N] ;
        int minStart = -1 ;
        int maxEnd = -1 ;
        
        for(int i = 0 ; i < N ; i++){
            arr[i] = new Pair(start[i], end[i]) ;
            minStart = Math.min(minStart,start[i]) ;
        }
        
        Arrays.sort(arr);
        
        maxEnd = arr[N-1].ed ;
        
        boolean[] visited = new boolean[maxEnd - minStart + 1] ;
        
        int count = 0 ;

        
        for(int i = 0 ; i < N ; i++){
            
            int starting = arr[i].sd - minStart;
            int ending = arr[i].ed - minStart ;
            
            for(int j = starting ; j <= ending ; j++){
                if(visited[j] == false){
                    visited[j] = true ;
                    count++ ;
                    break ;
                }
            }


        }
        
        return count ;
    }
    
}

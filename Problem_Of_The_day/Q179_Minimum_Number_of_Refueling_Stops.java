package Problem_Of_The_day ;
import java.util.*;

public class Q179_Minimum_Number_of_Refueling_Stops {

    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        if(target <= startFuel) return  0 ; // base condition
        PriorityQueue<Integer> pq = new PriorityQueue<>( (a,b) -> b - a ) ; // sort on max fuel
        
        long position = startFuel ; // matlab intially hum yha tak ja saktey
        int last = 0 ;
        int count = 0 ;
        
        // step 01 : add all the fuel whose location lies between the position(es position tak hum ja saktey)
        for(int i = 0 ; i < stations.length ; i++){
            if(stations[i][0] <= position){
                pq.add(stations[i][1]) ;
            }
            else{ // otherwise just break it
                break ;   
            }
            last = i ; // if we break then this will not be updated hence we will start with the current index in next loop
        }

            while(pq.size() > 0){
                int largest = pq.poll() ; // we will use the station with max fuel always
                position += largest ;
                count++ ;
                if(position >= target) return count ; // check if ab hum target reach kartey ya nhi
                
                // agar nhi phoch pa rhe abhi bhi to phir se sare station k fuel add kar do jo last positon se current positon k bich me ho
                for( int k = last + 1 ; k < stations.length ; k++){  // start with last index + 1 
                   if(stations[k][0] <= position){
                      pq.add(stations[k][1]) ;
                   }
                   else{
                      break ;
                   }
                    last = k ; // aur last ko bhi update kar do
                }   
            }
        
        
        return -1; // agar abhi bhi nhi phoch sake to return -1.
        
    }
}
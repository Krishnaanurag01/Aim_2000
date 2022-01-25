package Arrays_and_string;
import java.util.*;

public class Q68_Car_Pooling {


    public boolean carPooling(int[][] trips, int capacity) {
        
        Arrays.sort(trips, (a,b) -> Integer.compare(a[1] , b[1])) ; // sorting based on the starting point becuase we have to carry all passenger from initial to last end point.
        
        int currCap = trips[0][0] ; // took the passenger of first trip.
        
        if(currCap > capacity){ // if current capacity > capacity then false.
            return false ;
        }
        
        // this priority queue will help us in determining when to leave the passenger currently riding.
        PriorityQueue<int[]> destination = new PriorityQueue<>( (a,b) -> a[1] - b[1]  ) ;  // sorting on destination basis
        
        destination.add(new int[] {trips[0][0] , trips[0][2] }) ; // we'll store the passenger count and destination
        
        for(int i = 1 ; i < trips.length ; i++){ /// now traversing from 1 to last.
            
            int nextPss = trips[i][0] ; /// next passenger
            int source = trips[i][1] ; // source of next trip
            int desti = trips[i][2] ; // destination of next trip
            

            // if the priority queue is not empty and then top element destination is less than source of current trip then it means we leave the passenger before coming to current point.
            while(destination.size() != 0 && destination.peek()[1] <= source){
                currCap -= destination.poll()[0] ; // so removing passenger from currCapacity
            }
            
            // checking if current capacity + next capacity becomes larger then actual capacity then we can't give ride so returning false.
            if(currCap + nextPss > capacity){
                return false ;
            }
            

            // else adding passenger too current capacity
                currCap += nextPss ;
            // also adding thier count and destination in priority queue.
                destination.add( new int[]{nextPss,desti} ) ;
            
                
        }
        
        // System.out.print(currCap) ;
  
        return true ;
    }


    // method 02 : optimal one! (cumulative sum method) // same method as Q1

    public boolean carPooling2(int[][] trips, int capacity) {
        

        // step1 : find the last drop location of trip

        int lastDropLocation = 0 ;
        
        for(int[] trip : trips){
            lastDropLocation = Math.max( lastDropLocation , trip[2] ) ;
        }
        

        // step2 : make an array of last drop location + 1 length;
        int[] highway = new int[lastDropLocation + 1] ;
        

        // step 3 : now write +count(denotes passenger start it's ride) of passenger in starting point and -count(denotes passenger drop) in drop location.
        for(int[] trip : trips){
            highway[trip[1]] += trip[0] ;
            highway[trip[2]] -= trip[0] ;
        }
        
        for(int i = 1 ; i < highway.length ; i++){
            highway[i] += highway[i-1] ; // adding with previous count 
            if(highway[i] > capacity){ // if the capacity becomes greater than required capacity then return false.
                return false; 
            }
        }
        
        if(highway[0] > capacity) return false ; // also checking for first point.

        return true ;
    }
}

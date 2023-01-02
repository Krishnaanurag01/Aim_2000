package Problem_Of_The_day;
import java.util.*;

public class Q324_Find_minimum_number_of_Laptops_required {

    public int minLaptops(int N, int[] start, int[] end) {
       
        int low = 1 ; // min laptop required
        int high = N;  // max possible
        int ans = 0 ;
        
        // pairing up the start and end time of taks in a single array
        int[][] task = new int[N][2] ;
        for(int i = 0 ; i < N ; i++){
            task[i][0] = start[i];
            task[i][1] = end[i];
        }
        
        // and sort them in start time and when same start time is present then sort on end time
        Arrays.sort(task, (a,b) -> {
            if(a[0] != b[0]) return a[0] - b[0] ;
            return a[1] - b[1] ;
            }) ;
            
            // binary search
        
        while(low <= high){
            int mid = low + (high - low)/2 ;
            
            if(isPossible(task,mid)){ // check if it is possible to perform all task with mid amount of laptops
                ans = mid ;
                high = mid - 1;
            }
            else{
                low = mid + 1 ;
            }
        }
        
        return ans ;
     }
     
     boolean isPossible(int[][] tasks, int laptops){
         
         TreeMap<Integer,Integer> occupied = new TreeMap<>() ; // this stores the end time of realising laptop taken 
         
         for(int i = 0 ; i < tasks.length ; i++){
             int start = tasks[i][0] ;
             int end = tasks[i][1] ;
             
             Integer freed = occupied.floorKey(start) ;  // checking if any laptop completes its work before or at start time if any key present then we can use that laptop simply
             if(freed != null){
                 // toh phle wala use kar lo
                 int freq = occupied.get(freed) ; 
                 if(freq == 1){
                     occupied.remove(freed) ;
                 }
                 else{
                     occupied.put(freed, freq - 1) ;
                 }
                 
                 occupied.put(end, occupied.getOrDefault(end, 0) + 1) ; // ab phle wala laptop end par release hoga
             }
             else{ /// jab koi laptop free nhi h
                 if(laptops > 0){ // aur humare paas dusre naye laptops hai backup me toh unko use kar lo
                     laptops-- ;
                 occupied.put(end, occupied.getOrDefault(end, 0) + 1) ; ;
                 }
                 else{
                     return false;
                 }
             }
         }
         
         
         return true ;
     }
}

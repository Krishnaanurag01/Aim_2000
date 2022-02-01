package Searching_Sorting_level_02;
import java.util.*;

public class Q34_Heaters {
    

    class Pair{
        int js = -1 ; // just smaller denotes floor of a number
        int jl = -1 ;  // just larger denotes ceiling of a number
    }
    
    public int findRadius(int[] houses, int[] heaters) {
        
        Arrays.sort(heaters) ;
        
        int ans = 0 ;
        
        for(int i = 0 ; i < houses.length ; i++){
            
            Pair ceilAndFloor = binaryHelper(houses[i],heaters) ; /// finding the ceiling and floor heaters of hourse[i]
            
            // now checking the distance of both floor(d1) and distance of ceiling (d2)
            int d1 = ceilAndFloor.js == -1 ? Integer.MAX_VALUE : houses[i] - ceilAndFloor.js ; // calculating the distance from current house position.
            int d2 = ceilAndFloor.jl == -1 ? Integer.MAX_VALUE : ceilAndFloor.jl - houses[i] ; 
            

            int minD = Math.min(d1,d2) ; // finding the nearest heater position
            
            if(ans < minD){ // updating the anwer
                ans = minD ;
            }
        }
        
        return ans ;       
    }
    
    // hp -> house position
    // binary helper function for finding the ceiling and floor of a house position
    public Pair binaryHelper(int hp,int[] heaters) {
        
        int low = 0 ;
        int high = heaters.length - 1 ;
        
        Pair p = new Pair() ;
        
        while( low <= high ){
            int mid = (low+high)/2 ;
            
            if(heaters[mid] == hp){ // when there's present a value which equals to hp that denotes the heater is placed in our home 
                p.js = hp ; // so update both ceil and floor and end the binary search
                p.jl = hp ;
                break ;
            }
            else if(heaters[mid] < hp){ // this will update the floor
                p.js = heaters[mid] ;
                low = mid + 1; // going more near to hp(house position).
            }
            else{// when greater, will update the ceiling
                p.jl = heaters[mid] ;
                high = mid - 1 ;
            }
        }
        
        return p ;
        
    }
}

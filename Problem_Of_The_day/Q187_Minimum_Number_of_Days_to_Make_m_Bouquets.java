package Problem_Of_The_day;

public class Q187_Minimum_Number_of_Days_to_Make_m_Bouquets {

    public int minDays(int[] bloomDay, int m, int k) {
        
        int low = 1 ;
        int max = (int)-1e9 ;
        for(int val : bloomDay) max = Math.max(max, val) ;
        
        int high = max ;
        while(low <= high){
            int day = low + (high - low)/2; // taking day(mid) using binary search
            
            if(canWeMakeit(bloomDay,day,m,k)){ // check if we can make m bouquets with calculated day 
                high = day - 1; // then search for smaller day
            }
            else{
                low = day + 1; // o\w go higher
            }
        }
        
        return low > max ? -1 : low ;
    }
    
    boolean canWeMakeit(int[] bloomDay, int day, int m, int k){
        
        int bouquets = 0;
        int size = 0 ;
        for(int i = 0 ; i < bloomDay.length ; i++){
            if(bloomDay[i] > day){ // if current flower is not bloomed then make bouquet size 0 and skip
                size = 0 ;
                continue ;
            }
            
            size++ ; 
            if(size == k){ // if size becomes equal then increase the bucket count.
                size = 0 ;
                bouquets++;
            }
        }
 
        return bouquets >= m ; // checks whether this day is potential to make atleast m bouquets or not.
    }
}

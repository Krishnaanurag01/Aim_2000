package Searching_Sorting_level_02;

public class Q17_Koko_Eating_Bananas {

    public int minEatingSpeed(int[] piles, int h) {
        
        int max = Integer.MIN_VALUE ; // max banana in a pile
        
        for(int in : piles){
            max = Math.max(max,in) ; // finding the max banana in a pile
        }
        
        if(h == piles.length){ // when the hour given equals to piles.length denotes that each pile must be eaten in one hour so that total hour becomes piles.length == h
            return max ; // so returning the maximum banana in a pile that denotes the koko need to eat the pile at the max banana per hour
        }
        

        // applying the binary search

        int low = 0 ;
        int high = max ; // max banana in a pile that denotes the max eating speed(max banana per hour)
        
        int speed = 0 ; // answer
        
        while(low <= high){
            
            int sp = low + ( high - low ) /2 ; // got the speed which is sp banana per hour
            
            if(isPossible(piles,h,sp)){ // check if koko can eat all banana in calculated sp ( speed )
                speed = sp ; // updating the spped
                high = sp - 1 ; // checking for lower speed
            }
            else{
                low = sp + 1 ; // going for the larger speed
            }
            
        }

        return speed ;
    }
    
    
    public boolean isPossible(int[] piles,int h , int sp){
        
        int time = 0 ; // will contain the total hour by eating every pile in piles array
        
        for(int val : piles){
            time += (int)Math.ceil((double)val/sp) ; // division of pile with sp ( total banana per hour ) will give total hour in eating one pile completely
        }
        
        return time <= h ; // if total hour of eating every pile with sp banana per speed is less than h(given hour) then return true
    }
    
}

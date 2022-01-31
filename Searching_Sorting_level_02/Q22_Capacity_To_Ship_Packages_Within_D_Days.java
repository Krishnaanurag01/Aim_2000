package Searching_Sorting_level_02;

public class Q22_Capacity_To_Ship_Packages_Within_D_Days {
    
    public int shipWithinDays(int[] weights, int days) {
    
        int sum = 0 ;
        int max = 0 ;
        
        for(int w : weights)
        {
            max = Math.max(max,w) ;
            sum += w ;
        }
        
        if(days == 1) // when only one day is given then the total sum of weight is capacity of boat. 
            return sum ;
        
        if(days == weights.length) // if total days equals to total element in weight then return max.
            return max;
        
        int low = max ; // this is the min capacity
        int high = sum ; // this is the max capacity
        int ans = 0 ;
        
        while(low <= high){
            
            int mid  = low + ( high - low )/ 2 ; // finding a weight value
            
            int leastCap = isPossible(weights,days,mid); // checking if we can ship all the packages with mid weight capacity under given days.
            // if this return -1 then it means we can't deliever all the  packages within days with mid capacity .
            
            if(leastCap != -1){
                ans = leastCap ; // update answer
                high = mid - 1 ; // now doing this for lower capacity
            }
            else{
                low = mid + 1 ; // for larger capacity
            }
        }
        
        return ans;
        
    }
    
    public int isPossible(int[] weights, int days,int capacity){
    
        // same as book allocation question.
        
        int calDays = 1 ;
        int max = 0 ;
        int currCap = 0 ; // current capacity 
        
        for(int i = 0 ; i < weights.length ; i++ ){
            currCap += weights[i] ;
            
            if(currCap > capacity){
                calDays++ ;
                
                currCap = weights[i] ;
                max = Math.max(max,currCap) ; // for  maximum capacity
            }
            else{
            
                max = Math.max(max,currCap) ;
            }
        }
        
        return calDays > days ? -1 : max ;
    }
    
}

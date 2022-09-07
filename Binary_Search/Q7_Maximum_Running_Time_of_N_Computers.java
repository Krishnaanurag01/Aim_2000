package Binary_Search;

public class Q7_Maximum_Running_Time_of_N_Computers {

    public long maxRunTime(int n, int[] batteries) {
        
        long sum = 0 ;
        for(int val : batteries) sum += val ;
        long low = 0 ;
        long high = sum ; // when theres only one computer then we can use all the batteries that whhy taking sum in high.
        
        long ans = 0 ;
        while(low <= high){
            long avg_time = low + (high - low)/2 ; // considering mid as avg_time
            
            if(isRunningPossible(n, batteries, avg_time)){ // and check whether we can run all n computer till this time. if yes then this is our new Answer.
                ans = avg_time ;
                low = avg_time + 1 ; // try to find greater avg_time.
            }
            else{
                high = avg_time - 1;
            }
        }
        
        return ans ;
    }
    
    boolean isRunningPossible(int n, int[] batteries, long avg_time){
        
        long duration = 0 ;
        for(int val : batteries){
            if(val < avg_time) duration += val ; // if current battery is less than avgtime then it will run completely.
            else duration += avg_time ; // else it iwll run only till avg_time.
        }
        // check the totaltime by avg_time * n computers is less than equal to duration or not.
        // we cam also write it as -> duration/n >= avg_time/
        return duration >= avg_time * n ;
    }
}

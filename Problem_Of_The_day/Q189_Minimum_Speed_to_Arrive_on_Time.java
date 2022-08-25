package Problem_Of_The_day;

public class Q189_Minimum_Speed_to_Arrive_on_Time {
    
    // binary search  :
    public int minSpeedOnTime(int[] dist, double hour) {
        
        int low = 1 ;
        int high = (int)1e9 ;
        
        int ans = 0 ;
        while(low <= high){
            int speed = low + (high - low)/2 ;
            if(canWeReachOffice(dist,speed,hour)){
                ans = speed ;
                high = speed - 1 ;
            }
            else{
                low = speed + 1 ;
            }
        }
        
        return ans == 0 ? -1 : ans;
    }
    

    boolean canWeReachOffice(int[] distance, int speed, double hour){
        
        double currTime = 0 ;
        for(int i = 0 ; i < distance.length ; i++){
            if(i == distance.length - 1){ // only take last train time in decimal becuase after this train we don't have to take any train.
                currTime += (distance[i]*1.0/(1.0*speed));
            }
            else{
                currTime += Math.ceil(distance[i]*1.0/speed) ; // we have to take next train in next hour thats why taking ceil here.
            }
        }
        
        return currTime <= hour ;
    }
}

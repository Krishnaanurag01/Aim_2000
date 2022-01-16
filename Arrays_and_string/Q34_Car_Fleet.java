package Arrays_and_string ;
import java.util.Arrays;

public class Q34_Car_Fleet {

    public static void main(String[] args) {
        
    }
    
    public int carFleet(int target, int[] position, int[] speed) {
        
        int n = speed.length ; // total cars
        
        double[][] cars = new double[n][2] ; // making an array which will store position and the time for reaching destination.
        // the destination time is : target-current position divide by speed
        
        for(int i = 0 ; i < n ; i++){
            cars[i][0] = position[i]*1d ; // converting to double
            cars[i][1] = ((double) (target-position[i]))/(double)speed[i] ;
        }
        
        Arrays.sort(cars , (a,b) -> Double.compare(a[0], b[0])) ; // sorting based on the position


        int count = 1 ; // took 1 by default
        
       double lastCarSpeed = cars[n-1][1] ; // this is the time of the last car
        
        for(int i = n-2; i >= 0 ; i--){
            if(cars[i][1] > lastCarSpeed){ // if the current car time is greater than previous car time then increase the count and update the last car.
                count++ ;
                lastCarSpeed = cars[i][1] ;
            }
        }
        
        return count ;
    }

}

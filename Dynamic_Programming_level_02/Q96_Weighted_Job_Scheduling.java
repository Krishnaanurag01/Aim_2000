package Dynamic_Programming_level_02;

import java.util.Arrays;

public class Q96_Weighted_Job_Scheduling {
    
    public static void main(String[] args) {
        
        Job arr[] = new Job[4];
    arr[0] = new Job(3, 10, 20);
    arr[1] = new Job(1, 2, 50);
    arr[2] = new Job(6, 19, 100);
    arr[3] = new Job(2, 100, 200);

    // get_max_profit(arr);

    }

    static class Job implements Comparable<Job>{

        int startTime , endTime , profit ;

        Job(int startTime , int endTime , int profit){
            this.startTime = startTime ;
            this.endTime = endTime ;
            this.profit = profit ;
        }

        @Override
        public int compareTo(Job o) {
            return this.endTime - o.endTime ; 
        }
    }

    // public static void get_max_profit(Job[] arr) {
        
    //     Arrays.sort(arr);
    //     int ans = arr[0].profit ;

    //     int include = arr[0].profit ;
    //     int exclude = 0 ;
    //     for( int i = 1 ; i < arr.length ; i++){
    //         // if(arr[i-1].endTime <= arr[i].startTime){
    //         //     ans += arr[i].profit ;
    //         // }

    //         int nInclude ;
    //         int nExclude ;

    //         if(arr[i-1].endTime <= arr[i].startTime){
    //             nInclude = exclude + arr[i].profit ;
    //             nExclude = include ; 

    //             include = nInclude ;
    //             nExclude = exclude ;
    //         }

            
    //     }

    //     System.out.println( Math.max(include, exclude) );
    // }


    public static void Max_prfit(int[] startTime , int[] endTime , int[] profit) {
        
        int[][] jobs = new int[startTime.length][];

        for (int i = 0; i < jobs.length; i++) {
            jobs[i] = new int[]{startTime[i],endTime[i],profit[i]} ;
        }

        
    }
}

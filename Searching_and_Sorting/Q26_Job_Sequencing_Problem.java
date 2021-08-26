package Searching_and_Sorting;

import java.util.Arrays;


/**
 * Job
 
 */

public class Q26_Job_Sequencing_Problem {
    

    public static void main(String[] args) {

        Job[] arr = { new Job(1,4,3), new Job(2,6,5), new Job(4,7,2) ,new Job(6,8,6), new Job(5,9,4) , new Job(7,10,8)};

        int[] ans = MaxProfitJobSequence(arr, 4);

        for (int i : ans) {
            System.out.print(i+" ");
        }
        
    }

    // time complexcity : o( n log n) + o(n*m)
    // space complexcity : o(m)
    
    public static int[] MaxProfitJobSequence(Job arr[], int n) {

        // sorting jobs on the basis of profit in decending order.
        Arrays.sort(arr, (a,b) -> (b.profit - a.profit));

        int maxi = 0 ;

        // finding the maximum deadline of the arr.
      for (int i = 0; i < n ; i++) {
            maxi = Math.max(maxi, arr[i].deadline);
        }


        // initializing new result array to store the job init and making -1 value by default.

        int[] result = new int[maxi+1];

        for (int i = 0; i <= maxi ; i++) {
            result[i] = -1;
        }

        int jobCount = 0 ;
        int totalProfit = 0;

        // taking the jobs.
        for (int i = 0; i < n; i++) {
            
            // and storing where the deadlines points. if the day where deadlines points is already filled then finding previous days where we can aasign job.
            for (int j = arr[i].deadline ; j > 0 ; j--) {
                
                if( result[j] == -1 ){

                    // assgining jobs and adding profit to total profit and incrementing job counts.
                    result[j] = i ;
                    totalProfit += arr[i].profit;
                    jobCount++;
                    break;

                }
            }
        }
        // storing result in an array as we have to restur array.

        int[] ans = new int[2];
        ans[0] = jobCount;
        ans[1] = totalProfit;

        return ans;
    }

}
class Job {
    int id , profit , deadline ;

    Job(int id  , int deadline, int profit){

       this.id = id;
       this.deadline = deadline;
       this.profit = profit;
    }

}


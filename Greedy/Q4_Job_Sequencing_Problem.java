package Greedy ;

import java.util.Arrays;
import java.util.Comparator;

public class Q4_Job_Sequencing_Problem {

    class Job{
        int id ; 
        int deadline ;
        int profit ;

        Job(int x , int y , int z){
            this.id = x ;
            this.deadline = y ;
            this.profit = z ;
        }
    }

    class comparableJob implements Comparator<Job>{

        public int compare(Job x1 , Job x2){  // returning profit in descending order.
            return  x2.profit - x1.profit ;
        }
        
    }


    int[] JobScheduling(Job arr[], int n)
    {
        // Your code here

        Arrays.sort(arr , new comparableJob()); // sorting based on descending order of profit.

        int maxDeadline = 0 ;  // finding the max deadline. 
        for (int i = 0; i < arr.length; i++) {
            maxDeadline = Math.max(maxDeadline, arr[i].deadline) ;
        }

        int[] profitArr = new int[maxDeadline+1] ; // making max Deadline array.
        int jobCount = 0 ; // this will count all the jobs assigned.

        for (int i = 0; i < arr.length; i++) {
            int dl = arr[i].deadline ; // getting the deadline of current job.
            while (dl > 0 && profitArr[dl] != 0) { // finding the index(deadline) which is empty
                dl-- ;
            }

            if(dl > 0){ // if it is greater than 0 then it means we have found an empty place so we'll store profit there and also increase the job count.
                profitArr[dl] = arr[i].profit ;
                jobCount++ ;
            }
        }


        int ans =  0 ;

        for (int i = 0; i < profitArr.length; i++) {
            ans+= profitArr[i] ; // now calculating the profit. 
        }

        return new int[]{jobCount,ans} ;
    }
    
}

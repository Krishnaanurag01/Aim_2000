package Dynamic_Programming_level_02;

import java.util.Arrays;

public class Q97_Job_Sequencing_Problem {

    public static void main(String[] args) {
        Job[] arr = { new Job(1,4,3), new Job(2,6,5), new Job(4,7,2) ,new Job(6,8,6), new Job(5,9,4) , new Job(7,10,8)};
        get_max_profit(arr, arr.length);
    }

    static class Job{
        int id , profit , deadline ;
        Job(int id  , int deadline, int profit){

            this.id = id;
            this.deadline = deadline;
            this.profit = profit;
         }
    }

    public static  void get_max_profit(Job arr[] , int n) {

        Arrays.sort(arr, (a,b) -> (b.profit - a.profit)); // sorting such as the highest profit comes at first place.

       int maxDeadline = 0 ; // finding the  max deadline.

       for (int i = 0; i < arr.length; i++) { // finding the max deadline.
           maxDeadline = Math.max(maxDeadline, arr[i].deadline) ;
       }

       int[] result = new int[maxDeadline+1] ; // we made and deadline + 1 array , here we'll store index of jobs.

       int jobCount = 0 ;
       int totalProfit = 0 ;

       Arrays.fill(result,-1); // filling -1 by default.

       for (int i = 0; i < arr.length ; i++) {
           
        for (int j = arr[i].deadline ; j > 0 ; --j) { // check from deadline to 0+1, here skipping 0 becuase there's not possible a deadline with 0 time.
            
            if(result[j] == -1){ // if current index -1 then it means no jobs has assigned here.
                result[j] = i ; // so we change its value so that next time no one can find this.
                totalProfit += arr[i].profit ; // adding profit.
                jobCount++; // adding count.
                break ;
            }
        }
        
       }

       int[] ans = new int[2];
       ans[0] = jobCount;
       ans[1] = totalProfit;
        

       System.out.println( totalProfit +" "+jobCount);
    }
    
}

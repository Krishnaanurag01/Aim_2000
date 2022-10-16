package LeetCode_Contests.Contest_314;

public class Q1_The_Employee_That_Worked_on_the_Longest_Task {

    public int hardestWorker(int n, int[][] logs) {
        
        int ans = 0 ; 
        int largest_work = 0 ;
        int prevEndTime = 0 ;
        
        for(int i = 0 ; i < logs.length ; i++){
            int id = logs[i][0] ;
            int end_time = logs[i][1] ;
            
            if(end_time - prevEndTime > largest_work){
                largest_work = end_time - prevEndTime ;
                ans = id ;
            }
            else if(end_time - prevEndTime == largest_work){
                ans = Math.min(id,ans) ;
            }
            
            prevEndTime = end_time ;
        }
        
        return ans ;
    }
}

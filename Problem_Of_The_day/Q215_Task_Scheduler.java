package Problem_Of_The_day; 

public class Q215_Task_Scheduler {

    public int leastInterval(char[] tasks, int n) {
        if(n == 0 ) return tasks.length ; 
     
        // calculating freq of each task
        int[] freq = new int[26] ;
        for(char ch : tasks){
            freq[ch - 'A']++ ;
        }
        
        
        // now finding the task with max freq and also checking how many task are having same freq.
        int maxFreq = 0 ;
        int groupSize= 1 ; // count of task having maxFreq.
        
        for(int val : freq){
            if(val > maxFreq){
                maxFreq = val ;
                groupSize = 1 ;
            }
            else if(val == maxFreq){
                groupSize++ ;
            }
        }
        
        
        // returning max of size or ( n+1 )*maxFreq-1 [ this denotes that after each task we have to give n amount of idle time so next task will be at n+1 time and as we are counting for maxfreq -1 so first task did not get involved so adding that in groupSize.]
        return Math.max(tasks.length, (n+1)*(maxFreq- 1) + groupSize) ;
    }
}

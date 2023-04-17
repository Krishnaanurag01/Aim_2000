package Problem_Of_The_day;

public class Q393_Job_Sequencing_Problem {
    

    int[] JobScheduling(Job arr[], int n)
    {
        PriorityQueue<Job> pq = new PriorityQueue<>( (a,b) -> {
            if(a.profit == b.profit) return a.deadline - b.deadline ; // when profit is same then sort on deadline
            return b.profit - a.profit ;
             }) ;
            
        
        int maxDeadline = -1 ;
        for(Job a : arr){
            maxDeadline = Math.max(maxDeadline, a.deadline) ; // find the max deadline also
            pq.add(a) ;// and add job in priorityQueue
        }
        
        int[] jobAllocated = new int[maxDeadline+1] ;
        int[] ans = new int[2] ;
        
        while(pq.size() > 0 ){
            Job job = pq.poll() ;
            
            for(int i = job.deadline ; i >= 1 ; i--){
                if(jobAllocated[i] == 0){ // means ith time par khali h toh le lo
                    jobAllocated[i] = job.profit ;
                    ans[0]++ ;
                    ans[1] += job.profit ;
                    break ;
                }
            }
        }
        
        return ans ;
    }
}

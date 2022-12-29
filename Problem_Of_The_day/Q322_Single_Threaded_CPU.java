package Problem_Of_The_day;
import java.util.*;

public class Q322_Single_Threaded_CPU {

    public int[] getOrder(int[][] tasks) {
        
        Pair[] tsks = new Pair[tasks.length] ;
        
        for(int i = 0 ; i < tasks.length ; i++){
            tsks[i] = new Pair(tasks[i][0], tasks[i][1],i) ; // enque, processing, idx 
        }
     
        Arrays.sort(tsks, (a,b) -> {
            if(a.time != b.time){ // when enqueu time is different then sort it on this time
                return a.time - b.time ;
            }
            else if(a.pt != b.pt) { // sort on pt when they are different 
                return a.pt - b.pt ;
            }
            else{ // otherwise sort on index.
                return a.idx - b.idx ;
            }
            
        }) ;
            
        PriorityQueue<Pair> pq = new PriorityQueue<>( (a,b) ->{
            if(a.pt != b.pt){ // sorting on processing time
                return a.pt - b.pt ;
            }
            return a.idx - b.idx ; // when pt is same then sort on index.
        }) ;
            
        int[] ans = new int[tasks.length] ;
        int idx = 0 ;
        
        ans[idx++] = tsks[0].idx ; // storing the first task in ans
        int ansIdx = 1 ; // index of ans arrya
        
        int currTime = tsks[0].time + tsks[0].pt ; // as we took the first task so current time is the time at which first task comes + processing time.
        
        while(idx < tsks.length || pq.size() > 0){
            
            while(idx < tsks.length && tsks[idx].time <= currTime){// if current task enqueu time is less than or equal to current time then add it to pq.
                pq.add(tsks[idx++]) ;
            }
            // System.out.println(pq) ;
            
            if(pq.size() > 0){ // taking the task with shortest pt.
                Pair rp = pq.poll() ;
                ans[ansIdx++] = rp.idx ;
                currTime += rp.pt ; // and adding its processing time in current time
            }
            else{
                if(idx < tsks.length){ // if pq is empty then take current index task
                    ans[ansIdx++] = tsks[idx].idx ;
                    currTime = tsks[idx].time + tsks[idx++].pt ; // again this current index time + pt time will be curr time.
                }
            }
        }
        
        return ans ;
        
    }
    
    class Pair{
        int time;
        int pt;
        int idx ;
        
        Pair(int x, int y, int z){
            time = x ;
            pt = y ;
            idx = z ;
        }
        
        public String toString(){
            return time +" - " + pt + " - "+ idx ;
        }
    }

}
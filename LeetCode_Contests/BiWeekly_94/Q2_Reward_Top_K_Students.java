package LeetCode_Contests.BiWeekly_94;
import java.util.*;

public class Q2_Reward_Top_K_Students {
    
    public List<Integer> topStudents(String[] positive_feedback, String[] negative_feedback, String[] report, int[] student_id, int k) {
        
        HashSet<String> pf = new HashSet<>() ;
        HashSet<String> nf = new HashSet<>() ; 
        
        for(String p  : positive_feedback){
            pf.add(p) ;
        }
        
        for(String n  : negative_feedback){
            nf.add(n) ;
        }
        
        PriorityQueue<Pair> pq = new PriorityQueue<>() ;
        
        for(int i = 0 ; i < report.length ; i++){
            int id = student_id[i] ;
            int score = 0 ;
            
            for(String r : report[i].split(" ")){
                if(pf.contains(r)){
                    score += 3 ;
                }
                
                if(nf.contains(r)){
                    score -= 1 ;
                }
            }
            
            pq.add(new Pair(score, id)) ;
        }
        
        List<Integer> ans = new ArrayList<>() ;
        
        while(k-- > 0){
            ans.add(pq.poll().rank) ;
        }
        
        return ans ;
    }
    
    class Pair implements Comparable<Pair>{
        int score ;
        int rank ;
        
        Pair(int score, int rank){
            this.score = score;
            this.rank =  rank ;
        }
        
        public int compareTo(Pair o){
            if(this.score != o.score){
                return o.score - this.score ;
            }
            return this.rank - o.rank ;
        }
    }
}

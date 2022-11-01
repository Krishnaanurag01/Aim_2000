package LeetCode_Contests.Contest_317;
import java.util.*;

public class Q2_Most_Popular_Video_Creator {

    
    public List<List<String>> mostPopularCreator(String[] creators, String[] ids, int[] views) {
     
        List<List<String>> ans = new ArrayList<>() ;
        
        // map holds -> creator as key and their corresponding a pair.
        HashMap<String, Pair> map = new HashMap<>() ;
        long highest_pop = (int)-1e9 ; // the highest popularity present.
        
        for(int i = 0 ; i < views.length ; i++){
            String creator = creators[i] ;
            String id = ids[i] ;
            int view = views[i] ;
            
            Pair p = map.getOrDefault(creator, new Pair(0, id, 0)) ; // if not present then default pair is ( 0 - pop , id is currrent id , 0 views)
            
            p.pop += (view*1L) ; // adding views in pop.
            
            if(p.views < view){ // if previous view is less than current
                p.views = view ; // then assign higher view
                p.ids = id ;  // and id of higher view
            }
            else if(p.views == view){ // if prev and current view is same then choose the id which is smaller lexicographically
                ArrayList<String> list = new ArrayList<>() ;
                list.add(p.ids) ;
                list.add(id) ;
                Collections.sort(list) ;
                p.ids = list.get(0) ;
            }
            
            map.put(creator, p) ; // storing in map and also keep track of highest popularity
            highest_pop = Math.max(highest_pop, p.pop) ;
        }
        
        
        for(String key : map.keySet()){
            if(map.get(key).pop == highest_pop){ //if current creator has highest popularity then add to the answer.
                List<String> temp = new ArrayList<>() ; 
                temp.add(key) ;
                temp.add(map.get(key).ids) ;
                ans.add(temp) ;
            }
        }
        
        return ans ;
    }
    

    class Pair{
        String ids ; // this is the id of the most viewed creation
        long pop ; // total popularity -> total views of any creator
        int views ;  
        
        Pair(int x, String id, int y){
            this.pop = x ;
            this.ids = id ;
            this.views = y ;
        }
    }
}

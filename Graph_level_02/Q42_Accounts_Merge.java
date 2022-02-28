package Graph_level_02;
import java.util.*;

// DSU Approch : 

public class Q42_Accounts_Merge {

    static int[] parent ;
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        
        parent = new int[10005] ; // making this size big array becuase we don't know how big count of email comes.
        
        // initialization
        for(int i = 0 ; i < 10005 ; i++)
            parent[i] = i ;
        

        HashMap<String,Integer> etid = new HashMap<>() ; // this will store mapping of email with unique id
        HashMap<String,String> etn = new HashMap<>() ; // this ================================== name 
        
        int uid = 0 ;
        
        for(List<String> account : accounts){
            String name ="" ;
            
            for(String email : account){
                if(name == ""){
                    name = email ; // because the first string is name as mentioned
                    continue ;
                }
                
                if(! etid.containsKey(email)){ // if current email is not mapped with id then put it inside the map with a unique id.
                    etid.put(email,uid) ;
                    uid++ ;
                }
                
                if( ! etn.containsKey(email)){ // if current email is not mapped with name then add it tp map.
                    etn.put(email,name) ;
                }
                
                int e1id = etid.get(account.get(1)) ; // getting first email's id
                int e2id = etid.get(email);  // getting current email's id
                
                // doing union operation
                 union(e1id,e2id) ;
                
            }
        }
        
        // now mapping leaders with their emails.

        HashMap<Integer,List<String>> ansMap = new HashMap<>() ;
        
        for(String email : etid.keySet()){
            
            int id = etid.get(email) ; // getting id of email 
            int leader = find(id); // and finding the leader
            
            // adding current email with current leader
            List<String> a =  ansMap.getOrDefault(leader, new ArrayList<>())  ;
            a.add(email) ;
            ansMap.put(leader,a) ;
        }
        

        List<List<String>> finalAns = new ArrayList<>() ;
        
        for(List<String> ans : ansMap.values() ){
            
            List<String> in = new ArrayList<>() ;
          // getting the name
            String nameOfUser = etn.get(ans.get(0)) ;
            in.add( nameOfUser ) ;
            
            // sorting becuase it has been asked in question
            Collections.sort(ans) ;
            
            // now adding the sorted emails
            for(String a  : ans){
                in.add(a) ;
            }
            
            finalAns.add(in) ;
        }
        
        return finalAns ;
        
        
        
        
        
    }
    
    public void union(int id1 , int id2){
        int lx = find(id1) ;
        int ly = find(id2) ;
        
        if(lx != ly){
            parent[lx] = ly ;
        }
    }
    
    public int find(int x){
        if(parent[x] == x ){
            return x ;
        }
        
        return parent[x] = find(parent[x]) ;
    }
    
}

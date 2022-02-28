package Graph_level_02;
import java.util.*;

public class Q41_Minimize_Hamming_Distance_After_Swap_Operations {

    // using DSU Approch

    static int[] parent ;
    static int[] rank ;

    public int minimumHammingDistance(int[] source, int[] target, int[][] allowedSwaps) {
        
        int n = source.length ;
        
        parent = new int[n] ;
        rank = new int[n] ;
        
        for(int i = 0 ; i < n ; i++){
            parent[i] = i ;
            rank[i] = 1 ;
        }
        
        // doing merging
        for(int[] s : allowedSwaps){
            int u = s[0] ;
            int v = s[1] ;
            
            union(u,v) ;
        }
        
        // dsu intialization ends
        
        
        // in this map we will store leader with a hashmap that contains all the value whoose index(in source array) leader is current leader
        HashMap<Integer,HashMap<Integer,Integer>> map = new HashMap<>() ;
        
        
        for(int i = 0 ; i < n ; i++){

            int leader = find(i,parent) ; // fiding leader of current index
            
            HashMap<Integer,Integer> inFreq = map.getOrDefault(leader, new HashMap<>()) ; // assigning a new hashmap if not defined before
            
            // adding current value in it with it's freqency
            int currentVal = source[i] ;
        
                inFreq.put( currentVal , inFreq.getOrDefault(currentVal, 0 ) + 1) ;
        
                // assigning back to leader in map
            map.put(leader,inFreq) ;
            
        }
        
        // count of hamming distance
        int hd = 0 ;
        
        for(int i = 0 ; i < n ; i++){
            int root = find(i,parent) ;  // getting leader of current index
            
            int val = target[i] ; // and also getting the current value
            
            // getting the frequency map of current index leader
            HashMap<Integer,Integer> cLeader = map.get(root) ;
            
            if(cLeader.containsKey(val) == false){// if this map does not contain current value then increase the count and skip
                hd++ ;
                continue ;
            }
            
            
            // else if current val is present but frequency is not available then also increrase the count
            if(cLeader.get(val) <= 0)
            {
                 hd++ ;
            }   
            else{ // else if extra instance is available then used one instance so decrementing the instance by one
                cLeader.put(val, cLeader.get(val) - 1) ;
            }
        }
        
        
        
        return hd ;
       
    }
    
    
     
     // DSU OPERAATIONS:
    
     public boolean union(int x , int y ){
        
        int lx = find(x,parent) ;
        int ly = find(y,parent) ;
        
        if(lx != ly ){
            
            if(rank[lx] < rank[ly]){
                parent[lx] = ly ;
            }
            else if(rank[ly] < rank[lx]){
              parent[ly] = lx ;
            }
            else{
               parent[lx] = ly ;
                rank[ly]++ ;
            }
            
            return true ;
        }
        else{
             return false;
        }
        
    }
    
    
    
    public int find(int x , int[] parent){
        if(parent[x] == x){
            return x ;
        }
        
        parent[x] = find(parent[x] , parent );
        return parent[x] ; 
    }
    
}

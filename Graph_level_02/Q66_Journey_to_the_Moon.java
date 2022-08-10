package Graph_level_02;
import java.util.*;

public class Q66_Journey_to_the_Moon {

    // Application of DSU : 

    public static long journeyToMoon(int n, List<List<Integer>> astronaut) {

        // initialization of dsu 
        int[] parent = new int[n] ;
        int[] rank = new int[n] ;
        
        for(int i = 0 ; i < n ; i++){
            parent[i] = i ;
            rank[i] = 1 ;
        }
        

        // merging the same country
        for(List<Integer> a : astronaut){
            int u = a.get(0) ;
            int v = a.get(1) ;
            
            union(u,v,parent,rank) ;
        }
        
        HashMap<Integer,Integer> map = new HashMap<>() ;

        // now storing each distinct country with their frequency
        for(int i = 0 ; i < n ; i++ ){
            int p = find(i,parent) ;
            map.put(p,map.getOrDefault(p,0)+1) ;
        }
        
        // this function is multiplying each country size with other countries
        // In brute way calculating like this : i to n { j = i+1 to n{ total += i*j} }
        int sum = 0;
        long result = 0;
        for(int size : map.values())
        {
            result += sum*size;
            sum += size;    
        }   
        
        return result;
    }

    // DSU Operations :
    static boolean union(int x, int y, int[] parent, int[] rank){
        int px = find(x,parent) ;
        int py = find(y,parent) ;
        
        if(px != py){
            if(rank[px] < rank[py]){
                parent[px] = py ;
            }
            else if(rank[py] < rank[px]){
                parent[py] = px ;
            }
            else{
                parent[px] = py ;
                rank[py]++ ;
            }
            return true;
        }
        else{
            return false;
        }
    }
     
    static int find(int x , int[] parent){
        if(parent[x] == x){
            return x ;
        }
        
        parent[x] = find(parent[x] , parent );
        return parent[x] ; 
    }
}

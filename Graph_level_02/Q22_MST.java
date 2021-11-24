package Graph_level_02;
import java.util.*;


public class Q22_MST {

    static class Pair implements Comparable<Pair>{

        int u ;
        int v; 
        int wt; 

        Pair(int u , int v , int  wt){
            this.u = u ;
            this.v = v ;
            this.wt = wt ;
        }

        @Override
        public int compareTo(Pair o) {
            // TODO Auto-generated method stub
            return this.wt - o.wt;
        }
        
    }

    static int spanningTree(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj) 
    {
        
        
        int[] parent = new int[V];
        int[] rank = new int[V];

        for (int i = 0; i < rank.length; i++) {
            parent[i] = i ;
            rank[i] = 0;
        }


        Pair[] pair_Arr = new Pair[adj.size()] ;

        Arrays.sort(pair_Arr);

        for (int i = 0; i < adj.size() ; i++) {
            
            for (ArrayList<Integer> a : adj.get(i)) {

                pair_Arr[i] = new Pair(i, a.get(0), a.get(1)) ;
                
            }
        }


        int ans = 0 ;


        for (int i = 0; i < pair_Arr.length; i++) {
            
            boolean isIncluded = union(parent, rank, pair_Arr[i].u, pair_Arr[i].v) ;

            if(isIncluded){
                ans += pair_Arr[i].wt ;
            }
        }


        return ans;
    }


    public static boolean union(int[] parent , int[] rank ,  int x , int y) {
        
        int lx = find(parent, x) ;
        int ly = find(parent, y) ;

        if(lx != ly){
            if(rank[lx] < rank[ly]){
                parent[lx] = ly ;
            }
            else if(rank[lx] > rank[ly]){
                parent[ly] = lx ;
            }
            else{
                parent[lx] = ly ;
                rank[lx]++;
            }
            return true ;
        }
        else{
            return false ;
        }
    }




    public static int find(int[] parent ,int x){

        if(parent[x] == x ){
            return x  ;
        }

        int temp = find(parent, parent[x]);
        parent[x] = temp ;

        return temp;

    }
    
}

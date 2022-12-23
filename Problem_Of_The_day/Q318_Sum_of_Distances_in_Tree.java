package Problem_Of_The_day;
import java.util.*;

public class Q318_Sum_of_Distances_in_Tree {

    ArrayList<ArrayList<Integer>> adj ;
    int[] count ; // count of nodes connected to current including current
    int[] res ; // result : total sum distance
    public int[] sumOfDistancesInTree(int n, int[][] edges) {
        
        // initialization
        adj = new ArrayList<>();
        count = new int[n] ;
        res = new int[n] ;
        
        // making adjency list
        for(int i = 0 ; i < n ; i++){
            adj.add(new ArrayList<>()) ;
        }
        
        for(int[] e : edges){
            int u = e[0] ;
            int v = e[1] ;
            adj.get(u).add(v) ;
            adj.get(v).add(u) ;
        }
        
        postorder(0, -1) ;
        preorder(0, -1) ;
        return res ;
    }
    
    void postorder(int root, int parent){
        for(int nbr : adj.get(root)){ // checking the nbrs
            if(nbr == parent) continue ; // nbr is parent then skip
            postorder(nbr, root) ; // first calculate for nbrs
            count[root] += count[nbr] ; // all the node nbr has will also be node of root
            res[root] += res[nbr] + count[nbr] ; // and sum of distance of all node is summ til nbr  + all node ( that means we adding 1 distance to all the child)
        }
        
        count[root]++ ; // increasing node count for self
    }
    
    
    void preorder(int root, int parent){
        for(int nbr : adj.get(root)){
            if(nbr == parent) continue ;
            res[nbr] = res[root] - count[nbr] ; // this denotes humne root k distance se count of nodes from current node ko minus kia kyuki un sab ka distance 1 unit kam hoga nbr se.
            res[nbr] += count.length - count[nbr] ; // aur etne nodes ka distance 1 unit badh jayega kyuki hum root se 1 unit durr chal gye
            
            preorder(nbr, root) ;
        }
    }
    
}

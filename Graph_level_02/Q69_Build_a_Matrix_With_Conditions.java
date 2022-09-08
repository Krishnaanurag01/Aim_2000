package Graph_level_02;
import java.util.*;

public class Q69_Build_a_Matrix_With_Conditions {

    
    public int[][] buildMatrix(int k, int[][] rowConditions, int[][] colConditions) {
        
        // making graph
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>() ;
        for(int i = 0 ; i <= k ; i++){
            adj.add(new ArrayList<>()) ;
        }
        
        // now finding the indegree of nodes.
        int[] rowIndegree = new int[k+1] ;
        
        for(int[] row : rowConditions){
            int u = row[0] ;
            int v = row[1] ;
            
            rowIndegree[v]++ ; // as v will come after u so increasing it's indegree.
            adj.get(u).add(v) ;
        }
        
        // we will store index of row order of nodes.(the order in which nodes assigned to row.)
        HashMap<Integer,Integer> rowIdx = new HashMap<>() ;
        LinkedList<Integer> q = new LinkedList<>() ; // using q for topo sorting.
        
        for(int i = 1 ; i < rowIndegree.length ; i++){
            if(rowIndegree[i] == 0){
                q.add(i) ;
            }
        }
        
        int idx = 0 ;
        while(q.size() > 0 ){
            int rn = q.removeFirst() ;
            rowIdx.put(rn,idx++) ;
            
            for(int nbr : adj.get(rn)){
                rowIndegree[nbr]-- ;
                if(rowIndegree[nbr] == 0){
                    q.add(nbr) ;
                }
            }
        }
        
        // if any element still remains in queue then return empty array.
        if(q.size() > 0){
          System.out.println("Called From Row Ordering") ;
           return new int[0][0] ;
        } 
        
        
        
        
        // same as above but this time ordering the nodes in column order.
        // ordering col :
        
        adj = new ArrayList<>() ;
        for(int i = 0 ; i <= k ; i++){
            adj.add(new ArrayList<>()) ;
        }
        
        int[] colIndegree = new int[k+1] ;
        
        for(int[] row : colConditions){
            int u = row[0] ;
            int v = row[1] ;
            
            colIndegree[v]++ ;
            // adj.get(v).add(u) ;
            adj.get(u).add(v) ;
        }
        
        HashMap<Integer,Integer> colIdx = new HashMap<>() ;
        q = new LinkedList<>() ;
        
        for(int i = 1 ; i < colIndegree.length ; i++){
            if(colIndegree[i] == 0){
                q.add(i) ;
            }
        }
        
        idx = 0 ;
        while(q.size() > 0 ){
            int rn = q.removeFirst() ;
            colIdx.put(rn,idx++) ;
            
            for(int nbr : adj.get(rn)){
                colIndegree[nbr]-- ;
                if(colIndegree[nbr] == 0){
                    q.add(nbr) ;
                }
            }
        }
        
         if(q.size() > 0){
          System.out.println("Called From Row Ordering") ;
           return new int[0][0] ;
        } 
      
        
        
        // now making final matrix ans.
        int[][] matrix = new int[k][k] ;
        int opr = 0 ; // this will hold the count of k elements that are used so far.
        
        for(int i = 1 ; i <= k ; i++){
            if(rowIdx.containsKey(i) && colIdx.containsKey(i)){
                matrix[ rowIdx.get(i) ][ colIdx.get(i)] = i ;
                opr++ ;
            }
        }
        
        if(opr != k ) return new int[0][0]; // if we did not used all the k value then return empty array.
        
        return matrix;
    }
}

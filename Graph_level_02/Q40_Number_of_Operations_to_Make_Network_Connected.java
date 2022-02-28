package Graph_level_02;

public class Q40_Number_of_Operations_to_Make_Network_Connected {

    // using DSU Approch

    static int[] parent ;
    static int[] rank ;
    
    public int makeConnected(int n, int[][] connections) {
        
        // DSU initialization
        parent = new int[n] ;
        rank = new int[n] ;
        
        for(int i = 0 ; i < n ; i++ ) {
            parent[i] = i ;
            rank[i] = 1 ;
        }
        

        // all the edges that will not get merged is extra wire.
        int extraWires = 0 ;
        
        for(int[] conn : connections ) {
            int u  = conn[0] ;
            int v = conn[1] ;
            
            boolean isMerged = union(u,v) ;
            
            if(isMerged == false){ // when not merged means that computer is already connected so current wire is extra
                extraWires++ ;
            }
        }
        
        // this is total count of connected computers. adding +1 becuase intitally one wire connected two computer i.e 4 computers can be connected with 3 wires in minimum
        int totalConnected = connections.length - extraWires + 1 ;
        
        if(extraWires == (n-totalConnected) ){ // when extra wire is equal to count of rest unconnected computer then we will connect all the not connected computer with these wirese so return count of extra wires
            return extraWires ;
        }
        else if(extraWires > (n-totalConnected)){ // when we have more wires than the computer so we will only use wires that can connect our computer with least connections.
            return n-totalConnected ;
        }
        else{ // else when we don't have extra wires for connections then return -1.
            return -1 ;
        }
        
        
        
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

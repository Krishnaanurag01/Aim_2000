package Graph_level_02;
import java.util.*;

public class Q37_Satisfiability_of_Equality_Equations {

    // usig DSU approch

    static int[] parent ;
    static int[] rank ;
    
    public boolean equationsPossible(String[] equations) {
        
        parent = new int[26] ; // as total alphabets are 26 so making array of size 26
        rank = new int[26] ;
        
        for(int i = 0 ; i < 26 ; i++){
            parent[i] = i ;
            rank[i] = 1 ;
        }
        
        // String that has "!=" symbols
        ArrayList<String> notEquals = new ArrayList<>() ;
        
        for(int i = 0 ; i < equations.length ; i++){
            String s = equations[i] ;
            int x = s.charAt(0) - 'a';
            char op1 = s.charAt(1);
            // char op2 = s.charAt(2);
            int y = s.charAt(3) - 'a';

            if(op1 == '='){ // when String  has "==" symbol then we merged the operands using dsu operation 
                union(x,y) ;
            }
            else{ // adding not equal string in list
                notEquals.add(s) ;
            }
        }
        
        while(notEquals.size() > 0 ){
            String s = notEquals.remove(0) ;
            int x = s.charAt(0) - 'a';
            int y = s.charAt(3) - 'a';
            
            // now checking leader of both operands .
            int lx = find(x,parent) ;
            int ly = find(y,parent) ;
            // as we are checking for "!=" operators so leaders of both operands should not be equal.
            
            if( lx == ly ){
                return false ;
            }
            
        }
        
        
        return true ;
    }


    // DSU Operations.
    
    
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

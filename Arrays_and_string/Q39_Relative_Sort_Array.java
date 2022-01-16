package Arrays_and_string;
import java.util.*;

public class Q39_Relative_Sort_Array {

    public int[] relativeSortArray(int[] A1, int[] A2) {
        
        int N = A1.length ;
        int M = A2.length ;
        
         HashMap<Integer,Integer> map = new HashMap<>() ;
        for(int i : A1){
            map.put( i , map.getOrDefault(i,0) + 1 ) ;
        }
        
        ArrayList<Integer> rest = new ArrayList<>() ;
        int[] ans = new int[N] ;
        
        int k = 0 ; 
        
        for(int i = 0 ; i < M ; i++){
            
                while(map.containsKey(A2[i])){
                    
                    ans[k++] = A2[i] ;
                    
                    if ( map.get(A2[i]) == 1 ){
                        map.remove(A2[i]) ;
                    }
                    else{
                        map.put(A2[i],map.get(A2[i]) - 1 ) ;
                    }
                    
                }
        }
        
        
        for(Map.Entry<Integer, Integer> e : map.entrySet()){
            
            int key = (int) e.getKey() ;
            int freq = (int) e.getValue() ;
            
            while(freq > 0){
                rest.add(key) ;
                freq-- ;
            }

        }
        
        
        Collections.sort(rest) ; 
        
        while(rest.size() != 0){
            ans[k++] = rest.remove(0) ;
        }
        
        return ans ;
    }
    
}

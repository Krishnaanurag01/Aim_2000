package HashMaps_and_Heaps_Level_02;
import java.util.*;

public class Q52_Insert_Delete_GetRandom_O_1_Duplicates_allowed {

    // starts from here.

    class RandomizedCollection {
    
        HashMap<Integer,HashSet<Integer> > map ; // store val as key and corresponding hashset that will contain all the index of val in array list.
        
        ArrayList<Integer> list = new ArrayList<>() ; // stores all the value.
        Random r ; // for getting the random index.
    
        public RandomizedCollection() {
            
            map = new HashMap<>() ;
            list = new ArrayList<>() ;
            r = new Random() ;
            
        }
        
        public boolean insert(int val) {
            HashSet<Integer> set ;
            boolean flag ;
            if(map.containsKey(val) == true ){
                set = map.get(val) ; // getting the previous set stored in map
                flag = false ; // marking false becuase it is already present.
            }
            else{
                set = new HashSet<>() ; // or create new hashset if val not present
                flag = true ; // marking true becuase it comes first.
            }
            
            set.add( list.size() ) ; // adding new index of val in set
            list.add(val) ;
            map.put(val,set) ;
            
            return flag ;
        }
        
        public boolean remove(int val) {
            HashSet<Integer> set ;
            
            if(map.containsKey(val) == false){
                return false; // becuase item is not present.
            }
            
            set = map.get(val) ; // getting the hashset corresponding to the val.
            
            int removeIdx = -1 ;
            
            for(int i : set) // traversing in set and getting the first value.
            { // this set contains index.
                removeIdx = i ; // the value will be our removale index.
                break ;
            }
            
             set.remove(removeIdx) ; // removing the index from hashset.
            
            if(set.size() == 0){
                map.remove(val) ; // when set becomes empty then remove the entry.
            }
            
            
            if(removeIdx == list.size() - 1){ // if this index is the last index then remove directly from list.
                list.remove(list.size() - 1) ; // removing value from list
               
            }
            else{ // when index is not the last index then swap it with the last index and remove
                
                list.set( removeIdx, list.get(list.size() - 1) ) ; // setting the last index value in removeIdx. 
                // now removing the last index value.
                
                list.remove( list.size() - 1 ) ;
                
                HashSet<Integer> set2 = map.get( list.get(removeIdx) ) ;
                
                set2.remove( list.size() ) ; // removing the previous index of swapped last value
                
                set2.add(removeIdx) ; // adding the new index of swapped value.
                
            }
            
            return true ;
            
        }
        
        public int getRandom() {
            int index = r.nextInt(list.size()) ; // gives the value between 0 (including) and list size(excluding).
            return list.get(index) ;
        }
    }
    
    /**
     * Your RandomizedCollection object will be instantiated and called as such:
     * RandomizedCollection obj = new RandomizedCollection();
     * boolean param_1 = obj.insert(val);
     * boolean param_2 = obj.remove(val);
     * int param_3 = obj.getRandom();
     */



     // ends here.
    
}

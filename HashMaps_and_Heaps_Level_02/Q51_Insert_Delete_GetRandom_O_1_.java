package HashMaps_and_Heaps_Level_02;
import java.util.*;

public class Q51_Insert_Delete_GetRandom_O_1_ {

    // starts here.

    class RandomizedSet {
    
        HashMap<Integer,Integer> map ; // stores the number as key and value is index(of the value) in arraylist
        ArrayList<Integer> list ; // stores the value
        Random r ; // help in generating the random number.
    
        public RandomizedSet() { // initialization
            map = new HashMap<>() ;
            list = new ArrayList<>() ;
            r = new Random() ;
        }
        
        public boolean insert(int val) {
            if(map.containsKey(val)){
                return false ; // when already have the val then return false;
            }
            
            map.put(val,list.size()) ; // adding val and it's index in list.
            list.add(val) ; // adding val to list so that we can easily remove later.
            return true ;
        }
        
        public boolean remove(int val) {
            
            if(map.containsKey(val) == false){ // if number is not found then return false;
                return false ;
            }
            
            
            int index = map.get(val) ; // else getting the index of val(index in list).
            map.remove(val) ; // removing val from map
            
            if(index == list.size() - 1){  // if the index of val is equals to last index then we can directly remove the last number and return true as this will be done in O(1) time.
                list.remove(index) ;
                return true ;
            }
            
            // else if index is not the last index thenn we have to swap the index with last index, this will help us in achieving the delete operation in O(1) time.

            list.set(index, list.get(list.size()-1) ) ; // so swaping the last index value to index(val) 
            list.remove(list.size()-1) ; // removing the last index from list
            map.put(list.get(index), index) ; // and also updating the index of last value in map
            
            return true ;
        }
        
        public int getRandom() {
            int randomIdx = r.nextInt(list.size()) ; // getting the random number between 0 to size-1 index, last end is exclusive
            return list.get(randomIdx);
        }
    }

    
    // ends here.
    
}

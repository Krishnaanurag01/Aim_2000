package HashMaps_and_Heaps_Level_02;
import java.util.*;

public class Q60_Snapshot_Array {

    // starts here

    class SnapshotArray {
    
        HashMap<Integer,Integer>[] map ; //storesa hashmap on each index and that hashmap will have values like snap as key and corresponding value
        int currSnap ;
    
        public SnapshotArray(int length) {
            map = new HashMap[length] ;
            // initializing the hashMap
            
            for(int i = 0 ; i < length ; i++){
                map[i] = new HashMap<>() ;
            }
            currSnap = 0 ;
        }
        
        public void set(int index, int val) {
            map[index].put(currSnap,val) ; // storing current snap with val in current index.
        }
        
        public int snap() {
            currSnap++ ;
            return currSnap - 1 ;
            
        }
        
        public int get(int index, int snap_id) {
            
            while(snap_id >= 0 && map[index].containsKey(snap_id) == false){
                // look in lower snap id.
                snap_id--;
            }
            
            if(snap_id < 0){ // if snap_id becomes less than 0 then it means this index never got any value. so return 0
                return 0 ;
            }
            
            //  else return stored value corresponding to snap_id
            return map[index].get(snap_id) ;
        }
    }
    

    // ends here.
}

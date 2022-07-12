package HashMaps_and_Heaps_Level_02;
import java.util.*;;

public class Q65_Design_HashMap {

    // simplest implementation using arrays.
    class MyHashMap {
        int[] map  ;
        public MyHashMap() {
            map = new int[(int)1e6 + 1] ;
        }
        
        public void put(int key, int value) {
            map[key] = value +1 ;  // instead of storing -1 by default at each idx store freq with +1 and remove this extra one at get opration
        }
        
        public int get(int key) {
            return map[key] - 1;
        }
        
        public void remove(int key) {
            map[key] = 0 ;
        }
    }

    // optimized approch .

    class MyHashMap2 {
    
        LinkedList<Node>[] map ;
        int SIZE = 769 ; /// taking a prime number for size of array.
        public MyHashMap2() {
            map = new LinkedList[SIZE] ;
        }
        
        public void put(int key, int value) {
            int bucket = key % SIZE ;
            
            if(map[bucket] == null){
                map[bucket] = new LinkedList<>() ;
            }
            for(Node entry : map[bucket]){
                if(entry.key == key) {
                    entry.val = value ;
                    return ;
                }
            }
            
            map[bucket].add(new Node(key,value));
        }
        
        public int get(int key) {
            int bucket = key % SIZE ;
            if(map[bucket] == null) return -1 ;
            LinkedList<Node> list = map[bucket] ;
            for(Node entry : list){
                if(entry.key == key) return entry.val ;
            }
            return -1 ;
        }
        
        public void remove(int key) {
            int bucket = key % SIZE ;
            if(map[bucket] == null) return  ;
            LinkedList<Node> list = map[bucket] ;
            Node toRemove = null ;
            for(Node entry : list){
                if(entry.key == key){
                    toRemove = entry ;
                    break ;
                }
            }
            if(toRemove != null) list.remove(toRemove) ;
            return  ;
        }
    }
    
    class Node{
        int key ;
        int val ;
        Node(int x, int y){
            key = x ;
            val = y ;
        }
    }
}

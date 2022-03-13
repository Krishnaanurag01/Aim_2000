package HashMaps_and_Heaps_Level_02;
import java.util.*;

public class Q46_LRU_Cache {

     // check explanation in Stack and Queue package and Q59.
    // starts from here.

    static class LRUCache {
    
        static class Node{
            int data ;
            int key  ;
            Node next ;
            Node prev ;
            
            Node(){
            }
            
            Node(int x , int y){
                data = x ;
                key = y ;
            }
        }
        
        static Node head, tail ;
        static HashMap<Integer,Node> nodeMap ;
        static int size ;
    
        public LRUCache(int capacity) {
            nodeMap = new HashMap<>() ;
            size = capacity ;
            head = new Node() ;
            tail = new Node() ;
            
            head.next = tail ;
            tail.prev = head ;
        }
        
        public int get(int key) {
            
            if(nodeMap.size() == 0){
                return -1 ;
            }
            
            if(nodeMap.containsKey(key) == false){
                return -1 ;
            }
            
            Node node = nodeMap.get(key) ;
            int val = node.data ;
            
            update(key,val) ;
            
            return val ;
        }
        
        public void put(int key, int value) {
            
            if(nodeMap.containsKey(key)){
                
                update(key,value) ;
                return ;
            }
            
            if(nodeMap.size() >= size){
                Node p = tail.prev ;
                p.prev.next = tail ;
                tail.prev = p.prev ;
                nodeMap.remove(p.key) ;
            }
            
            Node node = new Node(value,key) ;
            
            node.next = head.next ;
            head.next.prev = node ;
            
            head.next = node;
            node.prev = head ;
            
            nodeMap.put(key,node) ;
            
            
        }
        
        public void update(int key, int val){
            
             Node node = nodeMap.get(key) ;
            node.data = val ;
            
             node.next.prev = node.prev ;
            node.prev.next = node.next ;
            
            node.next = head.next ;
            head.next.prev = node ;
            
            head.next = node;
            node.prev = head ;
            
        }
    }
    
    // ends here.
}

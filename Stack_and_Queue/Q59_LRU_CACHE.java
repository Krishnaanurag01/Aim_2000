package Stack_and_Queue;

import java.util.HashMap;

public class Q59_LRU_CACHE {


    


    static class LRUCache
    {

        static class Node { /// using dll with key and value block as well
    
            int key , value ; 
            Node next , prev ;
    
            Node(int key ,int val){
                this.key = key ;
                this.value = val ;
                next = null ;
                prev = null ;
            }
    
            Node(){
    
            }
            
        }

        static Node head  ; // this will point to most recently used node
        static Node tail ; // this will point to least recently used node
        static HashMap<Integer , Node> map ; // this will contain the address of our stored node 
        static int size ;


        //Constructor for initializing the cache capacity with the given value.
        LRUCache(int cap)
        {
            size = cap ;
            head = new Node() ;
            tail = new Node() ;
            map = new HashMap<>() ;

            head.next = tail ;
            tail.prev = head ;

        }
    
        //Function to return value corresponding to the key.
        public static int get(int key)
        {
            if(map.containsKey(key)){ // if map contains the value then
                Node preNode = map.get(key) ; 
                remove(preNode, key);  // first remove the node from dll
                set(key, preNode.value); // and add it to the front of dll with this func
                return preNode.value ; // return the stored value of that node
            }
            
            // else return  -1
            return -1 ;
        }
    
        //Function for storing key-value pair.
        public static void set(int key, int value)
        {
            if(map.containsKey(key)){ /// map already contains then do following
 
                Node preAdd = map.get(key) ; // get previous address and remove
                remove(preAdd, key);

            }
            else if( size == map.size() ){ // if size is full then remove least recently used node

                Node lastNode = tail.prev ;
                remove(lastNode, lastNode.key);

            }

            // now adding new node with given key , value in front of head (head.next)
            Node newNode = new Node(key , value) ; 
            
            newNode.next = head.next ;
            head.next.prev = newNode ;
            head.next = newNode ;
            newNode.prev = head ;
           
            map.put(key, newNode) ; // also adding entry to map.

        }

        public static void remove(Node head , int key) {
            map.remove(key) ; // first remove entry from map then remove node
            head.prev.next = head.next ;
            head.next.prev = head.prev ; 
        }
    }
    
}

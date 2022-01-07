package Greedy;
import java.util.*;

// using LRU Cache. check explanation in stack and queue package.

public class Q20_Page_Faults_in_LRU {
    
    static class Node{
        int key ;
        Node next ;
        Node prev ;
        
        Node(int x){
            key = x ;
        }

        Node(){

        }
    }
    
    static Node head ;
    static Node tail ;
    static HashMap<Integer,Node> map ;
    static int pf = 0 ;
    static int size  ;
    static int gs ;
    
    
    static int pageFaults(int N, int C, int pages[]){
        
        // ArrayList<Integer> list = new ArrayList<>() ;
        // HashMap<Integer,Integer> map = new HashMap<>() ;
        map = new HashMap<>() ;
        size = 0 ;
        gs = C ;
        
        
        head = new Node() ;
        tail = new Node() ;

        head.next = tail ;
        tail.prev = head ;
        
        for(int i = 0 ; i < C ; i++){
            
            boolean avail = get(pages[i]) ;
            
            if(avail == false){
                pf++ ;
                set(pages[i]);
            }   
        }
        

        for (int i = C ; i < pages.length; i++) {

            
            boolean avail = get(pages[i]) ;
            
            if( avail  == false){
                pf++ ;
                add_new(pages[i]) ;
            }

        }

        return pf ;
        
    }
    
    private static void add_new(int key) {

        if (size < gs) {
            set(key) ;
            return ;
        }

        Node secondLast = tail.prev.prev ; 
        int rk =secondLast.next.key ;
        // secondLast.next = null ;
        secondLast.next = tail ;
        tail.prev = secondLast ;
        map.remove(rk) ;

        set(key);
        //adding to first

        
    }

    public static boolean get(int key){
        
        if(map.containsKey(key)){
            Node preNode = map.get(key) ;
            remove(preNode) ;
            map.remove(preNode.key) ;
            set(key) ;
            return true ;
        }
        
        return false ;
    }

    private static void set(int key) {

        Node newNode = new Node(key) ;
        
        newNode.next = head.next ;
        head.next.prev = newNode ;
        head.next = newNode ;
        newNode.prev = head ;
        size++ ;

        map.put(key, newNode) ;
    }

    private static void remove(Node node) {

        node.next.prev = node.prev ;
        node.prev.next = node.next ;
        size-- ;
    }
    
    
}

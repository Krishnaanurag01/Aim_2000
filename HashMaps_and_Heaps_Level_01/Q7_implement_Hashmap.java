package HashMaps_and_Heaps_Level_01;

import java.util.ArrayList;
import java.util.LinkedList;

import Linked_List.Q10_Add_two_numbers_represented_by_linked_lists.node;

public class Q7_implement_Hashmap {

    public static void main(String[] args) {
        

    }
    
}

class hashmap<K,V> {
    
    static class HMNode<K,V>{
        
        K key ;  // value
        V value ; // value

        HMNode(K x , V y ){
            key = x ;
            value = y ;
        }
    }


    private int size ;
    private LinkedList<HMNode>[] buckets  ;

    hashmap(){
        intialize(4) ;
        size = 0 ;
    }

    private void intialize(int s) {

        buckets = new LinkedList[s] ;
        
        for (int i = 0; i < buckets.length; i++) {
            buckets[i] = new LinkedList<>() ;
        }
    }

    public void put(K key, V value) throws Exception{
        int bi = hash(key) ;
        int di = getIndexWithinBucket(key,bi) ;

        if(di != -1){
            HMNode node = buckets[bi].get(di) ;
            node.value = value ;
        }
        else{
            HMNode node = new HMNode(key, value) ;
            buckets[bi].add(node) ;
            size++ ;
        }

        double lambda = size * 1.0 / buckets.length ;

        if(lambda > 2.0){
            rehash() ;
        }
    }


    private void rehash() {
        LinkedList<HMNode>[] old = buckets ;

        intialize(old.length * 2);

        for (int i = 0; i < old.length; i++) {
            for (HMNode node : old[i]) {
                // put(node.key, node.value);
            }
        }
    }

    public boolean containsKey(K key){
        int bi = hash(key) ;
        int di = getIndexWithinBucket(key, bi) ;

        if(di == -1){
            return false ;
        }
        else{
            return true ;
        }
    }


    public V remove(K key) throws Exception {

        int bi = hash(key) ;
        int di = getIndexWithinBucket(key, bi) ;

        if(di == -1){
            return null ;
        }
        else{
            HMNode node = buckets[bi].remove(di) ;
            size-- ;
            return (V) node.value ;
        }
    }


    public ArrayList<K> keySet(){

        ArrayList<K> list = new ArrayList<>() ;

        for (int i = 0; i < buckets.length; i++) {
            for (HMNode node : buckets[i] ) {
                list.add( (K) node.key) ;
            }
        }

        return list ;
    }



    private int getIndexWithinBucket(K key, int bi) {

        int di = 0 ;
        for (HMNode node : buckets[bi]) {
            if(node.key.equals(key)){
                return di ;
            }          
            di++ ;  
        }

        return -1;
    }

    public int hash(K key){
        int idx = key.hashCode() ;

        return Math.abs(idx % size) ;
    }

    public int size(){
        return size ;
    }



}

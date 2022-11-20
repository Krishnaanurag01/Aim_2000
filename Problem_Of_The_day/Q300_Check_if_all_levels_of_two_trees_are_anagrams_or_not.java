package Problem_Of_The_day;
import java.util.*;

public class Q300_Check_if_all_levels_of_two_trees_are_anagrams_or_not {

    public static boolean areAnagrams(Node node1, Node node2) {
        
        // using queue for both trees
        LinkedList<Node> ll1 = new LinkedList<>() ;
        LinkedList<Node> ll2 = new LinkedList<>() ;
        
        ll1.add(node1) ;
        ll2.add(node2) ;
        
        while(ll1.size() > 0 && ll2.size() > 0){
            if(ll1.size() != ll2.size() ) return false; // if at the same level number of elements present is different then false
            int size = ll1.size() ;
            
            // using map for storing freq.
            HashMap<Integer,Integer> map1 = new HashMap<>() ;
            HashMap<Integer,Integer> map2 = new HashMap<>() ;
        
            
            while(size-- > 0){
                Node n1 = ll1.removeFirst();
                Node n2 = ll2.removeFirst();
                
                // adding both level element in thier respective maps
                map1.put(n1.data, map1.getOrDefault(n1.data,0)+1) ;
                map2.put(n2.data, map2.getOrDefault(n2.data,0)+1) ;
                
                
                // now adding children in the list.
                if(n1.left != null) ll1.add(n1.left) ;
                if(n1.right != null) ll1.add(n1.right) ;
                
                if(n2.left != null) ll2.add(n2.left) ;
                if(n2.right != null) ll2.add(n2.right);
            }
            
            if(map1.equals(map2) == false) return false;
        }
        
        return true ;
    }

    class Node{
        int data ;
        Node left,right ;
    }
}

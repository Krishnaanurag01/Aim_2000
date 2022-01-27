package Searching_Sorting_level_02;
import java.util.*;

public class Q6_Find_K_Closest_Elements {


    // method 01 : 

    class Pair implements Comparable<Pair>{
        int value ;
        int distance ;
        
        Pair(int x, int y){
            value = x ;
            distance = y ;
        }
        
        public int compareTo(Pair o){
          
            if(this.distance == o.distance){ // when distanc same then sorting on value
                return this.value - o.value ;
            }
            else{ // else sorting on distance
                return this.distance - o.distance ;
        }
        
        
    }
        
    }
    
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        
        PriorityQueue<Pair> q = new PriorityQueue<>() ;
        
        for(int in : arr){
            q.add( new Pair(in,Math.abs(in-x))) ;
        }
        
        List<Integer> ans = new ArrayList<>() ;
        
        while(k-- > 0) ans.add(q.poll().value) ;
        
        Collections.sort(ans) ;
        
        return ans ;
    }
    

    // method 02 :

    public List<Integer> findClosestElements2(int[] arr, int k, int x) {
        
        PriorityQueue<Pair> q = new PriorityQueue<>( Collections.reverseOrder() ) ;
        
        
        for(int i = 0 ; i < arr.length ; i++){

            if(q.size() < k ){
                q.add(new Pair(arr[i], Math.abs(arr[i] - x))) ;
            }
            else{
                if (q.peek().distance > Math.abs(arr[i] - x )) {
                    q.remove() ;
                    q.add(new Pair(arr[i], Math.abs(arr[i] - x))) ;
                }
            }
        }
        
        List<Integer> ans = new ArrayList<>() ;
        
        while(k-- > 0) ans.add(q.poll().value) ;
        
        Collections.sort(ans) ;
        
        return ans ;
    }
    

}

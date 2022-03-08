package HashMaps_and_Heaps_Level_01;
import java.util.*;

public class Q5_Merge_k_Sorted_Arrays {


    // method 01 : brute force! take o(k*k) extra space.
    public static ArrayList<Integer> mergeKArrays(int[][] arr,int K) 
    {
        
        ArrayList<Integer> list = new ArrayList<>() ;
        
        PriorityQueue<Integer> q = new PriorityQueue<>() ;
        
        for(int[] a : arr){
            for(int i : a){
                q.add(i) ;
            }
        }
        
        while(q.size() > 0 )
        list.add(q.remove()) ;
        
        
        return list ;
    }
    






    // method 02 : takes only o(k) extra space.
    static class pair implements Comparable<pair> {
        int ai ; // array index ->  indentify which particular ith array you belong to
        int di ; // data index - > index of current data in ith array
        int val ; // value

        pair(int x, int y , int z){
            this.ai = x ;
            this.di = y ;
            this.val = z ;
        }

        // sort on the basis of value.
        public int compareTo(pair o){

            return this.val - o.val ;
        }
    }


    public static ArrayList<Integer> mergeKArrays2(int[][] arr,int K) 
    {
        
        ArrayList<Integer> list = new ArrayList<>() ;
        
        PriorityQueue<pair> q = new PriorityQueue<>() ;
        

        // step 1 : adding starting value of every k array by making a pair.
        for (int i = 0; i < arr.length; i++) {
            pair p = new pair(i, 0, arr[i][0]) ;
            q.add(p) ;
        }
        
        while(q.size() > 0 ){ 
            pair rp = q.remove() ; // removed pair with smallest element
            list.add(rp.val) ;

            // checking if removed array element has any next element if yes then adding it to q
            if(rp.di < arr[rp.ai].length-1){
                pair npair = new pair(rp.ai, rp.di+1, arr[rp.ai][rp.di+1] ) ;
                q.add(npair) ;
            }

        }
        
        
        return list ;
    }


}

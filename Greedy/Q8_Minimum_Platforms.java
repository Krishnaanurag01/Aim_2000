package Greedy;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Q8_Minimum_Platforms {

    static class Pair implements Comparable<Pair> {
        
        int st ; 
        int et ;

        Pair(int x , int y){
            st = x ;
            et = y ;
        }

        public int compareTo(Pair obj){
            return this.et - obj.et ;
        }
    }
    

    static int findPlatform(int arr[], int dep[], int n)
    {

        PriorityQueue<Pair> q = new PriorityQueue<>() ;
       
       for (int i = 0; i < dep.length; i++) {
           q.add( new Pair(arr[i], dep[i])) ;
       }

       int ans = 0 ;

       while (!q.isEmpty()) {
           PriorityQueue<Pair> iq = new PriorityQueue<>() ;

           int ld = 0 ;
           ans++ ;
           while (!q.isEmpty()) {
               Pair rp = q.poll() ;

               if (rp.st >= ld) {
                   ld = rp.et ;
               }
               else{
                   iq.add(rp) ;
               }
           }

           q = iq ;
       }
        


        return ans ;
    }


    static int findPlatform2(int arr[], int dep[], int n)
    {
        int[][] pairArr = new int[n][n] ;
        
        for (int i = 0; i < n; i++) {
            pairArr[i][0] = arr[i] ;
            pairArr[i][1] = dep[i] ;
        }


        Arrays.sort(pairArr,  (a,b) -> a[1] - b[1]);

        int c = 0 ;

        // while(){

        // }




        return 0 ;
        
    }

}

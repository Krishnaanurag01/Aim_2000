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


    //method 02

    static int findPlatform2(int arr[], int dep[], int n)
    {
     
        Arrays.sort(arr) ; // sorting the trains on starting time.
        Arrays.sort(dep) ; // and also sorting the dept time of trains.
        
        int cp = 1 ; // took current platform is 1.
        int max_pl = 1 ; // max platform
        
        int i = 1 ;// starting from 1 as we took cp 1 means 0th train is already standing on 1 platform.
        int j = 0 ;// this denotes the depart index of trains.
        
        while(i < n){
            // arrival time is greater than depart time of j then it means train i will arrive after depart of j train so departing and as we depart so we have left space of 1 platform so decrementing.
            if( j < i && arr[i] > dep[j]){
                cp-- ;
                j++; // moving to next depart of train
            }
            
            cp++ ; // and one train arrives so increasing the platform
            i++ ;
            // updating max platform.
            max_pl = Math.max(cp,max_pl) ;
            
            
        }
        
        return max_pl ;
    }

}
